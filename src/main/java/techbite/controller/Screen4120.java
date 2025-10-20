package techbite.controller;

import java.util.*;

/**
 * Screen 4.12.0 - previsão de compras
 */
public class Screen4120 extends ScreenMain {
    private static final Screen4120 instance = new Screen4120();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.12.0] previsão de compras");
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
