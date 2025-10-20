package techbite.entity.cliente;

public final class ClienteFactory {

    private ClienteFactory() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ClienteEntity cliente;

        public Builder cliente(ClienteEntity cliente) {
            this.cliente = cliente;
            return this;
        }

        public Cliente build() {
            if (this.cliente != null) {
                return switch (this.cliente.tipo()) {
                    case COMUM -> new ClienteComum(this.cliente.cpf(), this.cliente.nome());
                    case ASSOCIADO -> new ClienteAssociado(this.cliente.cpf(), this.cliente.nome());
                    case FUNCIONARIO -> new ClienteFuncionario(this.cliente.cpf(), this.cliente.nome());
                };
            }
            return null;
        }
    }

}