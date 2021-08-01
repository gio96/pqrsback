package org.btg.gateway;

import org.btg.entities.Cliente;
import org.btg.entities.Pqr;

import java.util.List;

public interface PqrGateway {
    Pqr getPeticion(String idPeticion);
    List<Pqr> getAllPeticiones(String tipo, String numero);
    void savePqr(Cliente cliente);
}
