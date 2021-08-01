package org.btg.entities;

import lombok.*;

import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Peticion {
    private String id;
    private Date fechaRegistro;
    private String respuestaAdministrativa;
    private DocumentoIdentificacion identificacionCliente;
    private String descripcionPeticion;
}
