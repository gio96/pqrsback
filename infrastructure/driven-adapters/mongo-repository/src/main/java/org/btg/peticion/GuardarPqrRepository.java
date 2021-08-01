package org.btg.peticion;

import lombok.RequiredArgsConstructor;
import org.btg.data.ClienteData;
import org.btg.data.PqrData;
import org.btg.entities.Cliente;
import org.btg.interfaces.PqrRepositoryDataAdapter;
import org.btg.utils.mapper.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GuardarPqrRepository {

    private final PqrRepositoryDataAdapter pqrRepositoryDataAdapter;
    private final ObjectMapper objectMapper;

    public void savePqr(Cliente cliente) {
        pqrRepositoryDataAdapter.save(objectMapper.map(cliente, ClienteData.class));
    }
}
