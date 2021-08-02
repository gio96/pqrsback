package org.btg.controllers;

import lombok.RequiredArgsConstructor;
import org.btg.controllers.dto.SolicitudDto;
import org.btg.entities.Solicitud;
import org.btg.entities.Pqr;
import org.btg.usecase.PeticionUseCase;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/solicitud", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SolicitudController {

    private final PeticionUseCase peticionUseCase;
    private final ObjectMapper objectMapper;

    @GetMapping()
    public List<Solicitud> getAllPeticiones(@RequestParam(name = "tipo") String tipo, @RequestParam(name = "numero") String numero) {
        return peticionUseCase.getAllPeticion(tipo, numero);
    }

    @GetMapping("/{idPeticion}")
    public Solicitud getPeticion(@PathVariable String idPeticion) {
        return peticionUseCase.getPeticion(idPeticion);
    }

    @PostMapping()
    public void saveSolicitud(@RequestBody SolicitudDto solicitudDto) {
        peticionUseCase.saveSolicitud(objectMapper
                .map(solicitudDto, Solicitud.class));
    }
}
