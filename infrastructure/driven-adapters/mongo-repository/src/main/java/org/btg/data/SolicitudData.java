package org.btg.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.btg.entities.Reclamo;
import org.btg.entities.TipoSolicitud;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "Solicitud")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudData {
    @Id
    private String id;
    private LocalDate fechaSolicitud;
    private String respuestaAdministrativa;
    private String descripcionSolicitud;
    private TipoSolicitud tipoSolicitud;
    private Reclamo reclamo;
}
