package techbite.controller;

import java.util.*;

/**
 * Screen 3.1.0 - Criar novo pedido
 */
public class Screen310 extends ScreenMain {
    private static final Screen310 instance = new Screen310();

    private final techbite.service.pedido.PedidoService pedidoService;

    private Screen310() {
        this.pedidoService = new techbite.service.pedido.PedidoServiceImpl();
    }

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }


    private void criarPedido(String clienteId, List<String> produtos) {
        try {
            pedidoService.criar(
                    new techbite.entity.pedido.PedidoEntity(
                            UUID.randomUUID().toString().substring(0, 7),
                            clienteId,
                            produtos,
                            java.time.LocalDateTime.now(java.time.ZoneId.of("America/Sao_Paulo"))
                    )
            );
            System.out.println("Pedido criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar pedido: " + e.getMessage());
        }
    }

    private void showMenu(Scanner scanner) {
        showHeader("[3.1.0] Criar pedido");
        showFooter();

        System.out.print("Escreva ID do cliente: ");
        String clienteId = scanner.nextLine();

        List<String> produtos = new ArrayList<>();
        while (true) {
            System.out.print("Escreva ID do produto para adicionar o item (ou '0' para continuar o cadastro): ");
            String produto = scanner.nextLine();
            if (!produto.equalsIgnoreCase("0")) {
                produtos.add(produto);
                continue;
            }
            break;
        }

        instance.criarPedido(clienteId, produtos);

        Screen320.show(scanner);
    }
}
