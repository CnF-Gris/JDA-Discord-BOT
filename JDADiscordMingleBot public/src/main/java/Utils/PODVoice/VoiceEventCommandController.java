package Utils.PODVoice;

import net.dv8tion.jda.api.events.guild.voice.GenericGuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;

public class VoiceEventCommandController {

    public static void eventManager(GenericGuildVoiceUpdateEvent event) {
        //Check if is null or not makes it safe to execute here
        if (event == null || event.getChannelJoined() == null)
            return; //Exits if null
        systemDisplay(event);
        //Check if is a joining event
        if (event instanceof GuildVoiceJoinEvent || event instanceof GuildVoiceMoveEvent) {
            //This is the beginning of my code
            System.out.println(event.getChannelJoined().getName());
            if (event.getChannelJoined().getName().equals("General POD")){

            }
        }
    }

    private static void systemDisplay(GenericGuildVoiceUpdateEvent event) {
        //Even if it is warned, it is safe because I already checked if null
        final String systemMessage = event.getMember().toString() + " has joined: " +
                " in " + event.getChannelJoined() +
                " [" + event.getChannelJoined().getTimeCreated() + "]";

        System.out.println(systemMessage);
    }

}
