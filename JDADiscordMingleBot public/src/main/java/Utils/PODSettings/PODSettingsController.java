package Utils.PODSettings;

import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class PODSettingsController {

    public static void buttonHandler(ButtonClickEvent event) {
        switch (event.getComponent().getId()) {
            case "POD START":
                PODButtonCommands.POD_START(event);
                break;
            case "HELP POD":
                PODButtonCommands.POD_HELP(event);
                break;
            case "ABORT":
                PODButtonCommands.ABORT(event);
                break;
            case "ROUND TIME":
                PODButtonCommands.ROUND_TIME(event);
                break;
            case "ROUNDS NUMBER":
                PODButtonCommands.ROUND_NUMBERS(event);
                break;
            default:
                System.out.println(event.getComponent().getId());
                break;
        }
    }

    public static void selectionMenuHandler(SelectionMenuEvent event){
        switch (event.getComponent().getId()){
            case "ROUND TIME":

                break;
            case "ROUND NUMBER":

                break;

        }
    }


    public static void slashCommandsHandler(SlashCommandEvent event){
        System.out.println(event.getName().toString());
    }

}
