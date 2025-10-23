package techbite.controller;

import java.util.*;

/**
 * Screen 4.4.0 - ticket médio
 */
public class Screen440 extends ScreenMain {
    private static final Screen440 instance = new Screen440();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    @Override
    protected void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.4.0] ticket médio");
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
