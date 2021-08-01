package org.btg.usecase;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Reclamo;
import org.btg.gateway.ReclamoGateway;

@RequiredArgsConstructor
public class ReclamoUseCase {

    private final ReclamoGateway reclamoGateway;

    public Reclamo getReclamo(String idPeticion,String idReclamo) {
        return reclamoGateway.getReclamo(idPeticion,idReclamo);
    }

    public void saveReclamo(String idPeticion, Reclamo reclamo) {
        reclamoGateway.saveReclamo(idPeticion, reclamo);
    }
}
