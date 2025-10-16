package techbite.controller;

import java.util.*;

/**
 * Screen 4.6.0 - produtos parados
 */
public class Screen460 extends ScreenMain {
    private static final Screen460 instance = new Screen460();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.6.0] produtos parados");
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
