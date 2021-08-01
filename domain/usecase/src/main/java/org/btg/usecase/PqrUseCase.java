package org.btg.usecase;

import com.sun.corba.se.spi.ior.ObjectId;
import lombok.RequiredArgsConstructor;
import org.btg.entities.Cliente;
import org.btg.entities.Pqr;
import org.btg.gateway.PqrGateway;
import org.btg.usecase.exceptions.PeticionException;

import java.util.*;

@RequiredArgsConstructor
public class PqrUseCase {

    private final PqrGateway pqrGateway;

    public Pqr getPeticion(String idPeticion) {
        return pqrGateway.getPeticion(idPeticion);
    }

    public List<Pqr> getAllPeticion(String tipo, String numero) {
        return pqrGateway.getAllPeticiones(tipo, numero);
    }

    public void savePqr(Cliente cliente) {
        pqrGateway.savePqr(validarDatosObligatorios(cliente));
    }

    private Cliente validarDatosObligatorios(Cliente cliente) {
        return Optional.of(cliente)
                .filter(cliente1 -> Objects.nonNull(cliente1.getPqr()))
                .filter(this::validarDocumentoIdentificacion)
                .map(this::generarFechaRegistro)
                .orElseThrow(PeticionException.Type.PETICION_NOT_FULL::build);
    }

    private boolean validarDocumentoIdentificacion(Cliente cliente) {
        return Optional.of(cliente)
                .filter(cliente1 -> Objects.nonNull(cliente1.getIdentificacion()))
                .filter(cliente1 -> !esVacio(cliente1.getIdentificacion().getTipo()))
                .filter(cliente1 -> !esVacio(cliente1.getIdentificacion().getNumero()))
                .isPresent();
    }

    private Cliente generarFechaRegistro(Cliente cliente) {
        return Cliente.builder()
                .pqr(constuirPqr(cliente.getPqr()))
                .identificacion(cliente.getIdentificacion())
                .build();
    }


    private List<Pqr> constuirPqr(List<Pqr> pqr) {
        return Collections.singletonList(Pqr.builder()
                .descripcionPqr(pqr.get(0).getDescripcionPqr())
                .tipoSolicitud(pqr.get(0).getTipoSolicitud())
                .fechaRegistro(new Date())
                .id(UUID.randomUUID().toString())
                .build());
    }


    private boolean esVacio(String... strings) {
        boolean vacio = false;
        for (String str : strings) {
            vacio = vacio || esVacio(str);
        }
        return vacio;
    }

    private boolean esVacio(String value) {
        return value == null || value.isEmpty();
    }

}
