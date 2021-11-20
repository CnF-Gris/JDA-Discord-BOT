package Utils.PODSettings;

import Info.INFO_COMMANDS;
import Utils.System.MenuBuilder;
import Utils.System.SystemCommands;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;

public class PODButtonCommands {


    public static void POD_START(ButtonClickEvent event) {
        event.getMessage().delete().queue();
        event.getMessage().getChannel().sendMessage("POD Games are OPEN").queue();
        SystemCommands.startPOD();
        SystemCommands.setGuild(event.getGuild());
    }

    public static void POD_HELP(ButtonClickEvent event) {
        event.getMessage().delete().queue();
        event.getMessage().getChannel().sendMessage(INFO_COMMANDS.PODRules.getMessage()).queue();
    }

    public static void ABORT(ButtonClickEvent event) {
        event.getMessage().delete().queue();
        SystemCommands.stopPOD(); //Helps me controlling the flow
    }

    public static void ROUND_TIME(ButtonClickEvent event) {
        event.getMessage().delete().queue();
        event.getChannel().sendMessage("Please, Select how much time for each rounds").setActionRow(MenuBuilder.roundTIMEPOD()).queue();
    }

    public static void ROUND_NUMBERS(ButtonClickEvent event) {
        event.getMessage().delete().queue();
        event.getChannel().sendMessage("Please, Select how many rounds for this POD games session").setActionRow(MenuBuilder.roundNUMBERPOD()).queue();
    }

}
