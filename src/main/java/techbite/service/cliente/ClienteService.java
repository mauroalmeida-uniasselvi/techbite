package techbite.service.cliente;

import java.io.*;

public interface ClienteService {

    java.util.List<techbite.entity.cliente.ClienteEntity> listar();

    techbite.entity.cliente.ClienteEntity obterPorId(String id);

    void criar(techbite.entity.cliente.ClienteEntity entity) throws Exception;

}
