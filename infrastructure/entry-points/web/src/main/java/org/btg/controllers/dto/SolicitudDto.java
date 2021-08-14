package org.btg.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.btg.entities.TipoSolicitud;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDto {
    private String descripcionSolicitud;
    private TipoSolicitud tipoSolicitud;
}
