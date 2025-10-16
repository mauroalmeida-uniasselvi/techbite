package techbite.entity.cliente;

public class ClienteComum extends Cliente {

    public ClienteComum(String cpf, String nome) {
        super(new ClienteEntity(cpf, nome, techbite.entity.cliente.TipoCliente.COMUM));
    }

}
