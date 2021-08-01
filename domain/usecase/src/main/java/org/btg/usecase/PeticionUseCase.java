package org.btg.usecase;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Pqr;
import org.btg.gateway.PeticionGateway;
import org.btg.usecase.exceptions.PeticionException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PeticionUseCase {

    private final PeticionGateway peticionGateway;

    public Pqr getPeticion(String idPeticion) {
        return peticionGateway.getPeticion(idPeticion);
    }

    public List<Pqr> getAllPeticion(String tipo, String numero) {
        return peticionGateway.getAllPeticiones(tipo, numero);
    }

    public void savePeticion(Pqr pqr) {
        peticionGateway.savePeticion(validarDatosObligatorios(pqr));
    }

    public Pqr validarDatosObligatorios(Pqr pqr) {
        return Optional.of(pqr)
                .filter(peticion1 -> !esVacio(peticion1.getDescripcionPeticion()))
                .filter(peticion1 -> !esVacio(peticion1.getTipoSolicitud()))
                .map(this::generarFechaRegistro)
                .orElseThrow(PeticionException.Type.PETICION_NOT_FULL::build);
    }

    private Pqr generarFechaRegistro(Pqr pqr) {
        return Pqr.builder()
                .descripcionPeticion(pqr.getDescripcionPeticion())
                .fechaRegistro(new Date())
                .tipoSolicitud(pqr.getTipoSolicitud())
                .build();
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
