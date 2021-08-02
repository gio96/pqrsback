package org.btg.entities;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pqr {
    private String id;
    private Date fechaSolicitud;
    private String respuestaAdministrativa;
    private String descripcionSolicitud;
}
