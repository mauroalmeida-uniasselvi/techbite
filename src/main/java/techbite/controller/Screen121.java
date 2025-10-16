package techbite.controller;

import java.util.*;

/**
 * Tela 1.2.1 - Formulário de criação de pedido (persistência em JSON)
 */
public class Screen121 extends ScreenMain {
    private static final Screen121 instance = new Screen121();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }


    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[1.2.1] Criação de Pedido");

            showMenuItem("1", "🛍️", "Iniciar novo pedido", "cliente, produtos e pagamento");
            showMenuItem("0", "🚪", "Voltar", "");

            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

}
