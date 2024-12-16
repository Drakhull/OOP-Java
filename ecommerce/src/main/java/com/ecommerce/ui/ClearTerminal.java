package com.ecommerce.ui;

public class ClearTerminal {

    private ClearTerminal() {
    }

    public static void clear() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
