package org.btg.usecase;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Reclamo;
import org.btg.entities.Solicitud;
import org.btg.gateway.ReclamoGateway;
import org.btg.gateway.SolicitudGateway;
import org.btg.usecase.exceptions.SolicitudException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiFunction;

import static org.btg.usecase.StringUtils.esVacio;

@RequiredArgsConstructor
public class ReclamoUseCase {

    private final ReclamoGateway reclamoGateway;
    private final SolicitudGateway solicitudGateway;

    public Solicitud getReclamo(String idSolicitud, String idReclamo) {
        return reclamoGateway.getReclamo(idSolicitud, idReclamo);
    }

    public List<Solicitud> getAllReclamo(){
        return reclamoGateway.getAllReclamo();
    }

    public void saveReclamo(String idSolicitud, Reclamo reclamo) {
        reclamoGateway.saveReclamo(validarDatosObligatorios(idSolicitud, reclamo));
    }

    public Solicitud validarDatosObligatorios(String idSolicitud, Reclamo reclamo) {
        return Optional.of(reclamo)
                .filter(reclamo1 -> !esVacio(reclamo1.getDescripcionSolicitud()))
                .map(reclamo1 -> verificarCreacionReclamo(reclamo1, idSolicitud))
                //.map(this::generarFechaRegistro)
                .orElseThrow(SolicitudException.Type.SOLICITUD_NOT_FULL::build);
    }

    private Solicitud verificarCreacionReclamo(Reclamo reclamo, String idSolicitud) {
        return Optional.of(getSolicitudId.apply(solicitudGateway, idSolicitud))
                .filter(solicitud -> Objects.isNull(solicitud.getReclamo()))
                //.filter(solicitud -> Objects.isNull(solicitud.getRespuestaAdministrativa()))
                .filter(this::validarFechaSolicitud)
                .map(solicitud -> generarFechaReclamo(solicitud, reclamo))
                .orElseThrow(SolicitudException.Type.RECLAMO_NOT_ABLE::build);
    }

    private boolean validarFechaSolicitud(Solicitud solicitud) {
        Period periodo = Period.ofDays(5);
        if (Objects.isNull(solicitud.getRespuestaAdministrativa())) {
            if (solicitud.getFechaSolicitud().plus(periodo).isBefore(LocalDate.now())) {
                return true;
            } else {
                throw SolicitudException.Type.SOLICITUD_NOT_5_DAYS.build();
            }
        } else {
            return true;
        }
    }

    private Solicitud generarFechaReclamo(Solicitud solicitud, Reclamo reclamo) {
        return Solicitud.solicitudBuilder()
                .id(solicitud.getId())
                .fechaSolicitud(solicitud.getFechaSolicitud())
                .respuestaAdministrativa(solicitud.getRespuestaAdministrativa())
                .descripcionSolicitud(solicitud.getDescripcionSolicitud())
                .tipoSolicitud(solicitud.getTipoSolicitud())
                .reclamo(Reclamo.reclamoBuilder()
                        .id(UUID.randomUUID().toString())
                        .fechaSolicitud(LocalDate.now())
                        .descripcionSolicitud(reclamo.getDescripcionSolicitud())
                        .build())
                .build();
    }

    private static final BiFunction<SolicitudGateway, String, Solicitud> getSolicitudId = (solicitudGateway, id) -> {
        return Optional.ofNullable(solicitudGateway.getSolicitud(id))
                .filter(solicitud -> Objects.nonNull(solicitud.getId()))
                .orElseThrow(SolicitudException.Type.SOLICITUD_NOT_FOUND::build);
    };
}
