package org.btg.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Reclamo;
import org.btg.gateway.ReclamoGateway;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReclamoGatewayImpl implements ReclamoGateway {

    @Override
    public Reclamo getReclamo(String idPeticion, String idReclamo) {
        return null;
    }

    @Override
    public void saveReclamo(String idPeticion, Reclamo reclamo) {

    }
}
