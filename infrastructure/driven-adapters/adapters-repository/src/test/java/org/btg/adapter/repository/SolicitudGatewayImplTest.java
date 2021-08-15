package org.btg.adapter.repository;

import org.btg.entities.Solicitud;
import org.btg.entities.TipoSolicitud;
import org.btg.peticion.GuardarSolicitudRepository;
import org.btg.peticion.ObtenerSolicitudRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SolicitudGatewayImplTest {

    @Mock
    private GuardarSolicitudRepository guardarSolicitudRepository;

    @Mock
    private ObtenerSolicitudRepository obtenerSolicitudRepository;

    @InjectMocks
    private SolicitudGatewayImpl solicitudGatewayImpl;

    @Test
    public void getSolicitudById() {
        // arrange
        String idSolicitud = "id";
        Solicitud solicitud = Solicitud.solicitudBuilder()
                .id(idSolicitud)
                .descripcionSolicitud("La solicitud es por el motivo")
                .fechaSolicitud(LocalDate.of(2021, 8, 14))
                .tipoSolicitud(TipoSolicitud.PETICION)
                .respuestaAdministrativa("la respuesta administrativa")
                .build();

        //act
        Mockito.when(obtenerSolicitudRepository.getSolicitud(Mockito.anyString()))
                .thenReturn(Optional.of(solicitud));

        //assert
        assertEquals(solicitud, solicitudGatewayImpl.getSolicitud(idSolicitud));

        verify(obtenerSolicitudRepository, times(1)).getSolicitud(Mockito.anyString());
    }

    @Test
    public void getSolicitudByIdNoExiste() {
        // arrange
        String idSolicitud = "id";
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(obtenerSolicitudRepository.getSolicitud(Mockito.anyString()))
                .thenReturn(Optional.empty());

        //assert
        assertEquals(solicitud, solicitudGatewayImpl.getSolicitud(idSolicitud));

        verify(obtenerSolicitudRepository, times(1)).getSolicitud(Mockito.anyString());
    }

    @Test
    public void saveSolicitud() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        solicitudGatewayImpl.saveSolicitud(solicitud);

        //assert

        verify(guardarSolicitudRepository, times(1)).saveSolicitud(Mockito.any(Solicitud.class));

    }

    @Test
    public void getAllSolicitud() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(obtenerSolicitudRepository.getAllPeticion())
                .thenReturn(Collections.singletonList(solicitud));

        //assert
        assertEquals(Collections.singletonList(solicitud), solicitudGatewayImpl.getAllSolicitud());

        verify(obtenerSolicitudRepository, times(1)).getAllPeticion();
    }
}
