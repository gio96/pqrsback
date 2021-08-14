package org.btg.gateway;

import org.btg.entities.Solicitud;

import java.util.List;

public interface ReclamoGateway {
    Solicitud getReclamo(String idReclamo);

    void saveReclamo(Solicitud solicitud);

    List<Solicitud> getAllReclamo();
}
