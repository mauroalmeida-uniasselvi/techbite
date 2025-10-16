package techbite.entity;

public abstract class Cliente {
    private final ClienteEntity cliente;
    private final TipoCliente tipo;
    private final double desconto;

    public Cliente(ClienteEntity cliente, TipoCliente tipo) {
        this.cliente = cliente;
        this.tipo = tipo;
        this.desconto = definirDesconto();
    }

    private double definirDesconto() {
        return switch (tipo) {
            case COMUM -> 0.0;
            case ASSOCIADO -> 0.1;
            case FUNCIONARIO -> 0.2;
        };
    }

    public String getCpf() {
        return cliente.cpf();
    }

    public String getNome() {
        return cliente.nome();
    }

    public double getDesconto() {
        return desconto;
    }

    public TipoCliente getTipo() {
        return tipo;
    }


}
