package techbite.controller;

import java.util.*;

/**
 * Screen 4.4.0 - ticket médio
 */
public class Screen440 extends ScreenMain {
    private static final Screen440 instance = new Screen440();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.4.0] ticket médio");
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
