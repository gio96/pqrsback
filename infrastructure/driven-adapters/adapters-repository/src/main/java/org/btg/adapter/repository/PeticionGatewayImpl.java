package org.btg.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Pqr;
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
    public Pqr getPeticion(String idPeticion) {
        return obtenerPeticionRepository.getPeticion(idPeticion)
                .orElse(Pqr.builder().build());
    }

    @Override
    public List<Pqr> getAllPeticiones(String tipo, String numero) {
        return obtenerPeticionRepository.getAllPeticion(tipo, numero);
    }

    @Override
    public void savePeticion(Pqr pqr) {
        guardarPeticionRepository.savePeticion(pqr);
    }
}
