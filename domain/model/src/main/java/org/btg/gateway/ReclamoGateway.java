package org.btg.gateway;

import org.btg.entities.Reclamo;
import org.btg.entities.Solicitud;

public interface ReclamoGateway {
    Solicitud getReclamo(String idPeticion,String idReclamo);

    void saveReclamo(Solicitud solicitud);
}
