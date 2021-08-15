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
public class ReclamoGatewayImplTest {

    @Mock
    private GuardarSolicitudRepository guardarSolicitudRepository;

    @Mock
    private ObtenerSolicitudRepository obtenerSolicitudRepository;

    @InjectMocks
    private ReclamoGatewayImpl reclamoGatewayImpl;

    @Test
    public void getReclamoById() {
        // arrange
        String idReclamo = "id";
        Solicitud solicitud = Solicitud.solicitudBuilder()
                .id(idReclamo)
                .descripcionSolicitud("La solicitud es por el motivo")
                .fechaSolicitud(LocalDate.of(2021, 8, 14))
                .tipoSolicitud(TipoSolicitud.PETICION)
                .respuestaAdministrativa("la respuesta administrativa")
                .build();

        //act
        Mockito.when(obtenerSolicitudRepository.getReclamoId(Mockito.anyString()))
                .thenReturn(Optional.of(solicitud));

        //assert
        assertEquals(solicitud, reclamoGatewayImpl.getReclamo(idReclamo));

        verify(obtenerSolicitudRepository, times(1)).getReclamoId(Mockito.anyString());
    }

    @Test
    public void getReclamoByIdNoExiste() {
        // arrange
        String idReclamo = "id";
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(obtenerSolicitudRepository.getReclamoId(Mockito.anyString()))
                .thenReturn(Optional.empty());

        //assert
        assertEquals(solicitud, reclamoGatewayImpl.getReclamo(idReclamo));

        verify(obtenerSolicitudRepository, times(1)).getReclamoId(Mockito.anyString());
    }

    @Test
    public void saveReclamo() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        reclamoGatewayImpl.saveReclamo(solicitud);

        //assert

        verify(guardarSolicitudRepository, times(1)).saveSolicitud(Mockito.any(Solicitud.class));

    }

    @Test
    public void getAllReclamo() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(obtenerSolicitudRepository.getAllReclamo())
                .thenReturn(Collections.singletonList(solicitud));

        //assert
        assertEquals(Collections.singletonList(solicitud), reclamoGatewayImpl.getAllReclamo());

        verify(obtenerSolicitudRepository, times(1)).getAllReclamo();
    }
}
