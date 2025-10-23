package techbite.controller;

import java.util.*;

/**
 * Screen 4.14.0 - meios de pagamento
 */
public class Screen4140 extends ScreenMain {
    private static final Screen4140 instance = new Screen4140();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    @Override
    protected void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.14.0] meios de pagamento");
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
