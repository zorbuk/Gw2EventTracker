package com.company.events;

import com.company.console.ConsolePrinter;
import com.company.events.enums.EventTypeEnum;
import com.company.events.utils.Alerts;
import com.company.events.utils.Toast;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class Event {

    public ArrayList<Calendar> EventCalendar = new ArrayList<Calendar>();
    public Timer t = new java.util.Timer();
    public String EventName;
    public String Waypoint;
    public String[] ValuableDrops;
    public EventTypeEnum EventType;
    private int hour;
    private int minute;
    private int second;
    private int everyHours;
    private int timesDuringDay;

    public Event(String EventName, String Waypoint, String[] ValuableDrops, EventTypeEnum EventType, int hour, int minute, int second, int everyHours, int timesDuringDay){
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
        EventCalendar.clear();

        for (int i = 0; i < loopTimes; i++) {
            EventCalendar.add(SetEventTime(hour,minute,second));
            hour = hour+laps;
        }
    }

    public void Init(){
        ((Timer) t).schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Start();
                    }
                },
                RemainingTime()
        );
    }

    public void Start(){
        ConsolePrinter.Alert(Alerts.EventIsGoingToStartMessage(EventName, EventType.toString() ,Waypoint));
        Toast.showToast(Alerts.EventIsGoingToStartMessage(EventName, EventType.toString() ,Waypoint));
        StringSelection stringSelection = new StringSelection(Alerts.EventStartClipboardMessage(EventName, Waypoint));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        RemainingTime();
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
            if(actualDateMS.before(EventCalendar.get(i).getTime())){
                ConsolePrinter.Information(Alerts.NextEventStartingMessage(EventName, EventCalendar.get(i).getTime()));
                nextDateMS = EventCalendar.get(i).getTime();
                break;
            }
        }

        long remainingMS = nextDateMS.getTime() - actualDateMS.getTime();
        ConsolePrinter.Information(Alerts.RemainingTimeForEventMessage(EventName, remainingMS));

        PopulateEvents(this.hour, this.minute, this.second, this.everyHours, this.timesDuringDay);

        return remainingMS;
    }
}
