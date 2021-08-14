package org.btg.interfaces;

import org.btg.data.SolicitudData;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitudRepositoryDataAdapter extends MongoRepository<SolicitudData, String> {
    Optional<SolicitudData> findById(String id);
    List<SolicitudData> findAll();
    Optional<SolicitudData> findByReclamoId(String idReclamo);

    @Query("{'reclamo' : {$exists: true,$ne: null}}")
    List<SolicitudData> findAllReclamo();
}
