package techbite.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class ScreenMain {
    // Cores ANSI
    protected static final String RESET = "\u001B[0m";
    protected static final String BLUE = "\u001B[34m";
    protected static final String CYAN = "\u001B[36m";
    protected static final String YELLOW = "\u001B[33m";
    protected static final String GREEN = "\u001B[32m";
    protected static final String PURPLE = "\u001B[35m";

    protected static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected void showHeader(String title) {
        clearScreen();
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        
        // Logo ASCII Art
        System.out.println(BLUE + """
            ╔════════════════════════════════════════════════════════════════╗
            ║  ████████╗███████╗ ██████╗██╗  ██╗██████╗ ██╗████████╗███████╗║
            ║  ╚══██╔══╝██╔════╝██╔════╝██║  ██║██╔══██╗██║╚══██╔══╝██╔════╝║
            ║     ██║   █████╗  ██║     ███████║██████╔╝██║   ██║   █████╗  ║
            ║     ██║   ██╔══╝  ██║     ██╔══██║██╔══██╗██║   ██║   ██╔══╝  ║
            ║     ██║   ███████╗╚██████╗██║  ██║██████╔╝██║   ██║   ███████╗║
            ║     ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝   ╚══════╝║
            ╚════════════════════════════════════════════════════════════════╝
            """ + RESET);

        // Cabeçalho com data e hora
        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                  " + centerText(title, 48) + "                  ║");
        System.out.println("║                    " + currentTime + "                    ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣" + RESET);
    }

    protected void showFooter() {
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════════╝" + RESET);
    }

    protected void showMenuItem(String number, String icon, String title, String description, String color) {
        System.out.println(color + "║  [" + number + "] " + icon + " " + title + RESET + 
                         (description != null && !description.isEmpty() ? " — " + description : ""));
    }

    private String centerText(String text, int width) {
        if (text.length() >= width) {
            return text;
        }
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }

    protected void showInputPrompt(String prompt) {
        System.out.print("\n" + prompt);
    }

    protected void showError(String message) {
        System.out.println("\n\u001B[31m✖ Erro: " + message + RESET);
    }

    protected void showSuccess(String message) {
        System.out.println("\n\u001B[32m✔ Sucesso: " + message + RESET);
    }

    protected void showInfo(String message) {
        System.out.println("\n\u001B[36mℹ Info: " + message + RESET);
    }
}