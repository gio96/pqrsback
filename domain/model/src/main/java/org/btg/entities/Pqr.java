package org.btg.entities;

import lombok.*;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Pqr {
    private String id;
    private Date fechaRegistro;
    private String respuestaAdministrativa;
    private String descripcionPqr;
    private String tipoSolicitud;
    private Reclamo reclamo;
}
