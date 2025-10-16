package techbite.controller;

import java.util.*;

/**
 * Screen 2.2.0 - Listar produtos
 */
public class Screen220 extends ScreenMain {
    private static final Screen220 instance = new Screen220();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[2.2.0] Listar produtos");
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
