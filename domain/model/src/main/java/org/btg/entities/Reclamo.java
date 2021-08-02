package org.btg.entities;

import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Reclamo extends Pqr{

    @Builder(builderMethodName = "reclamoBuilder")
    public Reclamo(String id, Date fechaSolicitud, String respuestaAdministrativa, String descripcionSolicitud) {
        super(id, fechaSolicitud, respuestaAdministrativa, descripcionSolicitud);
    }
}
