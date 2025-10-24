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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        techbite.entity.cliente.ClienteEntity cliente = (techbite.entity.cliente.ClienteEntity) o;
        return java.util.Objects.equals(cpf(), cliente.cpf());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(cpf());
    }
}
