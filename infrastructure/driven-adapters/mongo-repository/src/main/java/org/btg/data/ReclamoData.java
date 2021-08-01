package org.btg.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ReclamoData {
    @Id
    private String idReclamo;
    private String descripcionReclamo;
    private Date fechaReclamo;
    private String respuestaAdministrativa;
}
