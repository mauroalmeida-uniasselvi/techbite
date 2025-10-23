package techbite.controller;

import java.util.*;

/**
 * Screen 4.0.0 - Relatórios
 */
public class Screen400 extends ScreenMain {
    private static final Screen400 instance = new Screen400();

    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }

    @Override
    protected void showMenu(Scanner scanner) {
        while (true) {
            showHeader("[4.0.0] Relatórios");
            showMenuItem("1", "👥", "clientes ativos", "compras nos últimos 30 dias");
            showMenuItem("2", "📦", "estoque em baixa", "até 40% do consumo mensal");
            showMenuItem("3", "💸", "faturamento", "por dia/semana/mês");
            showMenuItem("4", "🧾", "ticket médio", "valor médio por venda");
            showMenuItem("5", "⭐", "top produtos", "mais vendidos no período de 15 dias");
            showMenuItem("6", "🐢", "produtos parados", "sem vendas há 7 dias");
            showMenuItem("7", "📈", "evolução de vendas", "por categoria");
            showMenuItem("8", "💹", "margem por produto", "preço, custo e lucro");
            showMenuItem("9", "🔁", "recorrência de clientes", "RFM/última compra");
            showMenuItem("10", "⏳", "clientes inativos", "sem compras há 30 dias");
            showMenuItem("11", "🚚", "fornecedores", "prazo de entrega e fill rate");
            showMenuItem("12", "🧮", "previsão de compras", "sugestão por consumo");
            showMenuItem("13", "📊", "ABC de estoque", "valor e giro");
            showMenuItem("14", "💳", "meios de pagamento", "mix e taxas");
            showMenuItem("15", "↩️", "devoluções", "taxa e motivos");
            showMenuItem("0", "⬅️ ", "Voltar", "");
            showFooter();
            showInputPrompt("aguardando seleção do menu: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen410.show(scanner);
                    break;
                case "2":
                    Screen420.show(scanner);
                    break;
                case "3":
                    Screen430.show(scanner);
                    break;
                case "4":
                    Screen440.show(scanner);
                    break;
                case "5":
                    Screen450.show(scanner);
                    break;
                case "6":
                    Screen460.show(scanner);
                    break;
                case "7":
                    Screen470.show(scanner);
                    break;
                case "8":
                    Screen480.show(scanner);
                    break;
                case "9":
                    Screen490.show(scanner);
                    break;
                case "10":
                    Screen4100.show(scanner);
                    break;
                case "11":
                    Screen4110.show(scanner);
                    break;
                case "12":
                    Screen4120.show(scanner);
                    break;
                case "13":
                    Screen4130.show(scanner);
                    break;
                case "14":
                    Screen4140.show(scanner);
                    break;
                case "15":
                    Screen4150.show(scanner);
                    break;
                case "0":
                    Screen000.show(scanner);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
