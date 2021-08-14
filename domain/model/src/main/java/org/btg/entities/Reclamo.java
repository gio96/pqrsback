package org.btg.entities;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Reclamo extends Pqr {

    @Builder(builderMethodName = "reclamoBuilder")
    public Reclamo(String id, LocalDate fechaSolicitud, String respuestaAdministrativa, String descripcionSolicitud) {
        super(id, fechaSolicitud, respuestaAdministrativa, descripcionSolicitud);
    }
}
