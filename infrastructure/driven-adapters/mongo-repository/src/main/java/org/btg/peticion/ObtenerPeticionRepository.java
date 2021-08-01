package org.btg.peticion;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Pqr;
import org.btg.interfaces.PeticionRepositoryDataAdapter;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ObtenerPeticionRepository {

    private final PeticionRepositoryDataAdapter peticionRepositoryDataAdapter;
    private final ObjectMapper objectMapper;

    public Optional<Pqr> getPeticion(String idPeticion) {
        return peticionRepositoryDataAdapter.findById(idPeticion)
                .map(peticionData -> objectMapper.map(peticionData, Pqr.class));
    }

    public List<Pqr> getAllPeticion(String tipo, String numero) {
        return peticionRepositoryDataAdapter.
                findAll()
                .stream()
                .map(peticionData -> objectMapper.map(peticionData, Pqr.class))
                .collect(Collectors.toList());
    }
}
