
package techbite.entity.pedido;


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


    public String data() {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return now.format(formatter);
    }

    public String tipo() {
        return cliente.tipo();
    }

    public double preco() {
        double total = 0;
        for (techbite.entity.produto.Produto p : produtos) {
            total += p.preco();
        }
        return total;
    }

    public double precoDesconto() {
        return preco() - (preco() * cliente.desconto());
    }


    public boolean pago() {
        return true;
    }

}
