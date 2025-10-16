package techbite.controller;

import java.util.*;

/**
 * Screen 2.0.0 - Produtos
 */
public class Screen200 extends ScreenMain {
    private static final Screen200 instance = new Screen200();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[2.0.0] Produtos");
            showMenuItem("1", "➕", "Criar novo produto", "");
            showMenuItem("2", "📋", "Listar produtos", "");
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
