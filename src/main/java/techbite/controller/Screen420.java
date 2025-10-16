package techbite.controller;

import java.util.*;

/**
 * Screen 4.2.0 - estoque em baixa
 */
public class Screen420 extends ScreenMain {
    private static final Screen420 instance = new Screen420();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.2.0] estoque em baixa");
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
