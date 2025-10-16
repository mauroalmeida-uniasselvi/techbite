package techbite.controller;

import java.util.*;

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
            showHeader("[1.2.0] Pedidos");

            showMenuItem("1", "🛍️", "Criar pedido", "iniciar pedido e adicionar itens");
            showMenuItem("2", "📋", "Listar pedidos", "filtrar por status/cliente");
            showMenuItem("3", "✏️", "Ver/Editar pedido", "alterar itens/status");
            showMenuItem("0", "⬅️", "Voltar", "");

            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen121.criarPedido(scanner);
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
