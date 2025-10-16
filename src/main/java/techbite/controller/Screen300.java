package techbite.controller;

import java.util.*;

/**
 * Screen 3.0.0 - Pedidos
 */
public class Screen300 extends ScreenMain {
    private static final Screen300 instance = new Screen300();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[3.0.0] Pedidos");
            showMenuItem("1", "🛒", "Criar pedido", "");
            showMenuItem("2", "📋", "Listar pedidos", "");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("Escolha uma opção: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    break;
                case "2":
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
