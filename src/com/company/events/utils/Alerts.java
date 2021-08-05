package com.company.events.utils;

import java.util.Date;

public class Alerts {
    public static String EventIsGoingToStartMessage(String EventName, String EventType, String Waypoint){
        return "¡"+ EventName +" { "+ EventType +" } está a punto de empezar! -> " + Waypoint;
    }
    public static String EventStartClipboardMessage(String EventName, String Waypoint){
        return "Está a punto de empezar "+ EventName +" -> " + Waypoint;
    }
    public static String NextEventStartingMessage(String EventName, Date StartingTime){
        return "Siguiente "+ EventName +" -> " + StartingTime;
    }
    public static String RemainingTimeForEventMessage(String EventName, long RemainingMS){
        return "Tiempo restante para "+ EventName +" -> " + (RemainingMS/1000) + " segundo(s)";
    }
}
