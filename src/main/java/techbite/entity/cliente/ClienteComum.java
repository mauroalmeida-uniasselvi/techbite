package techbite.entity;

public class ClienteComum extends Cliente {

    public ClienteComum(String cpf, String nome) {
        super(new ClienteEntity(cpf, nome), TipoCliente.COMUM);
    }

}
