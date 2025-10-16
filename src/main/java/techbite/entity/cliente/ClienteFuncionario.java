package techbite.entity;

public class ClienteFuncionario extends Cliente {

    public ClienteFuncionario(String cpf, String nome) {
        super(new ClienteEntity(cpf, nome), TipoCliente.FUNCIONARIO);
    }

}
