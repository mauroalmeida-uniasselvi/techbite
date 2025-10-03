package techbite.controller;

import java.util.Scanner;

/**
 * Tela 1.4.0 - Notas fiscais
 */
public class Screen140 {

    public static void show(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Tela 1.4.0 - Notas fiscais ---");
            System.out.println("1. Listar notas — consultar por pedido");
            System.out.println("2. Gerar nota — para pedido pago");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.println("Funcao 'Listar notas' ainda nao implementada.");
                    break;
                case "2":
                    System.out.println("Funcao 'Gerar nota' ainda nao implementada.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

}
