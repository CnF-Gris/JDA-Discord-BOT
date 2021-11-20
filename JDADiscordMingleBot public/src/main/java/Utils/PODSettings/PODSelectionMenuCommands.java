package Utils.PODSettings;

import Utils.System.SystemCommands;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;


public class PODSelectionMenuCommands {

    public static void ROUND_TIME(SelectionMenuEvent event) {
        switch (event.getValues().get(0)) {
            case "5":
                SystemCommands.setPODROUNDTIME(5);
                break;
            case "10":
                SystemCommands.setPODROUNDTIME(10);
                break;
            case "15":
                SystemCommands.setPODROUNDTIME(15);
                break;
        }
    }

    public static void ROUND_NUMBER(SelectionMenuEvent event) {
        switch (event.getValues().get(0)) {
            case "5":
                SystemCommands.setPODROUNDS(5);
                break;
            case "10":
                SystemCommands.setPODROUNDS(10);
                break;
            case "15":
                SystemCommands.setPODROUNDS(15);
                break;
            case "20":
                SystemCommands.setPODROUNDS(20);
                break;
            case "30":
                SystemCommands.setPODROUNDS(30);
                break;
            case "40":
                SystemCommands.setPODROUNDS(40);
                break;
            case "50":
                SystemCommands.setPODROUNDS(50);
                break;

        }

    }
}
