package techbite.controller;

import java.util.Scanner;

/**
 * Tela 1.2.0 - Pedidos
 */
public class Screen120 extends ScreenMain {
    private static final Screen120 instance = new Screen120();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }
    
    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("Pedidos v1.2.0");
            
            showMenuItem("1", "🛍️", "Criar pedido", "iniciar pedido e adicionar itens", GREEN);
            showMenuItem("2", "📋", "Listar pedidos", "filtrar por status/cliente", BLUE);
            showMenuItem("3", "✏️", "Ver/Editar pedido", "alterar itens/status", YELLOW);
            showMenuItem("0", "⬅️", "Voltar", "", CYAN);
            
            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen121.show(scanner);
                    break;
                case "2":
                    System.out.println("Funcao 'Listar pedidos' ainda nao implementada.");
                    break;
                case "3":
                    System.out.println("Funcao 'Ver/Editar pedido' ainda nao implementada.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

}
