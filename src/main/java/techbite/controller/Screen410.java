package techbite.controller;

import java.util.*;

/**
 * Screen 4.1.0 - clientes ativos
 */
public class Screen410 extends ScreenMain {

    private final techbite.service.pedido.PedidoFacade pedidoFacade;

    private Screen410() {
        this.pedidoFacade = new techbite.service.pedido.PedidoFacade(
                new techbite.service.pedido.PedidoServiceImpl(),
                new techbite.service.produto.ProdutoServiceImpl(),
                new techbite.service.cliente.ClienteServiceImpl()
        );
    }

    private static final Screen410 instance = new Screen410();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private Set<techbite.entity.cliente.Cliente> listarClientesAtivos() {
        var listaClientes = new HashSet<techbite.entity.cliente.Cliente>();
        var listaPedidos = pedidoFacade.listarPedidos();
        java.time.LocalDateTime data = java.time.LocalDateTime.now().minus(30, java.time.temporal.ChronoUnit.DAYS);
        for (var pedido : listaPedidos) {
            if (pedido.criadoEm().isAfter(data)) {
                listaClientes.add(pedido.cliente());
            }
        }
        return listaClientes;
    }


    @Override
    protected void showMenu(Scanner scanner) {
        var clientesAtivos = instance.listarClientesAtivos();
        while (true) {
            showHeader("[4.1.0] clientes ativos");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            for (var cliente : clientesAtivos) {
                System.out.printf(" CPF: %s\tNOME: %s\n", cliente.cpf(), cliente.nome());
                System.out.println();
            }
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    Screen400.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
