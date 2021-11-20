package Utils.Text;

import Classes.Bot;
import Info.EMBEDDED_MESSAGES;
import Utils.System.MenuBuilder;
import Utils.System.MessageBuilder;
import Utils.System.SystemCommands;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;

import java.util.List;

public class TextCommands {

    private static final String helpMessage = "PlaceHolder";

    //Answer !pong if sending !ping
    public static String ping(MessageReceivedEvent event) {
        event.getChannel().sendMessage("!pong " + event.getAuthor().getAsMention()).queue();
        return "!pong";
    }

    //Ignore the member if joins in the PODs
    public static String isOrganizer(MessageReceivedEvent event) {
        if (SystemCommands.validateMOD(event)) {
            event.getChannel().sendMessage("You will be ignored for this game of PODS " + event.getAuthor().getAsMention()).queue();
            //todo: Ignore the Admin

            return "You will be ignored for this game of PODS";
        }
        event.getChannel().sendMessage("You are not authorized to use this command " + event.getAuthor().getAsMention()).queue();
        return "You are not authorized to use this command!";
    }

    //Starts the POD games
    public static String startPOD(MessageReceivedEvent event) {
        event.getChannel()
                .sendMessageEmbeds(MessageBuilder.getPODEmbed())
                .setActionRows(ActionRow.of(Button.success("POD START", "Start Pod").withEmoji(Emoji.fromMarkdown("🛎"))
                                , Button.secondary("HELP POD", "How to POD").withEmoji(Emoji.fromMarkdown("📝"))
                                , Button.danger("ABORT", "STOP").withEmoji(Emoji.fromMarkdown("✋")))
                        , ActionRow.of(Button.secondary("ROUND TIME", "Select round time").withEmoji(Emoji.fromMarkdown("⚙️"))
                                , Button.secondary("ROUNDS NUMBER", "Set rounds").withEmoji(Emoji.fromMarkdown("⚙️"))))
                .queue();
        return "Starting POD games";
    }

    public static String runningPOD(MessageReceivedEvent event){
        event.getChannel().sendMessage("Pod is already running").queue();
        return "POD games are running";
    }

    //Sends a list of commands
    public static String defaultRoute(MessageReceivedEvent event) {
        event.getChannel().sendMessage(helpMessage).mention(event.getAuthor()).queue();
        return helpMessage;
    }


}
