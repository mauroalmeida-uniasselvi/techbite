package techbite.controller;

import java.util.*;

/**
 * Screen 4.10.0 - clientes inativos
 */
public class Screen4100 extends ScreenMain {
    private static final Screen4100 instance = new Screen4100();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.10.0] clientes inativos");
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
