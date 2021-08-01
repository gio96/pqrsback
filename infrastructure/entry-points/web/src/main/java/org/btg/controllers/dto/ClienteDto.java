package org.btg.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.btg.entities.DocumentoIdentificacion;
import org.btg.entities.Pqr;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private DocumentoIdentificacionDto identificacion;
    private PqrDto pqr;
}
