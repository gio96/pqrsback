package org.btg.usecase;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Solicitud;
import org.btg.gateway.SolicitudGateway;
import org.btg.usecase.exceptions.PeticionException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.btg.usecase.StringUtils.esVacio;

@RequiredArgsConstructor
public class SolicitudUseCase {

    private final SolicitudGateway solicitudGateway;

    public Solicitud getSolicitud(String idPeticion) {
        return solicitudGateway.getSolicitud(idPeticion);
    }

    public List<Solicitud> getAllSolicitud(String tipo, String numero) {
        return solicitudGateway.getAllSolicitud(tipo, numero);
    }

    public void saveSolicitud(Solicitud solicitud) {
        solicitudGateway.saveSolicitud(validarDatosObligatorios(solicitud));
    }

    public Solicitud validarDatosObligatorios(Solicitud solicitud) {
        return Optional.of(solicitud)
                .filter(solicitud1 -> !esVacio(solicitud1.getDescripcionSolicitud()))
                //TODO validar tipoSolicitud
                .map(this::generarFechaRegistro)
                .orElseThrow(PeticionException.Type.PETICION_NOT_FULL::build);
    }

    private Solicitud generarFechaRegistro(Solicitud solicitud) {
        //TODO
        //LocalDate hoy = LocalDate.now();
        //Period periodo = Period.ofDays(1);
        //LocalDate hola = hoy.plus(periodo);
        //Date prueba = new Date();

        return Solicitud.solicitudBuilder()
                .descripcionSolicitud(solicitud.getDescripcionSolicitud())
                .fechaSolicitud(LocalDate.now())
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
