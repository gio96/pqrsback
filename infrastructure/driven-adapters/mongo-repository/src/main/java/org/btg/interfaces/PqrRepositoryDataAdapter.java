package org.btg.interfaces;

import org.btg.data.ClienteData;
import org.btg.data.PqrData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PqrRepositoryDataAdapter extends MongoRepository<ClienteData, String> {
    Optional<ClienteData> findById(String id);
    List<ClienteData> findAllByIdentificacionNumeroAndIdentificacionTipo(String numero, String tipo);
}
