package techbite.entity.cliente;

public record ClienteEntity(
        String cpf,
        String nome,
        techbite.entity.cliente.TipoCliente tipo
) implements techbite.entity.StorageID {

    @Override
    public String getId() {
        return cpf;
    }
}
