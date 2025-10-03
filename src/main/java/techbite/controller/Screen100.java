package techbite.controller;

import java.util.Scanner;

public class Screen100 extends ScreenMain {
    private static final Screen100 instance = new Screen100();
    
    public static void show(Scanner scanner) {
        instance.showMenu(scanner);
    }
    
    private void showMenu(Scanner scanner) {
        while (true) {
            showHeader("Sistema de Gestão v1.0.0");
            
            // Menu principal com cores e ícones
            showMenuItem("1", "⚙️", "Gerenciamento", "cadastros de clientes e produtos", YELLOW);
            showMenuItem("2", "📋", "Pedidos", "criar, listar e editar pedidos", GREEN);
            showMenuItem("3", "💰", "Pagamentos", "registrar e listar pagamentos", BLUE);
            showMenuItem("4", "📄", "Notas fiscais", "gerar e consultar notas", PURPLE);
            showMenuItem("5", "📊", "Relatórios", "relatórios básicos", CYAN);
            showMenuItem("0", "🚪", "Sair", "", YELLOW);
            
            showFooter();
            showInputPrompt("Escolha uma opção: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    Screen110.show(scanner);
                    break;
                case "2":
                    Screen120.show(scanner);
                    break;
                case "3":
                    Screen130.show(scanner);
                    break;
                case "4":
                    Screen140.show(scanner);
                    break;
                case "5":
                    System.out.println("Funcao 'Relatorios' ainda nao implementada.");
                    break;
                case "0":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
    }
}
