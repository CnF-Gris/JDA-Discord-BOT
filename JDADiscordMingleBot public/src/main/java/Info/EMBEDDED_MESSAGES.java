package Info;

import Utils.System.MessageBuilder;
import Utils.System.SystemCommands;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public enum EMBEDDED_MESSAGES {
    ;

    private MessageEmbed messageEmbed;

    public MessageEmbed getMessageEmbed() {
        return messageEmbed;
    }

    EMBEDDED_MESSAGES(MessageEmbed messageEmbed){
        this.messageEmbed = messageEmbed;
    }
}
