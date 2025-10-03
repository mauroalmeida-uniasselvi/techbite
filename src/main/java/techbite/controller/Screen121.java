package techbite.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import techbite.service.Pagamento;
import techbite.service.PagamentoCartao;
import techbite.service.PagamentoDinheiro;
import techbite.service.PagamentoPix;

/**
 * Tela 1.2.1 - Formulário de criação de pedido (simples, em memória)
 * Funcionalidades:
 * - Adicionar produto ao pedido
 * - Listar produtos disponíveis
 * - Ver itens do pedido
 * - Efetuar pagamento (simulado)
 */
public class Screen121 extends ScreenMain {
    private static final Screen121 instance = new Screen121();
    private static final List<String> cart = new ArrayList<>();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }
    
    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("Criação de Pedido v1.2.1");
            
            showMenuItem("1", "📋", "Listar produtos disponíveis", "", BLUE);
            showMenuItem("2", "➕", "Adicionar produto ao pedido", "", GREEN);
            showMenuItem("3", "🛒", "Ver itens do pedido", "", YELLOW);
            showMenuItem("4", "💳", "Efetuar pagamento", "", PURPLE);
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    listAvailableProducts();
                    break;
                case "2":
                    addProductToCart(scanner);
                    break;
                case "3":
                    viewCart();
                    break;
                case "4":
                    performPayment(scanner);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    private static void listAvailableProducts() {
        System.out.println("\n== Produtos Disponiveis ==");
        java.util.List<String> products = Screen111.getProducts();
        if (products.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, products.get(i));
        }
    }

    private static void addProductToCart(Scanner scanner) {
        java.util.List<String> products = Screen111.getProducts();
        if (products.isEmpty()) {
            System.out.println("Nenhum produto disponivel para adicionar.");
            return;
        }
        listAvailableProducts();
        System.out.print("Escolha o numero do produto para adicionar: ");
        String choice = scanner.nextLine().trim();
        try {
            int idx = Integer.parseInt(choice) - 1;
            if (idx < 0 || idx >= products.size()) {
                System.out.println("Indice invalido.");
                return;
            }
            cart.add(products.get(idx));
            System.out.println("Produto '" + products.get(idx) + "' adicionado ao pedido.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Informe o numero do produto.");
        }
    }

    private static void viewCart() {
        System.out.println("\n== Itens no Pedido ==");
        if (cart.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }
        for (int i = 0; i < cart.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, cart.get(i));
        }
    }

    private static void performPayment(Scanner scanner) {
        if (cart.isEmpty()) {
            System.out.println("Carrinho vazio. Adicione produtos antes de efetuar o pagamento.");
            return;
        }
        System.out.println("\n== Pagamento ==");
        System.out.println("Formas de pagamento:");
        System.out.println("1. Dinheiro");
        System.out.println("2. Cartao");
        System.out.println("3. Pix");
        System.out.print("Escolha a forma de pagamento: ");
        String input = scanner.nextLine().trim();

        Pagamento pagamento;
        switch (input) {
            case "1":
                pagamento = new PagamentoDinheiro();
                break;
            case "2":
                pagamento = new PagamentoCartao();
                break;
            case "3":
                pagamento = new PagamentoPix();
                break;
            default:
                System.out.println("Opcao invalida. Cancelando pagamento.");
                return;
        }

        // Como exemplo simples, calcula-se um valor fixo por item (por demo)
        double total = cart.size() * 10.0; // R$10 por item (placeholder)
        System.out.printf("Total a pagar: R$ %.2f\n", total);
        pagamento.pagar(total);
        System.out.println("Pagamento processado. Pedido finalizado (simulado).\n");
        cart.clear();
    }

}
