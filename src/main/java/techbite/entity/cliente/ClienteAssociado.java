package techbite.entity.cliente;

public class ClienteAssociado extends Cliente {

    public ClienteAssociado(String cpf, String nome) {
        super(new ClienteEntity(cpf, nome, techbite.entity.cliente.TipoCliente.ASSOCIADO));
    }
}
