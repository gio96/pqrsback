package org.btg.controllers;

import lombok.RequiredArgsConstructor;
import org.btg.controllers.dto.SolicitudDto;
import org.btg.entities.Solicitud;
import org.btg.usecase.SolicitudUseCase;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/solicitud", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudUseCase solicitudUseCase;
    private final ObjectMapper objectMapper;

    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<Solicitud> getAllSolicitud() {
        return solicitudUseCase.getAllSolicitud();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{idSolicitud}")
    public Solicitud getSolicitud(@PathVariable String idSolicitud) {
        return solicitudUseCase.getSolicitud(idSolicitud);
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public void saveSolicitud(@RequestBody SolicitudDto solicitudDto) {
        solicitudUseCase.saveSolicitud(objectMapper
                .map(solicitudDto, Solicitud.class));
    }
}
