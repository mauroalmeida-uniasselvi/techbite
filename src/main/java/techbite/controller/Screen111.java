package techbite.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Screen111 {

    // Simple in-memory product list for demo purposes
    private static final List<String> products = new ArrayList<>();

    public static void show(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Tela 1.1.1 - Cadastro de Produtos ---");
            System.out.println("1. Listar produtos");
            System.out.println("2. Criar novo produto");
            System.out.println("0. Voltar para tela 1.1.0");
            System.out.print("Escolha uma opcao: ");

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

    private static void listProducts() {
        System.out.println("\n== Lista de Produtos ==");
        if (products.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, products.get(i));
        }
    }

    private static void createProduct(Scanner scanner) {
        System.out.print("Nome do produto: ");
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
