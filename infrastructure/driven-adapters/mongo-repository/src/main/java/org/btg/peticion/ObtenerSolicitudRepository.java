package org.btg.peticion;

import lombok.RequiredArgsConstructor;
import org.btg.entities.Solicitud;
import org.btg.interfaces.SolicitudRepositoryDataAdapter;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ObtenerSolicitudRepository {

    private final SolicitudRepositoryDataAdapter solicitudRepositoryDataAdapter;
    private final ObjectMapper objectMapper;

    public Optional<Solicitud> getSolicitud(String idSolicitud) {
        return solicitudRepositoryDataAdapter.findById(idSolicitud)
                .map(solicitudData -> objectMapper.map(solicitudData, Solicitud.class));
    }

    public List<Solicitud> getAllPeticion() {
        return solicitudRepositoryDataAdapter.
                findAll()
                .stream()
                .map(solicitudData -> objectMapper.map(solicitudData, Solicitud.class))
                .collect(Collectors.toList());
    }
}
