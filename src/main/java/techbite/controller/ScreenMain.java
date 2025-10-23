package techbite.controller;

import java.time.*;
import java.time.format.*;

public abstract class ScreenMain {
    // Cores ANSI
    protected static final String RESET = "\u001B[0m";
    protected static final String BLUE = "\u001B[34m";
    protected static final String CYAN = "\u001B[36m";
    protected static final String YELLOW = "\u001B[33m";
    protected static final String GREEN = "\u001B[32m";
    protected static final String PURPLE = "\u001B[35m";
    protected static final String WHITE = "\u001B[37m";

    protected static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected abstract void showMenu(java.util.Scanner scanner);

    protected void showHeader(String title) {
        clearScreen();
        String currentTime = LocalDateTime.now().atZone(java.time.ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        // Logo ASCII Art
        System.out.println(WHITE + """
                ╔════════════════════════════════════════════════════════════════╗
                ║  ████████╗███████╗ ██████╗██╗  ██╗██████╗ ██╗████████╗███████╗║
                ║  ╚══██╔══╝██╔════╝██╔════╝██║  ██║██╔══██╗██║╚══██╔══╝██╔════╝║
                ║     ██║   █████╗  ██║     ███████║██████╔╝██║   ██║   █████╗  ║
                ║     ██║   ██╔══╝  ██║     ██╔══██║██╔══██╗██║   ██║   ██╔══╝  ║
                ║     ██║   ███████╗╚██████╗██║  ██║██████╔╝██║   ██║   ███████╗║
                ║     ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝   ╚══════╝║
                ╚════════════════════════════════════════════════════════════════╝
                """ + RESET);

        System.out.println(CYAN + "╔════════════════════════════════════════════════════════════════╗");
        System.out.println("             " + title + "                   ");
        System.out.println("             " + currentTime + "                          ");
        System.out.println("╠════════════════════════════════════════════════════════════════╣" + RESET);
    }

    protected void showFooter() {
        System.out.println(CYAN + "╚════════════════════════════════════════════════════════════════╝" + RESET);
    }

    protected void showMenuItem(String number, String icon, String title, String description) {
        // Automatic color selection based on menu number
        String color = switch (number) {
            case "1" -> YELLOW;
            case "2" -> GREEN;
            case "3" -> BLUE;
            case "4" -> PURPLE;
            case "5" -> CYAN;
            default -> WHITE;
        };

        System.out.println(color + "   [" + number + "] " + icon + "  " + title + RESET + (description != null && !description.isEmpty() ? " — " + description : ""));
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