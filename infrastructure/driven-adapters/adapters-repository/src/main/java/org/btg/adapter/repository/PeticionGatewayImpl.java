package org.btg.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Peticion;
import org.btg.gateway.PeticionGateway;
import org.btg.peticion.GuardarPeticionRepository;
import org.btg.peticion.ObtenerPeticionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PeticionGatewayImpl implements PeticionGateway {

    private final ObtenerPeticionRepository obtenerPeticionRepository;
    private final GuardarPeticionRepository guardarPeticionRepository;

    @Override
    public Peticion getPeticion(String idPeticion) {
        return obtenerPeticionRepository.getPeticion(idPeticion)
                .orElse(Peticion.builder().build());
    }

    @Override
    public List<Peticion> getAllPeticiones(String tipo, String numero) {
        return obtenerPeticionRepository.getAllPeticion(tipo, numero);
    }

    @Override
    public void savePeticion(Peticion peticion) {
        guardarPeticionRepository.savePeticion(peticion);
    }
}
