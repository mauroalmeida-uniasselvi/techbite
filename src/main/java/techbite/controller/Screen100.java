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
            showMenuItem("1", "➕", "Criar novo usuário", "");
            showMenuItem("2", "📋", "Listar usuários", "");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("Escolha uma opção: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    // TODO: Implementar criação de usuário
                    System.out.println("Funcionalidade de criação de usuário ainda não implementada.");
                    break;
                case "2":
                    // TODO: Implementar listagem de usuários
                    System.out.println("Funcionalidade de listagem de usuários ainda não implementada.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
