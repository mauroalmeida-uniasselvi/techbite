package techbite.controller;

import java.util.*;

public class Screen110 extends ScreenMain {
    private static final Screen110 instance = new Screen110();

    private final techbite.service.cliente.ClienteService clienteService;

    private Screen110() {
        this.clienteService = new techbite.service.cliente.ClienteServiceImpl();
    }

    private void criarCliente(String cpf, String nome, String tipo) {
        techbite.entity.cliente.TipoCliente tipoCliente;
        switch (tipo) {
            case "1":
                tipoCliente = techbite.entity.cliente.TipoCliente.COMUM;
                break;
            case "2":
                tipoCliente = techbite.entity.cliente.TipoCliente.ASSOCIADO;
                break;
            case "3":
                tipoCliente = techbite.entity.cliente.TipoCliente.FUNCIONARIO;
                break;
            default:
                System.out.println("Tipo de cliente inválido. Use 1, 2 ou 3.");
                return;
        }
        try {
            this.clienteService.criar(new techbite.entity.cliente.ClienteEntity(cpf, nome, tipoCliente));
            System.out.println("Cliente criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar cliente: " + e.getMessage());
        }
    }

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        showHeader("[1.1.0] Criar novo cliente");
        showFooter();

        showInputPrompt("Escreva o CPF: ");
        String cpf = scanner.nextLine().trim();

        showInputPrompt("Escreva o nome: ");
        String nome = scanner.nextLine().trim();

        showInputPrompt("Escolha o tipo de cliente: ([1] COMUM | [2] ASSOCIADO | [3] FUNCIONARIO)   ");
        String tipo = scanner.nextLine().trim();

        instance.criarCliente(cpf, nome, tipo);

        Screen120.show(scanner);
    }
}
