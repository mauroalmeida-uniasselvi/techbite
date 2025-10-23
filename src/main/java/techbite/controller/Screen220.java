package techbite.controller;

import java.util.*;

/**
 * Screen 2.2.0 - Listar produtos
 */
public class Screen220 extends ScreenMain {

    private final techbite.service.produto.ProdutoService produtoService;

    private Screen220() {
        this.produtoService = new techbite.service.produto.ProdutoServiceImpl();
    }

    private static final Screen220 instance = new Screen220();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        List<techbite.entity.produto.ProdutoEntity> produtos = this.produtoService.listar();
        while (true) {
            showHeader("[2.2.0] Listar produtos");
            showMenuItem("0", "⬅️", "Voltar", "");
            showFooter();
            for (techbite.entity.produto.ProdutoEntity produto : produtos) {
                System.out.printf(" NOME: %s PREÇO: R$%.2f\n", produto.nome(), produto.preco());
            }
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "0":
                    Screen200.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
