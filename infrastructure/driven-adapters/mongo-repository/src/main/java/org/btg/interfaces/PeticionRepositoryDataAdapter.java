package org.btg.interfaces;

import org.btg.data.PqrData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeticionRepositoryDataAdapter extends MongoRepository<PqrData, String> {
    Optional<PqrData> findById(String id);
    List<PqrData> findAll();
}
