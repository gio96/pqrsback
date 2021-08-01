package org.btg.peticion;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Peticion;
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

    public Optional<Peticion> getPeticion(String idPeticion) {
        return peticionRepositoryDataAdapter.findById(idPeticion)
                .map(peticionData -> objectMapper.map(peticionData, Peticion.class));
    }

    public List<Peticion> getAllPeticion(String tipo, String numero) {
        return peticionRepositoryDataAdapter.
                findAllByIdentificacionClienteNumeroAndIdentificacionClienteTipo(numero, tipo)
                .stream()
                .map(peticionData -> objectMapper.map(peticionData, Peticion.class))
                .collect(Collectors.toList());
    }
}
