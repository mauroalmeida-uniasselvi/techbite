package techbite.controller;

import java.util.*;

/**
 * Screen 4.7.0 - evolução de vendas
 */
public class Screen470 extends ScreenMain {
    private static final Screen470 instance = new Screen470();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    @Override
    protected void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.7.0] evolução de vendas");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    Screen400.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
