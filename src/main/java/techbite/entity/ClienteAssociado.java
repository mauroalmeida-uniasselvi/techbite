
package techbite.entity;

import techbite.entity.Cliente;

public class ClienteAssociado extends Cliente {
    public ClienteAssociado(String cpf, String nome) {
        super(cpf, nome);
        this.desconto = 0.1;
    }
}
