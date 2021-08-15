package org.btg.controllers;

import org.btg.controllers.dto.ReclamoDto;
import org.btg.entities.Reclamo;
import org.btg.entities.Solicitud;
import org.btg.usecase.ReclamoUseCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReclamosControllerTest {

    @Mock
    private ReclamoUseCase reclamoUseCase;

    @InjectMocks
    private ReclamosController reclamosController;

    @Test
    public void getSolicitudById() {
        // arrange
        String idReclamo = "id";
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(reclamoUseCase.getReclamo(Mockito.anyString()))
                .thenReturn(solicitud);

        //assert
        assertEquals(solicitud, reclamosController.getReclamo(idReclamo));

        verify(reclamoUseCase, times(1)).getReclamo(Mockito.anyString());
    }

    @Test
    public void saveSolicitud() {
        // arrange
        ReclamoDto reclamoDto = ReclamoDto.builder()
                .descripcionSolicitud("El reclamo es").build();

        //act
        reclamosController.saveReclamo("id", reclamoDto);

        //assert

        verify(reclamoUseCase, times(1)).saveReclamo(Mockito.anyString(), Mockito.any(Reclamo.class));

    }

    @Test
    public void getAllReclamo() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(reclamoUseCase.getAllReclamo())
                .thenReturn(Collections.singletonList(solicitud));

        //assert
        assertEquals(Collections.singletonList(solicitud), reclamosController.getAllReclamo());

        verify(reclamoUseCase, times(1)).getAllReclamo();
    }
}
