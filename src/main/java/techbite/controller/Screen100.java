package techbite.controller;

import java.util.Scanner;

public class Screen100 {

    public static void show(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Tela Inicial 1.0.0 ---");
            System.out.println("1. Gerenciamento — cadastros de clientes e produtos");
            System.out.println("2. Pedidos — criar, listar e editar pedidos");
            System.out.println("3. Pagamentos — registrar e listar pagamentos");
            System.out.println("4. Notas fiscais — gerar e consultar notas");
            System.out.println("5. Relatorios — relatórios básicos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen110.show(scanner);
                    break;
                case "2":
                    Screen120.show(scanner);
                    break;
                case "3":
                    Screen130.show(scanner);
                    break;
                case "4":
                    Screen140.show(scanner);
                    break;
                case "5":
                    System.out.println("Funcao 'Relatorios' ainda nao implementada.");
                    break;
                case "0":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
}
