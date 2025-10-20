package techbite.controller;

import java.util.*;

/**
 * Screen 3.2.0 - Listar pedidos
 */
public class Screen320 extends ScreenMain {

    private static final Screen320 instance = new Screen320();

    private List<techbite.entity.pedido.PedidoEntity> pedidos = Collections.emptyList();
    private final techbite.service.pedido.PedidoService pedidoService;

    private Screen320() {
        this.pedidoService = new techbite.service.pedido.PedidoService();
    }


    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[3.2.0] Listar pedidos");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    Screen300.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
