package org.btg.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class PeticionDto {
    private String id;
    private String descripcionPeticion;
    private String tipoSolicitud;
}
