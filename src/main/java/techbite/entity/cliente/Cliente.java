package techbite.entity.cliente;

public abstract class Cliente {
    private final ClienteEntity cliente;
    private final double desconto;

    public Cliente(ClienteEntity cliente) {
        this.cliente = cliente;
        this.desconto = definirDesconto();
    }

    private double definirDesconto() {
        return switch (cliente.tipo()) {
            case COMUM -> 0.0;
            case ASSOCIADO -> 0.1;
            case FUNCIONARIO -> 0.2;
        };
    }

    public String cpf() {
        return this.cliente.cpf();
    }

    public String nome() {
        return this.cliente.nome();
    }

    public String tipo() {
        return this.cliente.tipo().name();
    }

    public double desconto() {
        return this.desconto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        techbite.entity.cliente.Cliente cliente1 = (techbite.entity.cliente.Cliente) o;
        return java.util.Objects.equals(cliente, cliente1.cliente);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(cliente);
    }
}
