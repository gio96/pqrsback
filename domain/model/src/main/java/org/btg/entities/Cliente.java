package org.btg.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private String id;
    private DocumentoIdentificacion identificacion;
    private List<Pqr> pqr;
}
