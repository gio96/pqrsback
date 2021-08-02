package org.btg.usecase;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Solicitud;
import org.btg.entities.Pqr;
import org.btg.gateway.PeticionGateway;
import org.btg.usecase.exceptions.PeticionException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.btg.usecase.StringUtils.esVacio;

@RequiredArgsConstructor
public class PeticionUseCase {

    private final PeticionGateway peticionGateway;

    public Solicitud getPeticion(String idPeticion) {
        return peticionGateway.getSolicitud(idPeticion);
    }

    public List<Solicitud> getAllPeticion(String tipo, String numero) {
        return peticionGateway.getAllSolicitud(tipo, numero);
    }

    public void saveSolicitud(Solicitud solicitud) {
        peticionGateway.saveSolicitud(validarDatosObligatorios(solicitud));
    }

    public Solicitud validarDatosObligatorios(Solicitud solicitud) {
        return Optional.of(solicitud)
                .filter(solicitud1 -> !esVacio(solicitud1.getDescripcionSolicitud()))
                //TODO validar tipoSolicitud
                .map(this::generarFechaRegistro)
                .orElseThrow(PeticionException.Type.PETICION_NOT_FULL::build);
    }

    private Solicitud generarFechaRegistro(Solicitud solicitud) {
        return Solicitud.solicitudBuilder()
                .descripcionSolicitud(solicitud.getDescripcionSolicitud())
                .fechaSolicitud(new Date())
                .tipoSolicitud(solicitud.getTipoSolicitud())
                .build();
    }

    /*public Pqr validarDatosObligatorios(Pqr pqr) {
        return Optional.of(pqr)
                .filter(peticion1 -> !esVacio(peticion1.getDescripcionPeticion()))
                .map(this::generarFechaRegistro)
                .orElseThrow(PeticionException.Type.PETICION_NOT_FULL::build);
    }

    private Pqr generarFechaRegistro(Pqr pqr) {
        return Pqr.builder()
                .descripcionPeticion(pqr.getDescripcionPeticion())
                .fechaRegistro(new Date())
                .tipoSolicitud("Peticion")
                .build();
    }*/
}
