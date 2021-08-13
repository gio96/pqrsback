package org.btg.controllers;

import lombok.RequiredArgsConstructor;
import org.btg.controllers.dto.ReclamoDto;
import org.btg.entities.Reclamo;
import org.btg.entities.Solicitud;
import org.btg.usecase.ReclamoUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/solicitud", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ReclamosController {

    private final ReclamoUseCase reclamoUseCase;


    @CrossOrigin(origins = "*")
    @GetMapping("/{idSolicitud}/reclamo/{idReclamo}")
    public Solicitud getReclamo(@PathVariable String idSolicitud, @PathVariable String idReclamo) {
        return reclamoUseCase.getReclamo(idSolicitud, idReclamo);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{idSolicitud}/reclamo")
    public void saveReclamo(@PathVariable String idSolicitud, @RequestBody ReclamoDto reclamoDto) {
        reclamoUseCase.saveReclamo(idSolicitud, Reclamo.reclamoBuilder()
                .descripcionSolicitud(reclamoDto.getDescripcionSolicitud())
                .build());
    }
}
