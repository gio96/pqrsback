package org.btg.gateway;

import org.btg.entities.Solicitud;

import java.util.List;

public interface SolicitudGateway {
    Solicitud getSolicitud(String idSolicitud);
    List<Solicitud> getAllSolicitud();
    void saveSolicitud(Solicitud solicitud);
}
