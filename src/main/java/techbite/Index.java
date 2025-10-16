
package techbite;

import techbite.entity.cliente.Cliente;
import techbite.entity.cliente.ClienteComum;
import techbite.entity.cliente.ClienteAssociado;
// import techbite.service.pagamento.Pagamento;
import techbite.service.pedido.Pedido;

public class Index {
    public static void main(String[] args) {
        techbite.entity.produto.ProdutoEntity cafe = new techbite.entity.produto.ProdutoEntity("Café", 5);
        techbite.entity.produto.ProdutoEntity refrigerante = new techbite.entity.produto.ProdutoEntity("Refrigerante", 4.5);
        techbite.entity.produto.ProdutoEntity paoovo = new techbite.entity.produto.ProdutoEntity("Pão com Ovo", 8.75);
        techbite.entity.produto.ProdutoEntity xmonstro = new techbite.entity.produto.ProdutoEntity("X-Monstro", 12.5);

        // Clientes
        Cliente cliente1 = new ClienteComum("12345678901", "João da Silva");
        Cliente cliente2 = new ClienteAssociado("98765432100", "Maria Oliveira");

        // Pedido 1
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.adicionarProduto(xmonstro);
        pedido1.adicionarProduto(refrigerante);
        System.out.println("--- Pedido 1 ---");
        pedido1.listar();
        double total1 = pedido1.calcularTotal();
        System.out.println();
        pedido1.listar();
        pedido1.calcularTotal();

        // Pedido 2
        Pedido pedido2 = new Pedido(cliente2);
        pedido2.adicionarProduto(cafe);
        pedido2.adicionarProduto(paoovo);
        System.out.println("--- Pedido 2 ---");
        pedido2.listar();
        double total2 = pedido2.calcularTotal();

        // Simulação de pagamento
        // Pagamento pagamento = new Pagamento();
        // pagamento.processarPagamento(total2);
    }
}
