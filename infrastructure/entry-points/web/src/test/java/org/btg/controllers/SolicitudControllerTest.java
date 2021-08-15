package org.btg.controllers;

import org.btg.controllers.dto.SolicitudDto;
import org.btg.entities.Solicitud;
import org.btg.entities.TipoSolicitud;
import org.btg.usecase.SolicitudUseCase;
import org.btg.utils.mapper.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SolicitudControllerTest {

    @Mock
    private SolicitudUseCase solicitudUseCase;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private SolicitudController solicitudController;

    @Test
    public void getSolicitudById() {
        // arrange
        String idReclamo = "id";
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(solicitudUseCase.getSolicitud(Mockito.anyString()))
                .thenReturn(solicitud);

        //assert
        assertEquals(solicitud, solicitudController.getSolicitud(idReclamo));

        verify(solicitudUseCase, times(1)).getSolicitud(Mockito.anyString());
    }

    @Test
    public void saveSolicitud() {
        // arrange
        SolicitudDto solicitudDto = SolicitudDto.builder()
                .descripcionSolicitud("La queja es")
                .tipoSolicitud(TipoSolicitud.QUEJA).build();

        //act
        Mockito.when(objectMapper.map(any(SolicitudDto.class), eq(Solicitud.class)))
                .thenReturn(Solicitud.solicitudBuilder().build());

        solicitudController.saveSolicitud(solicitudDto);

        //assert

        verify(solicitudUseCase, times(1)).saveSolicitud(Mockito.any(Solicitud.class));
        verify(objectMapper, times(1)).map(any(SolicitudDto.class), eq(Solicitud.class));

    }

    @Test
    public void getAllSolicitud() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(solicitudUseCase.getAllSolicitud())
                .thenReturn(Collections.singletonList(solicitud));

        //assert
        assertEquals(Collections.singletonList(solicitud), solicitudController.getAllSolicitud());

        verify(solicitudUseCase, times(1)).getAllSolicitud();
    }
}
