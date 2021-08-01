package org.btg.gateway;

import org.btg.entities.Peticion;

import java.util.List;

public interface PeticionGateway {
    Peticion getPeticion(String idPeticion);
    List<Peticion> getAllPeticiones(String tipo,String numero);
    void savePeticion(Peticion peticion);
}
