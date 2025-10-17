package techbite.service;

import java.io.IOException;
import java.util.Optional;

public interface IClienteService {

    java.util.List<techbite.entity.cliente.ClienteEntity> listarClientes() throws java.io.IOException;

    void criar(techbite.entity.cliente.ClienteEntity entity) throws IOException;

    Optional<techbite.entity.cliente.ClienteEntity> buscarPorId(String cpf) throws IOException;

    techbite.entity.cliente.ClienteEntity atualizar(techbite.entity.cliente.ClienteEntity entity) throws IOException;

    boolean remover(String cpf) throws IOException;

}
