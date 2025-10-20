package techbite.controller;

import java.util.*;

/**
 * Screen 4.11.0 - fornecedores
 */
public class Screen4110 extends ScreenMain {
    private static final Screen4110 instance = new Screen4110();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.11.0] fornecedores");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
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
