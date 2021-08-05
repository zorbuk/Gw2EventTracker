package com.company.events.utils;

import com.company.console.ConsolePrinter;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Timer;

public class ClipboardController {
    public static ArrayList<String> Clipboard = new ArrayList<>();

    public static void AddToClipboard(String message){
        Clipboard.add(message);
    }

    public static void SendToClipboard(){
        if(Clipboard.size() <= 0)
            return;

        Thread t = new Thread(){
            public void run(){

                String allClipboardMessage = "";

                for (String availableClipboard: Clipboard) {
                    allClipboardMessage += availableClipboard;
                }

                StringSelection stringSelection = new StringSelection(allClipboardMessage);
                java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);

                Clipboard.clear();
            }
        };

        t.start();
    }

    public static void CheckClipboard(){
        Timer ClipboardThread = new java.util.Timer();

        (ClipboardThread).schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        ClipboardController.SendToClipboard();

                        CheckClipboard();
                    }
                },

                60000
        );
    }
}
