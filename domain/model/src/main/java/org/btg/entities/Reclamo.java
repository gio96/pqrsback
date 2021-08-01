package org.btg.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Reclamo {
    private String idReclamo;
    private String descripcionReclamo;
    private Date fechaReclamo;
    private String respuestaAdministrativa;
}
