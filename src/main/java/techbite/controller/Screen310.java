package techbite.controller;

import java.util.*;

/**
 * Screen 3.1.0 - Criar novo pedido
 */
public class Screen310 extends ScreenMain {
    private static final Screen310 instance = new Screen310();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[3.1.0] Criar novo pedido");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    Screen300.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
