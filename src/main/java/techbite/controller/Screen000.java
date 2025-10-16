package techbite.controller;

import java.util.*;

public class Screen100 extends ScreenMain {
    private static final Screen100 instance = new Screen100();
    
    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }
    
    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[0.0.0] Menu Principal");

            showMenuItem("1", "👥", "Clientes", "cadastro básico");
            showMenuItem("2", "�", "Produtos", "cadastro básico");
            showMenuItem("3", "�", "Pedidos", "criar, listar e editar pedidos");
            showMenuItem("4", "📊", "Relatórios", "relatórios básicos");
            showMenuItem("5", "🚪", "Sair", "");

            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen110.show(scanner);
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
                case "5":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
