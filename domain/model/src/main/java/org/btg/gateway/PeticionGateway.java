package org.btg.gateway;

import org.btg.entities.Pqr;

import java.util.List;

public interface PeticionGateway {
    Pqr getPeticion(String idPeticion);
    List<Pqr> getAllPeticiones(String tipo, String numero);
    void savePeticion(Pqr pqr);
}
