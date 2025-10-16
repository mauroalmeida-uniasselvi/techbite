package techbite;


import techbite.controller.*;

import java.util.*;

public class App {
    static void main() {
        try (Scanner scanner = new Scanner(System.in)) {
            Screen100.show(scanner);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}