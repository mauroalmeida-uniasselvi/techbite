package techbite.controller;

import java.util.Scanner;

/**
 * Tela 1.2.0 - Pedidos
 */
public class Screen120 {

    public static void show(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Tela 1.2.0 - Pedidos ---");
            System.out.println("1. Criar pedido — iniciar pedido e adicionar itens");
            System.out.println("2. Listar pedidos — filtrar por status/cliente");
            System.out.println("3. Ver/Editar pedido — alterar itens/status");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen121.show(scanner);
                    break;
                case "2":
                    System.out.println("Funcao 'Listar pedidos' ainda nao implementada.");
                    break;
                case "3":
                    System.out.println("Funcao 'Ver/Editar pedido' ainda nao implementada.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

}
