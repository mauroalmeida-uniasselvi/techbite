package techbite;


import techbite.controller.Screen100;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Screen100.show(scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}