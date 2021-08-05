package com.company.console;

public class ConsolePrinter {
    // FIX COLORS FOR CMD

    public static void Information(String mensaje){
        System.out.println("[Información] " + mensaje);
    }
    public static void Alert(String mensaje){
        for (int i = 0; i < 3; i++){
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
        System.out.println("[Alerta] " + mensaje);
    }
    public static void Event(String mensaje){
        System.out.println("[✔] " + mensaje);
    }

    public static void Error(String mensaje) {
        System.out.println("[Error] "+ mensaje);
    }
}
