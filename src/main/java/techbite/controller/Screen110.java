package techbite.controller;

import java.util.Scanner;

public class Screen110 extends ScreenMain {
    private static final Screen110 instance = new Screen110();
    
    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }
    
    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("Cadastros v1.1.0");
            
            showMenuItem("1", "👥", "Clientes", "listar / criar / buscar", YELLOW);
            showMenuItem("2", "📦", "Produtos", "listar / criar / ajustar estoque", GREEN);
            showMenuItem("0", "⬅️", "Voltar", "", CYAN);
            
            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.println("Funcao 'Clientes' ainda nao implementada.");
                    break;
                case "2":
                    Screen111.show(scanner);
                    break;
                case "0":
                    return; // volta para Screen100
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
}
