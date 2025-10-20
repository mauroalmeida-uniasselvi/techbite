package techbite.entity.produto;

public class Produto {

    private final techbite.entity.produto.ProdutoEntity produto;

    public Produto(techbite.entity.produto.ProdutoEntity produto) {
        this.produto = produto;
    }

    public String nome() {
        return produto.nome();
    }

    public double preco() {
        return produto.preco();
    }


}
