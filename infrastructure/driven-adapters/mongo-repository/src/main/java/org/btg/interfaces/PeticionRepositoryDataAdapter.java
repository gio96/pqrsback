package org.btg.interfaces;

import org.btg.data.PeticionData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeticionRepositoryDataAdapter extends MongoRepository<PeticionData, String> {
    Optional<PeticionData> findById(String id);
    List<PeticionData> findAllByIdentificacionClienteNumeroAndIdentificacionClienteTipo(String numero, String tipo);
}
