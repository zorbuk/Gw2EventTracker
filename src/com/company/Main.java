package com.company;

import com.company.console.ConsolePrinter;
import com.company.events.Event;
import com.company.events.enums.EventTypeEnum;
import com.company.events.utils.ClipboardController;
import com.company.events.utils.Toast;
import com.company.events.utils.ToastController;

import javax.sound.sampled.Clip;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

public class Main {

    /*
    Guild Wars 2 Event Tracker
    Zorbuuk.3745
    * */

    private static int NotifyBefore = 5 + 1;
    public static EventTypeEnum[] PrefEvents = new EventTypeEnum[]{
            EventTypeEnum.GoldMakingEvent,
            EventTypeEnum.WorldBoss
    };

    public static void main(String[] args) {
        ToastController.AddToast("Bienvenido a GW2 Event Tracker { By: Zorbuuk.3745 }");
        ToastController.AddToast("Este programa no interactua de ninguna manera con el juego");
        ToastController.AddToast("Todo feedback es bienvenido");

        List<Event> Events = new ArrayList<>();

        //region WorldBosses
        Events.add(
                new Event(
                        "El Asolador",
                        "[&BE4DAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        0, 0-NotifyBefore, 0, 3, 8)
        );
        Events.add(
                new Event(
                        "Chamán Svanir",
                        "[&BMIDAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        0, 15-NotifyBefore, 0, 2, 12)
        );
        Events.add(
                new Event(
                        "Modniir Ulgoth",
                        "[&BLAAAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        0, 30-NotifyBefore, 0, 3, 8)
        );
        Events.add(
                new Event(
                        "Elemental de fuego",
                        "[&BEcAAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        0, 45-NotifyBefore, 0, 2, 12)
        );
        Events.add(
                new Event(
                        "Gólem Serie II",
                        "[&BNQCAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        1, 0-NotifyBefore, 0, 3, 8)
        );
        Events.add(
                new Event(
                        "Gran sierpe de la selva",
                        "[&BEEFAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        1, 15-NotifyBefore, 0, 2, 12)
        );
        Events.add(
                new Event(
                        "Garra de Jormag",
                        "[&BHoCAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        1, 30-NotifyBefore, 0, 3, 8)
        );
        Events.add(
                new Event(
                        "Behemoth de las sombras",
                        "[&BPcAAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        1, 45-NotifyBefore, 0, 2, 12)
        );
        Events.add(
                new Event(
                        "Almirante Taidha Covington",
                        "[&BKgBAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        2, 0-NotifyBefore, 0, 3, 8)
        );
        Events.add(
                new Event(
                        "Megadestructor",
                        "[&BM0CAAA=]",
                        new String[]{
                                ""
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.WorldBoss
                        },
                        2, 30-NotifyBefore, 0, 3, 8)
        );
        // endregion
        //region GoldMakingEvents
        Events.add(
                new Event(
                        "Choya Piñata",
                        "[&BLsKAAA=]",
                        new String[]{
                                "Festive Confetti Infusion (9.5k)"
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.GoldMakingEvent
                        },
                        2, 21-NotifyBefore, 0, 2, 12)
        );
        Events.add(
                new Event(
                        "Gerente Chak",
                        "[&BPUHAAA=]",
                        new String[]{
                                "Chak Egg Sac (10k)"
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.GoldMakingEvent
                        },
                        2, 30-NotifyBefore, 0, 2, 12)
        );
        Events.add(
                new Event(
                        "Octohiedra",
                        "[&BAIIAAA=]",
                        new String[]{
                                "Vial of Liquid Aurillium (1.5k)"
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.GoldMakingEvent
                        },
                        1, 0-NotifyBefore, 0, 2, 12)
        );
        Events.add(
                new Event(
                        "Destrozador marcado por la muerte",
                        "[&BJMLAAA=]",
                        new String[]{
                                "Crystal Infusion (3.3k)"
                        },
                        new EventTypeEnum[]{
                                EventTypeEnum.GoldMakingEvent
                        },
                        0, 15-NotifyBefore, 0, 2, 12)
        );
        //endregion

        for (Event event: Events) {
            ConsolePrinter.Event("{Evento: " + event.EventName + "} {Tipo(s): " + Arrays.toString(event.EventType) + "} {Drop(s): " + Arrays.toString(event.ValuableDrops) + "}");
        }

        ToastController.ShowToasts();
        ToastController.CheckShowToasts();
        ClipboardController.SendToClipboard();
        ClipboardController.CheckClipboard();
    }
}
