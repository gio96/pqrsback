package org.btg.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Reclamo;
import org.btg.entities.Solicitud;
import org.btg.gateway.ReclamoGateway;
import org.btg.peticion.GuardarSolicitudRepository;
import org.btg.peticion.ObtenerSolicitudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReclamoGatewayImpl implements ReclamoGateway {

    private final GuardarSolicitudRepository guardarSolicitudRepository;
    private final ObtenerSolicitudRepository obtenerSolicitudRepository;

    @Override
    public Solicitud getReclamo(String idPeticion, String idReclamo) {
        return obtenerSolicitudRepository.getReclamoId(idReclamo)
                .orElse(Solicitud.solicitudBuilder().build());
    }

    @Override
    public void saveReclamo(Solicitud solicitud) {
        guardarSolicitudRepository.saveSolicitud(solicitud);
    }

    @Override
    public List<Solicitud> getAllReclamo() {
        return obtenerSolicitudRepository.getAllReclamo();
    }
}
