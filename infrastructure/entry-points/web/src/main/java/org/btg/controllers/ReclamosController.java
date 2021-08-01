package org.btg.controllers;

import lombok.RequiredArgsConstructor;
import org.btg.controllers.dto.ReclamoDto;
import org.btg.entities.Reclamo;
import org.btg.usecase.ReclamoUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/peticiones", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ReclamosController {

    private final ReclamoUseCase reclamoUseCase;


    @GetMapping("/{idPeticion}/reclamo/{idReclamo}")
    public Reclamo getReclamo(@PathVariable String idPeticion, @PathVariable String idReclamo) {
        return reclamoUseCase.getReclamo(idPeticion, idReclamo);
    }

    @PostMapping("/{idPeticion}/reclamo")
    public void saveReclamo(@PathVariable String idPeticion, @RequestBody ReclamoDto reclamoDto) {
        reclamoUseCase.saveReclamo(idPeticion, Reclamo.builder()
                .descripcionReclamo(reclamoDto.getDescripcionReclamo())
                .build());
    }
}
