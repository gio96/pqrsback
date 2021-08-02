package org.btg.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TipoSolicitud {
    PETICION("Peticion"),
    QUEJA("Queja");

    private String tipoSolicitud;

    @Override
    public String toString() {
        return tipoSolicitud;
    }
}
