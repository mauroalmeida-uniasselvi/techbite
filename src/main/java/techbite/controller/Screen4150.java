package techbite.controller;

import java.util.*;

/**
 * Screen 4.15.0 - devoluções
 */
public class Screen4150 extends ScreenMain {
    private static final Screen4150 instance = new Screen4150();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.15.0] devoluções");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("Escolha uma opção: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
