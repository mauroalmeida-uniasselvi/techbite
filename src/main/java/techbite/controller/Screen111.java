package techbite.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen111 extends ScreenMain {
    private static final Screen111 instance = new Screen111();
    
    // Simple in-memory product list for demo purposes
    private static final List<String> products = new ArrayList<>();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }
    
    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("Cadastro de Produtos v1.1.1");
            
            showMenuItem("1", "📋", "Listar produtos", "");
            showMenuItem("2", "➕", "Criar novo produto", "");
            showMenuItem("0", "⬅️", "Voltar para tela 1.1.0", "");
            
            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    listProducts();
                    break;
                case "2":
                    createProduct(scanner);
                    break;
                case "0":
                    return; // volta para Screen110
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    private void listProducts() {
        showHeader("Lista de Produtos");
        if (products.isEmpty()) {
            showInfo("Nenhum produto cadastrado.");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.println(BLUE + String.format("  %d. %s", i + 1, products.get(i)) + RESET);
        }
        showFooter();
    }

    private void createProduct(Scanner scanner) {
        showInputPrompt("Nome do produto: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Nome invalido. Cancelando.");
            return;
        }
        products.add(name);
        System.out.println("Produto '" + name + "' criado com sucesso.");
    }

    /**
     * Retorna uma cópia da lista de produtos cadastrados.
     */
    public static java.util.List<String> getProducts() {
        return new java.util.ArrayList<>(products);
    }
}
