package com.company.console;

public class ConsolePrinter {
    public static void Information(String mensaje){
        System.out.println(ConsoleColor.BLUE + "[Información] " + mensaje + ConsoleColor.RESET);
    }
    public static void Alert(String mensaje){
        for (int i = 0; i < 3; i++){
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
        System.out.println(ConsoleColor.GREEN + "[Alerta] " + mensaje + ConsoleColor.RESET);
    }
    public static void Event(String mensaje){
        System.out.println(ConsoleColor.YELLOW + "[✔] " + mensaje + ConsoleColor.RESET);
    }
}
