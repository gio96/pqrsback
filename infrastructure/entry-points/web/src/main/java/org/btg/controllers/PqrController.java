package org.btg.controllers;

import lombok.RequiredArgsConstructor;
import org.btg.controllers.dto.ClienteDto;
import org.btg.entities.Cliente;
import org.btg.entities.DocumentoIdentificacion;
import org.btg.entities.Pqr;
import org.btg.usecase.PqrUseCase;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/pqr", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PqrController {

    private final PqrUseCase pqrUseCase;
    private final ObjectMapper objectMapper;

    @GetMapping()
    public List<Pqr> getAllPeticiones(@RequestParam(name = "tipo") String tipo, @RequestParam(name = "numero") String numero) {
        return pqrUseCase.getAllPeticion(tipo, numero);
    }

    @GetMapping("/{idPeticion}")
    public Pqr getPeticion(@PathVariable String idPeticion) {
        return pqrUseCase.getPeticion(idPeticion);
    }

    @PostMapping()
    public void savePqr(@RequestBody ClienteDto clienteDto) {
        pqrUseCase.savePqr(convertClienteDtoToCliente(clienteDto));
    }

    private Cliente convertClienteDtoToCliente(ClienteDto clienteDto) {
        DocumentoIdentificacion documentoIdentificacion = DocumentoIdentificacion.builder()
                .numero(clienteDto.getIdentificacion().getNumero())
                .tipo(clienteDto.getIdentificacion().getTipo())
                .build();

        List<Pqr> pqr = Collections.singletonList(Pqr.builder()
                .descripcionPqr(clienteDto.getPqr().getDescripcionPqr())
                .tipoSolicitud(clienteDto.getPqr().getTipoSolicitud())
                .build());

        return Cliente.builder()
                .identificacion(documentoIdentificacion)
                .pqr(pqr)
                .build();
    }
}
