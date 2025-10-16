package techbite.controller;

import java.util.*;

/**
 * Screen 4.9.0 - recorrência de clientes
 */
public class Screen490 extends ScreenMain {
    private static final Screen490 instance = new Screen490();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.9.0] recorrência de clientes");
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
