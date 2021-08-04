package com.company;


import com.company.console.ConsoleColor;
import com.company.console.ConsolePrinter;
import com.company.events.Event;
import com.company.events.enums.EventTypeEnum;
import com.company.events.utils.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int NotifyBefore = 5;
/*
Guild Wars 2 Event Tracker
Zorbuuk.3745
* */

    public static void main(String[] args) {
        Toast.showToast("Bienvenido a GW2 Event Tracker { By: Zorbuuk.3745 }");
        //System.out.println(ConsoleColor.PURPLE_BOLD_BRIGHT +"[GW2 Event Tracker] { Zorbuuk.3745 }" + ConsoleColor.RESET);

        // List of events
        List<Event> Events = new ArrayList<>();

        // Events add
        Events.add(
                new Event(
                        "Choya Piñata",
                        "[&BLsKAAA=]",
                        new String[]{
                                "Festive Confetti Infusion (9.5k)"
                        },
                        EventTypeEnum.GoldMakingEvent,
                        2, 21-NotifyBefore, 0, 2, 12)
        );

        Events.add(
                new Event(
                        "Gerente Chak",
                        "[&BPUHAAA=]",
                        new String[]{
                                "Chak Egg Sac (10k)"
                        },
                        EventTypeEnum.GoldMakingEvent,
                        2, 30-NotifyBefore, 0, 2, 12)
        );

        Events.add(
                new Event(
                        "Octohiedra",
                        "[&BAIIAAA=]",
                        new String[]{
                                "Vial of Liquid Aurillium (1.5k)"
                        },
                        EventTypeEnum.GoldMakingEvent,
                        1, 0-NotifyBefore, 0, 2, 12)
        );

        Events.add(
                new Event(
                        "Destrozador marcado por la muerte",
                        "[&BJMLAAA=]",
                        new String[]{
                                "Crystal Infusion (3.3k)"
                        },
                        EventTypeEnum.GoldMakingEvent,
                        0, 15-NotifyBefore, 0, 2, 12)
        );


        // Iterate though events
        for (Event event: Events) {
            ConsolePrinter.Event("{Evento: " + event.EventName + "} {Tipo(s): " + event.EventType + "} {Drop(s): " + Arrays.toString(event.ValuableDrops) + "}");
        }
    }
}
