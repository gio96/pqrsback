package org.btg.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Cliente")
public class ClienteData {

    @Id
    private String id;
    private DocumentoIdentificacionData identificacion;
    private List<PqrData> pqr;
}
