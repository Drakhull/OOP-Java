package com.ecommerce.ui;

public class ClearTerminal {
    private ClearTerminal(){
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
