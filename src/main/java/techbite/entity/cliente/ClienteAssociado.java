package techbite.entity;

public class ClienteAssociado extends Cliente {

    public ClienteAssociado(String cpf, String nome) {
        super(new ClienteEntity(cpf, nome), TipoCliente.ASSOCIADO);
    }
}
