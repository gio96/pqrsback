package org.btg.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Reclamo;
import org.btg.entities.Solicitud;
import org.btg.gateway.ReclamoGateway;
import org.btg.peticion.GuardarSolicitudRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReclamoGatewayImpl implements ReclamoGateway {

    private final GuardarSolicitudRepository guardarSolicitudRepository;

    @Override
    public Reclamo getReclamo(String idPeticion, String idReclamo) {
        return null;
    }

    @Override
    public void saveReclamo(Solicitud solicitud) {
        guardarSolicitudRepository.saveSolicitud(solicitud);
    }
}
