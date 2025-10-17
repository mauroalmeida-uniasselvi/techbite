package techbite.controller;

import java.util.*;

/**
 * Tela 1.2.0 - Listar clientes
 */
public class Screen120 extends ScreenMain {
    private static final Screen120 instance = new Screen120();

    private List<techbite.entity.cliente.ClienteEntity> clientes = Collections.emptyList();
    private final techbite.service.IClienteService clienteService;

    private Screen120() {
        this.clienteService = new techbite.service.cliente.ClienteServiceImpl();
    }

    private void listarClientes() {
        try {
            this.clientes = this.clienteService.listarClientes();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void show(Scanner scanner) {
        instance.listarClientes();
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[1.2.0] Listar usuários");
            showMenuItem("0", "⬅️", "Voltar", "");

            for (techbite.entity.cliente.ClienteEntity cliente : clientes) {
                System.out.printf("  CPF: %s NOME: %s\n", cliente.cpf(), cliente.nome());
            }

            showFooter();
            showInputPrompt("Escolha uma opção: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    Screen100.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
