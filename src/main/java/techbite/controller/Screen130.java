package techbite.controller;

import java.util.Scanner;

/**
 * Tela 1.3.0 - Pagamentos
 */
public class Screen130 {

    public static void show(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Tela 1.3.0 - Pagamentos ---");
            System.out.println("1. Registrar pagamento — escolher forma e confirmar");
            System.out.println("2. Listar pagamentos — historico");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.println("Funcao 'Registrar pagamento' ainda nao implementada.");
                    break;
                case "2":
                    System.out.println("Funcao 'Listar pagamentos' ainda nao implementada.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

}
