package techbite.controller;

import java.util.Scanner;

/**
 * Tela 1.3.0 - Pagamentos
 */
public class Screen130 extends ScreenMain {
    private static final Screen130 instance = new Screen130();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }
    
    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("Pagamentos v1.3.0");
            
            showMenuItem("1", "💰", "Registrar pagamento", "escolher forma e confirmar");
            showMenuItem("2", "📋", "Listar pagamentos", "histórico");
            showMenuItem("0", "⬅️", "Voltar", "");
            
            showFooter();
            showInputPrompt("Escolha uma opção: ");

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
