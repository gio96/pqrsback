package org.btg.usecase;

import org.btg.entities.Solicitud;
import org.btg.entities.TipoSolicitud;
import org.btg.gateway.SolicitudGateway;
import org.btg.usecase.exceptions.SolicitudException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.hamcrest.Matchers;

@RunWith(MockitoJUnitRunner.class)
public class SolicitudUseCaseTest {

    @Mock
    private SolicitudGateway solicitudGateway;

    @InjectMocks
    private SolicitudUseCase solicitudUseCase;


    private Solicitud solicitudG;
    private String idSolicitud;

    @Before
    public void init() {
        idSolicitud = "id";
        solicitudG = Solicitud.solicitudBuilder()
                .id(idSolicitud)
                .descripcionSolicitud("La solicitud es por el motivo")
                .fechaSolicitud(LocalDate.of(2021,8,14))
                .tipoSolicitud(TipoSolicitud.PETICION)
                .respuestaAdministrativa("la respuesta administrativa")
                .build();
    }

    @Test
    public void guardarSolicitud() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder()
                .descripcionSolicitud("La solicitud es por el motivo")
                .tipoSolicitud(TipoSolicitud.PETICION)
                .build();

        //act
        solicitudUseCase.saveSolicitud(solicitud);

        //assert

        verify(solicitudGateway, times(1)).saveSolicitud(Mockito.any(Solicitud.class));

    }

    @Test
    public void guardarSolicitudCampoObligatorioVacio() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder()
                .descripcionSolicitud("")
                .tipoSolicitud(TipoSolicitud.PETICION)
                .build();

        try {
            //act
            solicitudUseCase.saveSolicitud(solicitud);
            fail();
        } catch (SolicitudException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(SolicitudException.Type.SOLICITUD_NOT_FULL.getMessage()));
        }

        //assert

        verify(solicitudGateway, times(0)).saveSolicitud(Mockito.any(Solicitud.class));

    }

    @Test
    public void guardarSolicitudCampoObligatorioNulo() {
        // arrange
        Solicitud solicitud = Solicitud.solicitudBuilder()
                .tipoSolicitud(TipoSolicitud.PETICION)
                .build();

        try {
            //act
            solicitudUseCase.saveSolicitud(solicitud);
            fail();
        } catch (SolicitudException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(SolicitudException.Type.SOLICITUD_NOT_FULL.getMessage()));
        }

        //assert

        verify(solicitudGateway, times(0)).saveSolicitud(Mockito.any(Solicitud.class));

    }


    @Test
    public void obtenerSolicitudById() {
        // arrange

        //act
        Mockito.when(solicitudGateway.getSolicitud(Mockito.anyString()))
                .thenReturn(solicitudG);

        //assert
        assertEquals(solicitudG, solicitudUseCase.getSolicitud(idSolicitud));

        verify(solicitudGateway, times(1)).getSolicitud(Mockito.anyString());

    }

    @Test
    public void obtenerGetAllSolicitud() {
        // arrange

        //act
        Mockito.when(solicitudGateway.getAllSolicitud())
                .thenReturn(Collections.singletonList(solicitudG));

        //assert
        assertEquals(Collections.singletonList(solicitudG), solicitudUseCase.getAllSolicitud());

        verify(solicitudGateway, times(1)).getAllSolicitud();

    }

    @Test
    public void obtenerGetAllSolicitudVacio() {
        // arrange

        //act
        Mockito.when(solicitudGateway.getAllSolicitud())
                .thenReturn(Collections.emptyList());

        //assert
        assertEquals(Collections.emptyList(), solicitudUseCase.getAllSolicitud());

        verify(solicitudGateway, times(1)).getAllSolicitud();

    }
}
