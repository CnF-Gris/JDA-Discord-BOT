package Utils.Text;

import Info.INFO_COMMANDS;
import Utils.System.SystemCommands;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MessageCommandController {

    public static void eventManager(MessageReceivedEvent event){
        systemDisplay(event);
        String message = event.getMessage().getContentRaw();
        if (message.charAt(0) != '!' || event.getAuthor().isBot())
            return;
        message = message.substring(1); //Now I won't have to remember to put ! at the beginning of each command
        switch (message.toLowerCase()){ //Each command will require more cases
            case "ping":
                TextCommands.ping(event);
                break;
            case "start":
                if (!SystemCommands.isPOD())
                    TextCommands.startPOD(event);
                else

                break;
            case "isorganizer":
                TextCommands.isOrganizer(event);
                break;
            //Safe to not check for !
            default:
                TextCommands.defaultRoute(event);
                break;
        }
    }

    private static void systemDisplay(MessageReceivedEvent event){

        final String systemMessage = event.getAuthor().toString() + " has sent: " +
                                     event.getMessage().getContentRaw() + " in " +
                                     event.getMessage().getChannel() +
                                     " [" + event.getMessage().getTimeCreated() +"]";

        System.out.println(systemMessage);
    }

    //Never used YET
    private static void systemDisplay(String msg){
        System.out.println(msg);
    }
}
