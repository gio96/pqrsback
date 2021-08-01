package org.btg.peticion;

import lombok.RequiredArgsConstructor;
import org.btg.data.PeticionData;
import org.btg.entities.Peticion;
import org.btg.interfaces.PeticionRepositoryDataAdapter;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GuardarPeticionRepository {

    private final PeticionRepositoryDataAdapter peticionRepositoryDataAdapter;
    private final ObjectMapper objectMapper;

    public void savePeticion(Peticion peticion) {
        peticionRepositoryDataAdapter.save(objectMapper.map(peticion, PeticionData.class));
    }
}
