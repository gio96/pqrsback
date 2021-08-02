package org.btg.entities;

import lombok.*;

import java.util.Date;

//@Data
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud extends Pqr {
    private TipoSolicitud tipoSolicitud;
    private Reclamo reclamo;

    @Builder(builderMethodName = "solicitudBuilder")
    public Solicitud(String id, Date fechaSolicitud, String respuestaAdministrativa, String descripcionSolicitud, TipoSolicitud tipoSolicitud, Reclamo reclamo) {
        super(id, fechaSolicitud, respuestaAdministrativa, descripcionSolicitud);
        this.tipoSolicitud = tipoSolicitud;
        this.reclamo = reclamo;
    }

//    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
//        this.tipoSolicitud = tipoSolicitud;
//    }
//
//    public void setReclamo(Reclamo reclamo) {
//        this.reclamo = reclamo;
//    }
}
