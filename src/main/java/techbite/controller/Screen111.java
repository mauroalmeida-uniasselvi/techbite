package techbite.controller;

import java.io.IOException;
import java.util.*;

public class Screen111 extends ScreenMain {
    private static final Screen111 instance = new Screen111();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[1.1.1] Cadastro de Produtos");

            showMenuItem("1", "📋", "Listar produtos", "");
            showMenuItem("2", "➕", "Criar novo produto", "");
            showMenuItem("0", "⬅️", "Voltar para tela 1.1.0", "");

            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    listProducts();
                    break;
                case "2":
                    createProduct(scanner);
                    break;
                case "0":
                    return; // volta para Screen110
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }

    private void listProducts() {
        showHeader("Lista de Produtos");
        try {
            var repo = new techbite.entity.produto.ProdutoRepository();
            List<techbite.entity.produto.ProdutoEntity> produtos = repo.findAll();
            if (produtos.isEmpty()) {
                showInfo("Nenhum produto cadastrado.");
                return;
            }
            for (int i = 0; i < produtos.size(); i++) {
                System.out.println(BLUE + String.format("  %d. %s - R$ %.2f", i + 1, produtos.get(i).nome(), produtos.get(i).preco()) + RESET);
            }
            showFooter();
        } catch (IOException e) {
            showError("Falha ao carregar produtos: " + e.getMessage());
        }
    }

    private void createProduct(Scanner scanner) {
        try {
            showInputPrompt("Nome do produto: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Nome invalido. Cancelando.");
                return;
            }
            showInputPrompt("Preco (ex: 12.50): ");
            String precoStr = scanner.nextLine().trim();
            double preco;
            try {
                preco = Double.parseDouble(precoStr.replace(',', '.'));
            } catch (NumberFormatException nfe) {
                showError("Preco invalido.");
                return;
            }
            var repo = new techbite.entity.produto.ProdutoRepository();
            List<techbite.entity.produto.ProdutoEntity> produtos = repo.findAll();
            produtos.add(new techbite.entity.produto.ProdutoEntity(name, preco));
            repo.saveAll(produtos);
            System.out.println("Produto '" + name + "' criado com sucesso.");
        } catch (IOException e) {
            showError("Falha ao salvar produto: " + e.getMessage());
        }
    }

    /**
     * Retorna uma lista com os nomes dos produtos cadastrados (compatibilidade).
     */
    public static java.util.List<String> getProducts() {
        try {
            var repo = new techbite.entity.produto.ProdutoRepository();
            List<techbite.entity.produto.ProdutoEntity> produtos = repo.findAll();
            List<String> nomes = new ArrayList<>();
            for (techbite.entity.produto.ProdutoEntity p : produtos) nomes.add(p.nome());
            return nomes;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
