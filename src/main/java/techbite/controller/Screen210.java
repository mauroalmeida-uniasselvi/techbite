package techbite.controller;

import java.util.*;

/**
 * Screen 2.1.0 - Criar novo produto
 */
public class Screen210 extends ScreenMain {
    private static final Screen210 instance = new Screen210();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[2.1.0] Criar novo produto");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    Screen200.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
