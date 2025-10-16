package techbite.entity.cliente;

import techbite.entity.*;

public record ClienteEntity(
        String cpf,
        String nome,
        techbite.entity.cliente.TipoCliente tipo
) implements Identifiable {

    @Override
    public String getId() {
        return cpf;
    }
}
