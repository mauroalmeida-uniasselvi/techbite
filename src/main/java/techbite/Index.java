
package techbite;

import techbite.entity.Cliente;
import techbite.entity.ClienteComum;
import techbite.entity.ClienteAssociado;
import techbite.entity.Produto;
// import techbite.service.Pagamento;
import techbite.service.Pedido;

import java.util.*;

public class Index {
    public static void main(String[] args) {
        Produto cafe = new Produto("Café", 5);
        Produto refrigerante = new Produto("Refrigerante", 4.5);
        Produto paoovo = new Produto("Pão com Ovo", 8.75);
        Produto xmonstro = new Produto("X-Monstro", 12.5);

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
