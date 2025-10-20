package techbite.controller;

import java.util.*;

public class Screen000 extends ScreenMain {
    private static final Screen000 instance = new Screen000();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[0.0.0] Menu Principal");
            showMenuItem("1", "👥", "Clientes", "cadastro de clientes");
            showMenuItem("2", "📦", "Produtos", "cadastro de produtos");
            showMenuItem("3", "🛒", "Pedidos", "cadastro de pedidos");
            showMenuItem("4", "📊", "Relatórios", "relatórios de vendas");
            showMenuItem("0", "🚪", "Sair", "");
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen100.show(scanner);
                    break;
                case "2":
                    Screen200.show(scanner);
                    break;
                case "3":
                    Screen300.show(scanner);
                    break;
                case "4":
                    Screen400.show(scanner);
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
