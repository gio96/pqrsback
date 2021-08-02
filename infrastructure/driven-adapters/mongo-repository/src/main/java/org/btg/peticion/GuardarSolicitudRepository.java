package org.btg.peticion;

import lombok.RequiredArgsConstructor;
import org.btg.data.SolicitudData;
import org.btg.entities.Solicitud;
import org.btg.interfaces.SolicitudRepositoryDataAdapter;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GuardarSolicitudRepository {

    private final SolicitudRepositoryDataAdapter solicitudRepositoryDataAdapter;
    private final ObjectMapper objectMapper;

    public void saveSolicitud(Solicitud solicitud) {
        solicitudRepositoryDataAdapter.save(objectMapper.map(solicitud, SolicitudData.class));
    }
}
