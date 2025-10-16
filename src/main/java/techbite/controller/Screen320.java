package techbite.controller;

import java.util.*;

/**
 * Screen 3.2.0 - Listar pedidos
 */
public class Screen320 extends ScreenMain {
    private static final Screen320 instance = new Screen320();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[3.2.0] Listar pedidos");
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
