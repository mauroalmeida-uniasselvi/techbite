package techbite.controller;

import java.util.*;

public class Screen100 extends ScreenMain {
    private static final Screen100 instance = new Screen100();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[1.0.0] Clientes");
            showMenuItem("1", "➕", "Criar cliente", "");
            showMenuItem("2", "📋", "Listar clientes", "");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen110.show(scanner);
                    break;
                case "2":
                    Screen120.show(scanner);
                    break;
                case "0":
                    Screen000.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
