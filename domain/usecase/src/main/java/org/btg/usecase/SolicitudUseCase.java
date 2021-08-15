package org.btg.usecase;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Solicitud;
import org.btg.gateway.SolicitudGateway;
import org.btg.usecase.exceptions.SolicitudException;

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

    public List<Solicitud> getAllSolicitud() {
        return solicitudGateway.getAllSolicitud();
    }

    public void saveSolicitud(Solicitud solicitud) {
        solicitudGateway.saveSolicitud(validarDatosObligatorios(solicitud));
    }

    private Solicitud validarDatosObligatorios(Solicitud solicitud) {
        return Optional.of(solicitud)
                .filter(solicitud1 -> !esVacio(solicitud1.getDescripcionSolicitud()))
                .map(this::generarFechaRegistro)
                .orElseThrow(SolicitudException.Type.SOLICITUD_NOT_FULL::build);
    }

    private Solicitud generarFechaRegistro(Solicitud solicitud) {
        return Solicitud.solicitudBuilder()
                .descripcionSolicitud(solicitud.getDescripcionSolicitud())
                .fechaSolicitud(LocalDate.now())
                .tipoSolicitud(solicitud.getTipoSolicitud())
                .build();
    }
}
