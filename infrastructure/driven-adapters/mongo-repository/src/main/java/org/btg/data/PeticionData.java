package org.btg.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.btg.entities.DocumentoIdentificacion;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Peticion")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PeticionData {
    @Id
    private String id;
    private Date fechaRegistro;
    private String respuestaAdministrativa;
    private DocumentoIdentificacion identificacionCliente;
    private String descripcionPeticion;
}
