package techbite.controller;

import java.util.*;

/**
 * Screen 4.0.0 - Relatórios
 */
public class Screen400 extends ScreenMain {
    private static final Screen400 instance = new Screen400();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.0.0] Relatórios");
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
