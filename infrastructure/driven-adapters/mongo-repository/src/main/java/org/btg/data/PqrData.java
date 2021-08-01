package org.btg.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Pqr")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PqrData {
    @Id
    private String id;
    private Date fechaRegistro;
    private String respuestaAdministrativa;
    private String descripcionPeticion;
    private String tipoSolicitud;
}
