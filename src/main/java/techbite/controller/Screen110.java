package techbite.controller;

import java.util.Scanner;

public class Screen110 {

    public static void show(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Tela 1.1.0 - Cadastros ---");
            System.out.println("1. Clientes — listar / criar / buscar");
            System.out.println("2. Produtos — listar / criar / ajustar estoque");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.println("Funcao 'Clientes' ainda nao implementada.");
                    break;
                case "2":
                    Screen111.show(scanner);
                    break;
                case "0":
                    return; // volta para Screen100
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
}
