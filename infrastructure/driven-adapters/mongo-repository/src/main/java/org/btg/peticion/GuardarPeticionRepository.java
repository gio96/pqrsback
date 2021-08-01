package org.btg.peticion;

import lombok.RequiredArgsConstructor;
import org.btg.data.PqrData;
import org.btg.entities.Pqr;
import org.btg.interfaces.PeticionRepositoryDataAdapter;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GuardarPeticionRepository {

    private final PeticionRepositoryDataAdapter peticionRepositoryDataAdapter;
    private final ObjectMapper objectMapper;

    public void savePeticion(Pqr pqr) {
        peticionRepositoryDataAdapter.save(objectMapper.map(pqr, PqrData.class));
    }
}
