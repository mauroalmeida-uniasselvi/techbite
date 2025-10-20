package techbite.controller;

import java.util.*;

/**
 * Screen 2.1.0 - Criar novo produto
 */
public class Screen210 extends ScreenMain {
    private static final Screen210 instance = new Screen210();

    private final techbite.service.produto.ProdutoService produtoService;

    private Screen210() {
        this.produtoService = new techbite.service.produto.ProdutoServiceImpl();
    }

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void criarProduto(String id, String nome, String descricao, String precoStr) {
        double preco;
        try {
            preco = Double.parseDouble(precoStr);
        } catch (NumberFormatException e) {
            System.out.println("Preço inválido. Produto não criado.");
            return;
        }
        try {
            produtoService.criar(new techbite.entity.produto.ProdutoEntity(id, nome, descricao, preco));
            System.out.println("Produto criado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }
    }


    private void showMenu(Scanner scanner) {
        showHeader("[2.1.0] Criar produto");

        showFooter();

        showInputPrompt("Escreva o ID: ");
        String id = scanner.nextLine().trim();

        showInputPrompt("Escreva o nome: ");
        String nome = scanner.nextLine().trim();

        showInputPrompt("Escreva a descrição: ");
        String descricao = scanner.nextLine().trim();

        showInputPrompt("Escreva o preço: ");
        String preco = scanner.nextLine().trim();

        instance.criarProduto(id, nome, descricao, preco);

        Screen220.show(scanner);
    }
}
