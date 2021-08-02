package org.btg.entities;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud extends Pqr {
    private TipoSolicitud tipoSolicitud;
    private Reclamo reclamo;

    @Builder(builderMethodName = "solicitudBuilder")
    public Solicitud(String id, LocalDate fechaSolicitud, String respuestaAdministrativa, String descripcionSolicitud, TipoSolicitud tipoSolicitud, Reclamo reclamo) {
        super(id, fechaSolicitud, respuestaAdministrativa, descripcionSolicitud);
        this.tipoSolicitud = tipoSolicitud;
        this.reclamo = reclamo;
    }
}
