package Utils.PODVoice;

import Utils.System.SystemCommands;
import jdk.jfr.Event;
import net.dv8tion.jda.api.events.guild.voice.GenericGuildVoiceUpdateEvent;

public class VoiceCommands {

    public static void joinPOD(GenericGuildVoiceUpdateEvent event){
        if (SystemCommands.isPOD()){
            SystemCommands.REGISTER(event.getMember());
        }
    }

}
