package techbite.controller;

import java.util.*;

/**
 * Tela 1.4.0 - Notas fiscais
 */
public class Screen140 extends ScreenMain {
    private static final Screen140 instance = new Screen140();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[1.4.0] Notas Fiscais");

            showMenuItem("1", "📄", "Listar notas", "consultar por pedido");
            showMenuItem("2", "✨", "Gerar nota", "para pedido pago");
            showMenuItem("0", "⬅️", "Voltar", "");

            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    System.out.println("Funcao 'Listar notas' ainda nao implementada.");
                    break;
                case "2":
                    System.out.println("Funcao 'Gerar nota' ainda nao implementada.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

}
