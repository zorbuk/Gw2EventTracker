package com.company.events.utils;

import com.company.console.ConsolePrinter;
import java.util.ArrayList;
import java.util.Timer;

public class ToastController {
    public static ArrayList<String> Toasts = new ArrayList<>();

    public static void AddToast(String message){
        Toasts.add(message);
    }

    public static void ShowToasts() {
        if(Toasts.size() <= 0)
            return;

        Thread t = new Thread(){
            public void run(){

                for (String availableToast: Toasts) {
                    Toast.showToast(availableToast);
                    try {
                        Thread.sleep(Toast.LENGTH_MEDIUM+500);
                    } catch (Exception e) {
                        ConsolePrinter.Error(e.getMessage());
                    }
                }

                Toasts.clear();
            }
        };

        t.start();
    }

    public static void CheckShowToasts(){
        Timer toastThread = new java.util.Timer();

        (toastThread).schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        ToastController.ShowToasts();

                        CheckShowToasts();
                    }
                },

                60000
        );
    }
}
