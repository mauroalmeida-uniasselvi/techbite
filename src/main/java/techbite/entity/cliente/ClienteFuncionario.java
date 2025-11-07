package techbite.entity.cliente;

public class ClienteFuncionario extends Cliente {

    public ClienteFuncionario(String cpf, String nome) {
        super(new ClienteEntity(cpf, nome, techbite.entity.cliente.TipoCliente.FUNCIONARIO));
    }
}
