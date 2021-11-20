package Utils.System;

import Info.POD_GIFS;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class MessageBuilder {

    private static EmbedBuilder builder = new EmbedBuilder();

    public static EmbedBuilder getBuilder() {
        builder.clear();
        return builder;
    }

    public static MessageEmbed getPODEmbed(){
        return MessageBuilder.getBuilder()
                .setTitle("POD GAMES")
                .setImage(MessageBuilder.getPODGIF())
                .build();
    }

    private static String getPODGIF() {
        switch (SystemCommands.roll(9)) {
            case 0:
                return POD_GIFS.Gif0.getUrl();
            case 1:
                return POD_GIFS.Gif1.getUrl();
            case 2:
                return POD_GIFS.Gif2.getUrl();
            case 3:
                return POD_GIFS.Gif3.getUrl();
            case 4:
                return POD_GIFS.Gif4.getUrl();
            case 5:
                return POD_GIFS.Gif5.getUrl();
            case 6:
                return POD_GIFS.Gif6.getUrl();
            case 7:
                return POD_GIFS.Gif7.getUrl();
            case 8:
                return POD_GIFS.Gif8.getUrl();
            default:
                return POD_GIFS.Gif9.getUrl();
        }
    }
}
