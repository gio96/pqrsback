package org.btg.controllers;

import lombok.RequiredArgsConstructor;
import org.btg.controllers.dto.PeticionDto;
import org.btg.entities.Peticion;
import org.btg.usecase.PeticionUseCase;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/peticiones", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PeticionesController {

    private final PeticionUseCase peticionUseCase;
    private final ObjectMapper objectMapper;

    @GetMapping()
    public List<Peticion> getAllPeticiones(@RequestParam(name = "tipo") String tipo, @RequestParam(name = "numero") String numero) {
        return peticionUseCase.getAllPeticion(tipo, numero);
    }

    @GetMapping("/{idPeticion}")
    public Peticion getPeticion(@PathVariable String idPeticion) {
        return peticionUseCase.getPeticion(idPeticion);
    }

    @PostMapping()
    public void savePeticion(@RequestBody PeticionDto peticionDto) {
        peticionUseCase.savePeticion(objectMapper
                .map(peticionDto, Peticion.class));
    }
}
