package techbite.controller;

import java.util.*;

/**
 * Tela 1.2.0 - Listar clientes
 */
public class Screen120 extends ScreenMain {
    private static final Screen120 instance = new Screen120();

    private final techbite.service.cliente.ClienteService clienteService;

    private Screen120() {
        this.clienteService = new techbite.service.cliente.ClienteServiceImpl();
    }


    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    @Override
    protected void showMenu(Scanner scanner) {
        List<techbite.entity.cliente.ClienteEntity> clientes = this.clienteService.listar();
        while (true) {
            showHeader("[1.2.0] Listar clientes");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            for (techbite.entity.cliente.ClienteEntity cliente : clientes) {
                System.out.printf(" CPF: %s NOME: %s\n", cliente.cpf(), cliente.nome());
            }
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
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
