package techbite.controller;

import java.util.*;

/**
 * Screen 4.1.0 - clientes ativos
 */
public class Screen410 extends ScreenMain {
    private static final Screen410 instance = new Screen410();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.1.0] clientes ativos");
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
