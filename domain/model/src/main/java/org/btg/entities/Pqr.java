package org.btg.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pqr {
    private String id;
    private LocalDate fechaSolicitud;
    private String respuestaAdministrativa;
    private String descripcionSolicitud;
}
