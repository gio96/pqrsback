package org.btg.controllers;

import lombok.RequiredArgsConstructor;
import org.btg.controllers.dto.PeticionDto;
import org.btg.entities.Peticion;
import org.btg.entities.Pqr;
import org.btg.usecase.PeticionUseCase;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/pq", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PeticionController {

    private final PeticionUseCase peticionUseCase;
    private final ObjectMapper objectMapper;

    @GetMapping()
    public List<Pqr> getAllPeticiones(@RequestParam(name = "tipo") String tipo, @RequestParam(name = "numero") String numero) {
        return peticionUseCase.getAllPeticion(tipo, numero);
    }

    @GetMapping("/{idPeticion}")
    public Pqr getPeticion(@PathVariable String idPeticion) {
        return peticionUseCase.getPeticion(idPeticion);
    }

    @PostMapping()
    public void savePeticion(@RequestBody PeticionDto peticionDto) {
        peticionUseCase.savePeticion(objectMapper
                .map(peticionDto, Pqr.class));
    }
}
