package org.btg.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Solicitud;
import org.btg.gateway.SolicitudGateway;
import org.btg.peticion.GuardarSolicitudRepository;
import org.btg.peticion.ObtenerSolicitudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SolicitudGatewayImpl implements SolicitudGateway {

    private final ObtenerSolicitudRepository obtenerSolicitudRepository;
    private final GuardarSolicitudRepository guardarSolicitudRepository;

    @Override
    public Solicitud getSolicitud(String idSolicitud) {
        return obtenerSolicitudRepository.getSolicitud(idSolicitud)
                .orElse(Solicitud.solicitudBuilder().build());
    }

    @Override
    public List<Solicitud> getAllSolicitud() {
        return obtenerSolicitudRepository.getAllPeticion();
    }

    @Override
    public void saveSolicitud(Solicitud solicitud) {
        guardarSolicitudRepository.saveSolicitud(solicitud);
    }
}
