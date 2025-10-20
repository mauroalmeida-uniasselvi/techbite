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

    public double desconto() {
        return this.desconto;
    }

}
