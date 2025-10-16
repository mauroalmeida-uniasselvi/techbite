
package techbite.service;

import techbite.entity.Cliente;
import techbite.entity.Produto;
import java.util.*;

public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listar() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos:");
        for (Produto p : produtos) {
            System.out.println("- " + p);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.preco();
        }
        System.out.println("Total: R$ " + total);
        return total;
    }


}
