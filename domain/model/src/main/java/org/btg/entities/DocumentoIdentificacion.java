package org.btg.entities;

import lombok.*;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoIdentificacion {

    private String tipo;
    private String numero;
}
