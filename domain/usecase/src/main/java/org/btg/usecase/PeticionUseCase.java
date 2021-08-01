package org.btg.usecase;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Peticion;
import org.btg.gateway.PeticionGateway;
import org.btg.usecase.exceptions.PeticionException;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
public class PeticionUseCase {

    private final PeticionGateway peticionGateway;

    public Peticion getPeticion(String idPeticion) {
        return peticionGateway.getPeticion(idPeticion);
    }

    public List<Peticion> getAllPeticion(String tipo, String numero) {
        return peticionGateway.getAllPeticiones(tipo, numero);
    }

    public void savePeticion(Peticion peticion) {
        peticionGateway.savePeticion(validarDatosObligatorios(peticion));
    }

    public Peticion validarDatosObligatorios(Peticion peticion) {
        return Optional.of(peticion)
                .filter(peticion1 -> !esVacio(peticion1.getDescripcionPeticion()))
                .filter(peticion1 -> Objects.nonNull(peticion1.getIdentificacionCliente()))
                .filter(peticion1 -> !esVacio(peticion1.getIdentificacionCliente().getTipo()))
                .filter(peticion1 -> !esVacio(peticion1.getIdentificacionCliente().getNumero()))
                .map(this::generarFechaRegistro)
                .orElseThrow(PeticionException.Type.PETICION_NOT_FULL::build);
    }

    private Peticion generarFechaRegistro(Peticion peticion) {
        return Peticion.builder()
                .descripcionPeticion(peticion.getDescripcionPeticion())
                .identificacionCliente(peticion.getIdentificacionCliente())
                .fechaRegistro(new Date())
                .build();
    }

    //TODO
    private boolean validarIdentificacionCliente(Peticion peticion) {
        if (Objects.nonNull(peticion.getIdentificacionCliente())) {
            if (esVacio(peticion.getIdentificacionCliente().getNumero()) ||
                    esVacio(peticion.getIdentificacionCliente().getTipo())) {
                throw PeticionException.Type.PETICION_NOT_FULL.build();
            } else {
                return true;
            }
        } else {
            throw PeticionException.Type.PETICION_NOT_FULL.build();
        }
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
