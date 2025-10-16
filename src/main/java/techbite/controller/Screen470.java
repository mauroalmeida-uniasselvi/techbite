package techbite.controller;

import java.util.*;

/**
 * Screen 4.7.0 - evolução de vendas
 */
public class Screen470 extends ScreenMain {
    private static final Screen470 instance = new Screen470();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.7.0] evolução de vendas");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("Escolha uma opção: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
