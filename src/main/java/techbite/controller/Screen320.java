package techbite.controller;

import java.util.*;

/**
 * Screen 3.2.0 - Listar pedidos
 */
public class Screen320 extends ScreenMain {

    private final techbite.service.pedido.PedidoFacade pedidoFacade;

    private Screen320() {
        this.pedidoFacade = new techbite.service.pedido.PedidoFacade(
                new techbite.service.pedido.PedidoServiceImpl(),
                new techbite.service.produto.ProdutoServiceImpl(),
                new techbite.service.cliente.ClienteServiceImpl()
        );
    }

    private static final Screen320 instance = new Screen320();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private List<techbite.entity.pedido.Pedido> listarPedidos() {
        var listaPedidos = pedidoFacade.listarPedidos();
        return listaPedidos.subList(listaPedidos.size() - 3, listaPedidos.size());
    }

    @Override
    protected void showMenu(Scanner scanner) {
        List<techbite.entity.pedido.Pedido> pedidos = instance.listarPedidos();
        while (true) {
            showHeader("[3.2.0] Listar pedidos");
            showMenuItem("0", "⬅️ ", "Voltar", "");
            showFooter();
            for (techbite.entity.pedido.Pedido pedido : pedidos) {
                System.out.printf(" CPF: %s\tDATA: %s\n", pedido.cliente().cpf(), pedido.data());
                for (techbite.entity.produto.Produto produto : pedido.produtos()) {
                    System.out.printf("  - %s R$%.2f\n", produto.nome(), produto.preco());
                }
                System.out.printf(" TOTAL (DESC. %s): R$%.2f\n", pedido.cliente().tipo(), pedido.precoDesconto());
                System.out.println();
            }
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
