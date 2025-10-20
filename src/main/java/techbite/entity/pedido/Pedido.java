
package techbite.service.pedido;


import java.util.*;

public class Pedido {
    private final techbite.entity.cliente.Cliente cliente;
    private final List<techbite.entity.produto.Produto> produtos;

    public Pedido(techbite.entity.cliente.Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public techbite.entity.cliente.Cliente cliente() {
        return this.cliente;
    }

    public void adicionarProduto(techbite.entity.produto.Produto produto) {
        this.produtos.add(produto);
    }

    public java.util.List<techbite.entity.produto.Produto> produtos() {
        return this.produtos;
    }

    public double precoTotal() {
        double total = 0;
        for (techbite.entity.produto.Produto p : produtos) {
            total += p.preco();
        }
        return total;
    }

}
