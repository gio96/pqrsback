package org.btg.adapter.repository;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Cliente;
import org.btg.entities.Pqr;
import org.btg.gateway.PqrGateway;
import org.btg.peticion.GuardarPqrRepository;
import org.btg.peticion.ObtenerPeticionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PqrGatewayImpl implements PqrGateway {

    private final ObtenerPeticionRepository obtenerPeticionRepository;
    private final GuardarPqrRepository guardarPqrRepository;

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
    public void savePqr(Cliente cliente) {
        guardarPqrRepository.savePqr(cliente);
    }
}
