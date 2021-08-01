package org.btg.gateway;

import org.btg.entities.Reclamo;

public interface ReclamoGateway {
    Reclamo getReclamo(String idPeticion,String idReclamo);

    void saveReclamo(String idPeticion,Reclamo reclamo);
}
