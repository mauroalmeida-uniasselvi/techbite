package techbite.controller;

import java.util.*;

/**
 * Screen 4.13.0 - ABC de estoque
 */
public class Screen4130 extends ScreenMain {
    private static final Screen4130 instance = new Screen4130();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.13.0] ABC de estoque");
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
