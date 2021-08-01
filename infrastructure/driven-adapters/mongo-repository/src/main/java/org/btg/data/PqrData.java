package org.btg.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.btg.entities.Reclamo;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PqrData {
    private String id;
    private Date fechaRegistro;
    private String respuestaAdministrativa;
    private String descripcionPqr;
    private String tipoSolicitud;
    private Reclamo reclamo;
}
