package com.company.events;

import com.company.Main;
import com.company.console.ConsolePrinter;
import com.company.events.enums.EventTypeEnum;
import com.company.events.utils.Alerts;
import com.company.events.utils.ClipboardController;
import com.company.events.utils.Toast;
import com.company.events.utils.ToastController;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.*;

public class Event {

    public ArrayList<Calendar> EventCalendar = new ArrayList<>();
    public Timer t = new java.util.Timer();
    public String EventName;
    public String Waypoint;
    public String[] ValuableDrops;
    public EventTypeEnum[] EventType;
    private int hour;
    private int minute;
    private int second;
    private int everyHours;
    private int timesDuringDay;

    public Event(String EventName, String Waypoint, String[] ValuableDrops, EventTypeEnum[] EventType, int hour, int minute, int second, int everyHours, int timesDuringDay){
        this.EventName = EventName;
        this.Waypoint = Waypoint;
        this.ValuableDrops = ValuableDrops;
        this.EventType = EventType;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.everyHours = everyHours;
        this.timesDuringDay = timesDuringDay;

        PopulateEvents(this.hour, this.minute, this.second, this.everyHours, this.timesDuringDay);
        Init();
    }

    public void PopulateEvents(int hour, int minute, int second, int laps, int loopTimes){
        try{
            EventCalendar.clear();

            for (int i = 0; i < loopTimes; i++) {
                EventCalendar.add(SetEventTime(hour,minute,second));
                hour = hour+laps;
            }
        }catch (Exception e){
            ConsolePrinter.Error(
                    "\nMessage:\n"+e.getMessage()
                    + "\nStackTrace:\n" + e.getStackTrace()
                    + "\nCause:\n"
                    + e.getCause()+"\n");
        }
    }

    public void Init(){
        try{
            (t).schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Start();
                        }
                    },

                    RemainingTime()
            );
        }catch (Exception e){
            ConsolePrinter.Error(
                    "\nMessage:\n"+e.getMessage()
                            + "\nStackTrace:\n" + e.getStackTrace()
                            + "\nCause:\n"
                            + e.getCause()+"\n");
        }
    }

    public void Start(){
        try{
            for (EventTypeEnum evTyEn: Main.PrefEvents) {
                for (EventTypeEnum _evTyEn: this.EventType) {
                    if(evTyEn.equals(_evTyEn)){
                        ConsolePrinter.Alert(Alerts.EventIsGoingToStartMessage(this.EventName, Arrays.toString(this.EventType) ,this.Waypoint));
                        ToastController.AddToast(Alerts.EventIsGoingToStartMessage(this.EventName, Arrays.toString(this.EventType) ,this.Waypoint));
                        ClipboardController.AddToClipboard(Alerts.EventStartClipboardMessage(this.EventName, this.Waypoint));
                        break;
                    }
                }
            }

            RemainingTime();
        }catch (Exception e){
            ConsolePrinter.Error(
                    "\nMessage:\n"+e.getMessage()
                            + "\nStackTrace:\n" + e.getStackTrace()
                            + "\nCause:\n"
                            + e.getCause()+"\n");
        }
    }

    public Calendar SetEventTime(int hour, int minute, int second){
            Calendar Now = Calendar.getInstance();

            Now.set(Calendar.HOUR, hour);
            Now.set(Calendar.MINUTE, minute);
            Now.set(Calendar.SECOND, second);

            return Now;
    }

    public long RemainingTime(){
        Date actualDateMS = new java.util.Date();
        Date nextDateMS = null;

        for (int i = 0; i < this.timesDuringDay; i++) {
            if(actualDateMS.before(this.EventCalendar.get(i).getTime())){
                ConsolePrinter.Information(Alerts.NextEventStartingMessage(this.EventName, this.EventCalendar.get(i).getTime()));
                nextDateMS = this.EventCalendar.get(i).getTime();
                break;
            }
        }

        long remainingMS = nextDateMS.getTime() - actualDateMS.getTime();
        ConsolePrinter.Information(Alerts.RemainingTimeForEventMessage(this.EventName, remainingMS));

        PopulateEvents(this.hour, this.minute, this.second, this.everyHours, this.timesDuringDay);

        return remainingMS;
    }
}
