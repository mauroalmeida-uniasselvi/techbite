package techbite;


import java.util.*;

public class App {
    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            techbite.controller.Screen000.show(scanner);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}