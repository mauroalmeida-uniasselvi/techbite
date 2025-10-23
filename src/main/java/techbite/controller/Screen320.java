package techbite.controller;

import java.util.*;

/**
 * Screen 3.2.0 - Listar pedidos
 */
public class Screen320 extends ScreenMain {

    private final techbite.service.pedido.PedidoService pedidoService;
    private final techbite.service.produto.ProdutoService produtoService;
    private final techbite.service.cliente.ClienteService clienteService;

    private Screen320() {
        this.pedidoService = new techbite.service.pedido.PedidoServiceImpl();
        this.produtoService = new techbite.service.produto.ProdutoServiceImpl();
        this.clienteService = new techbite.service.cliente.ClienteServiceImpl();
    }

    private static final Screen320 instance = new Screen320();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private List<techbite.entity.pedido.Pedido> listarPedidos() {
        List<techbite.entity.pedido.Pedido> pedidos = new ArrayList<>();
        List<techbite.entity.pedido.PedidoEntity> pedidosEntity = this.pedidoService.listar();
        for (techbite.entity.pedido.PedidoEntity pedidoEntity : pedidosEntity.subList(pedidosEntity.size() -5, pedidosEntity.size())) {
            techbite.entity.cliente.ClienteEntity clienteEntity = this.clienteService.obterPorId(pedidoEntity.cliente());
            techbite.entity.cliente.Cliente cliente = techbite.entity.cliente.ClienteFactory.builder().cliente(clienteEntity).build();
            techbite.entity.pedido.Pedido pedido = new techbite.entity.pedido.Pedido(cliente, pedidoEntity.criadoEm());
            for (String produtoId : pedidoEntity.produtos()) {
                techbite.entity.produto.ProdutoEntity produtoEntity = this.produtoService.obterPorId(produtoId);
                if (produtoEntity != null) {
                    techbite.entity.produto.Produto produto = new techbite.entity.produto.Produto(produtoEntity);
                    pedido.adicionarProduto(produto);
                }
            }
            pedidos.add(pedido);
        }
        return pedidos;
    }


    private void showMenu(Scanner scanner) {
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
