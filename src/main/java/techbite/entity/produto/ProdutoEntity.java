package techbite.entity.produto;

public record ProdutoEntity(String nome, double preco) {

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}
