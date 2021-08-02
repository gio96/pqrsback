package org.btg.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Pqr;
import org.btg.entities.Solicitud;
import org.btg.gateway.PeticionGateway;
import org.btg.peticion.GuardarSolicitudRepository;
import org.btg.peticion.ObtenerPeticionRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PeticionGatewayImpl implements PeticionGateway {

    private final ObtenerPeticionRepository obtenerPeticionRepository;
    private final GuardarSolicitudRepository guardarSolicitudRepository;

    @Override
    public Solicitud getSolicitud(String idPeticion) {
        return Solicitud.solicitudBuilder().build();
        //return obtenerPeticionRepository.getPeticion(idPeticion)
        //        .orElse(Pqr.builder().build());
    }

    @Override
    public List<Solicitud> getAllSolicitud(String tipo, String numero) {
        return Collections.singletonList(Solicitud.solicitudBuilder().build());
        //return obtenerPeticionRepository.getAllPeticion(tipo, numero);
    }

    @Override
    public void saveSolicitud(Solicitud solicitud) {
        guardarSolicitudRepository.saveSolicitud(solicitud);
    }
}
