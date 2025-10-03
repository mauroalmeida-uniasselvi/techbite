
package techbite.entity;

import techbite.entity.Cliente;

public class ClienteFuncionario extends Cliente {
    public ClienteFuncionario(String cpf, String nome) {
        super(cpf, nome);
        this.desconto = 0.2;
    }
}
