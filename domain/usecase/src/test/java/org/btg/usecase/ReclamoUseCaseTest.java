package org.btg.usecase;

import org.btg.entities.Reclamo;
import org.btg.entities.Solicitud;
import org.btg.entities.TipoSolicitud;
import org.btg.gateway.ReclamoGateway;
import org.btg.gateway.SolicitudGateway;
import org.btg.usecase.exceptions.SolicitudException;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReclamoUseCaseTest {

    @Mock
    private SolicitudGateway solicitudGateway;

    @Mock
    private ReclamoGateway reclamoGateway;

    @InjectMocks
    private ReclamoUseCase reclamoUseCase;


    private Solicitud solicitudG;
    private String idReclamo;

    @Before
    public void init() {
        idReclamo = "id";
        solicitudG = Solicitud.solicitudBuilder()
                .id(idReclamo)
                .descripcionSolicitud("La solicitud es por el motivo")
                .fechaSolicitud(LocalDate.now())
                .tipoSolicitud(TipoSolicitud.PETICION)
                .respuestaAdministrativa("la respuesta es que")
                .reclamo(Reclamo.reclamoBuilder().build())
                .build();
    }

    @Test
    public void guardarReclamoMenos5DiasConRespuestaAdministrativa() {
        // arrange
        String idSolicitud = "id";
        Reclamo reclamo = Reclamo.reclamoBuilder()
                .descripcionSolicitud("El reclamo es")
                .build();

        Solicitud solicitud = Solicitud.solicitudBuilder()
                .id(idReclamo)
                .descripcionSolicitud("La solicitud es por el motivo")
                .fechaSolicitud(LocalDate.now())
                .respuestaAdministrativa("La respuesta")
                .tipoSolicitud(TipoSolicitud.PETICION)
                .build();

        //act
        Mockito.when(solicitudGateway.getSolicitud(Mockito.anyString()))
                .thenReturn(solicitud);

        reclamoUseCase.saveReclamo(idSolicitud,reclamo);

        verify(reclamoGateway, times(1)).saveReclamo(Mockito.any(Solicitud.class));
        verify(solicitudGateway, times(1)).getSolicitud(Mockito.anyString());

    }

    @Test
    public void guardarReclamoMas5Dias() {
        // arrange
        String idSolicitud = "id";
        Period periodo = Period.ofDays(6);
        Reclamo reclamo = Reclamo.reclamoBuilder()
                .descripcionSolicitud("El reclamo es")
                .build();

        Solicitud solicitud = Solicitud.solicitudBuilder()
                .id(idReclamo)
                .descripcionSolicitud("La solicitud es por el motivo")
                .fechaSolicitud(LocalDate.now().minus(periodo))
                .tipoSolicitud(TipoSolicitud.PETICION)
                .build();

        //act
        Mockito.when(solicitudGateway.getSolicitud(Mockito.anyString()))
                .thenReturn(solicitud);

        reclamoUseCase.saveReclamo(idSolicitud,reclamo);

        verify(reclamoGateway, times(1)).saveReclamo(Mockito.any(Solicitud.class));
        verify(solicitudGateway, times(1)).getSolicitud(Mockito.anyString());

    }

    @Test
    public void guardarReclamoNoMas5DiasError() {
        // arrange
        String idSolicitud = "id";
        Reclamo reclamo = Reclamo.reclamoBuilder()
                .descripcionSolicitud("El reclamo es")
                .build();

        Solicitud solicitud = Solicitud.solicitudBuilder()
                .id(idReclamo)
                .descripcionSolicitud("La solicitud es por el motivo")
                .fechaSolicitud(LocalDate.now())
                .tipoSolicitud(TipoSolicitud.PETICION)
                .build();

        //act
        Mockito.when(solicitudGateway.getSolicitud(Mockito.anyString()))
                .thenReturn(solicitud);

        try {
            //act
            reclamoUseCase.saveReclamo(idSolicitud,reclamo);
            fail();
        } catch (SolicitudException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(SolicitudException.Type.SOLICITUD_NOT_5_DAYS.getMessage()));
        }

        verify(reclamoGateway, times(0)).saveReclamo(Mockito.any(Solicitud.class));
        verify(solicitudGateway, times(1)).getSolicitud(Mockito.anyString());

    }

    @Test
    public void reclamoNoNulo() {
        // arrange
        String idSolicitud = "id";
        Reclamo reclamo = Reclamo.reclamoBuilder()
                .descripcionSolicitud("El reclamo es")
                .build();

        //act
        Mockito.when(solicitudGateway.getSolicitud(Mockito.anyString()))
                .thenReturn(solicitudG);

        try {
            //act
            reclamoUseCase.saveReclamo(idSolicitud,reclamo);
            fail();
        } catch (SolicitudException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(SolicitudException.Type.RECLAMO_NOT_ABLE.getMessage()));
        }

        verify(reclamoGateway, times(0)).saveReclamo(Mockito.any(Solicitud.class));
        verify(solicitudGateway, times(1)).getSolicitud(Mockito.anyString());

    }

    @Test
    public void solicitudNoExiste() {
        // arrange
        String idSolicitud = "id";
        Reclamo reclamo = Reclamo.reclamoBuilder()
                .descripcionSolicitud("El reclamo es")
                .build();

        Solicitud solicitud = Solicitud.solicitudBuilder().build();

        //act
        Mockito.when(solicitudGateway.getSolicitud(Mockito.anyString()))
                .thenReturn(solicitud);

        try {
            //act
            reclamoUseCase.saveReclamo(idSolicitud,reclamo);
            fail();
        } catch (SolicitudException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(SolicitudException.Type.SOLICITUD_NOT_FOUND.getMessage()));
        }

        verify(reclamoGateway, times(0)).saveReclamo(Mockito.any(Solicitud.class));
        verify(solicitudGateway, times(1)).getSolicitud(Mockito.anyString());

    }

    @Test
    public void guardarReclamoCampoObligatorioVacio() {
        // arrange
        String idSolicitud = "id";
        Reclamo reclamo = Reclamo.reclamoBuilder()
                .descripcionSolicitud("")
                .build();

        try {
            //act
            reclamoUseCase.saveReclamo(idSolicitud,reclamo);
            fail();
        } catch (SolicitudException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(SolicitudException.Type.SOLICITUD_NOT_FULL.getMessage()));
        }

        //assert

        verify(reclamoGateway, times(0)).saveReclamo(Mockito.any(Solicitud.class));

    }

    @Test
    public void guardarReclamoCampoObligatorioNulo() {
        // arrange
        String idSolicitud = "id";
        Reclamo reclamo = Reclamo.reclamoBuilder().build();


        try {
            //act
            reclamoUseCase.saveReclamo(idSolicitud,reclamo);
            fail();
        } catch (SolicitudException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(SolicitudException.Type.SOLICITUD_NOT_FULL.getMessage()));
        }

        //assert

        verify(reclamoGateway, times(0)).saveReclamo(Mockito.any(Solicitud.class));

    }


    @Test
    public void obtenerReclamodById() {
        // arrange

        //act
        Mockito.when(reclamoGateway.getReclamo(Mockito.anyString()))
                .thenReturn(solicitudG);

        //assert
        assertEquals(solicitudG, reclamoUseCase.getReclamo(idReclamo));

        verify(reclamoGateway, times(1)).getReclamo(Mockito.anyString());

    }

    @Test
    public void obtenerGetAllReclamo() {
        // arrange

        //act
        Mockito.when(reclamoGateway.getAllReclamo())
                .thenReturn(Collections.singletonList(solicitudG));

        //assert
        assertEquals(Collections.singletonList(solicitudG), reclamoUseCase.getAllReclamo());

        verify(reclamoGateway, times(1)).getAllReclamo();

    }

    @Test
    public void obtenerGetAllReclamoVacio() {
        // arrange

        //act
        Mockito.when(reclamoGateway.getAllReclamo())
                .thenReturn(Collections.emptyList());

        //assert
        assertEquals(Collections.emptyList(), reclamoUseCase.getAllReclamo());

        verify(reclamoGateway, times(1)).getAllReclamo();

    }
}
