
package techbite.service.pedido;

import techbite.entity.cliente.Cliente;

import java.util.*;

public class Pedido {
    private Cliente cliente;
    private List<techbite.entity.produto.ProdutoEntity> produtos;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(techbite.entity.produto.ProdutoEntity produto) {
        produtos.add(produto);
    }

    public void listar() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos:");
        for (techbite.entity.produto.ProdutoEntity p : produtos) {
            System.out.println("- " + p);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (techbite.entity.produto.ProdutoEntity p : produtos) {
            total += p.preco();
        }
        System.out.println("Total: R$ " + total);
        return total;
    }


}
