package org.btg.gateway;

import org.btg.entities.Pqr;
import org.btg.entities.Solicitud;

import java.util.List;

public interface PeticionGateway {
    Solicitud getSolicitud(String idPeticion);
    List<Solicitud> getAllSolicitud(String tipo, String numero);
    void saveSolicitud(Solicitud solicitud);
}
