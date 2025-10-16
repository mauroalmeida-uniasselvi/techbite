package techbite.controller;

import java.util.*;

/**
 * Screen 4.5.0 - top produtos
 */
public class Screen450 extends ScreenMain {
    private static final Screen450 instance = new Screen450();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.5.0] top produtos");
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
