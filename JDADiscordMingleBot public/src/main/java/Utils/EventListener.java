package Utils;

import Utils.PODSettings.PODSettingsController;
import Utils.System.SystemCommands;
import Utils.Text.MessageCommandController;
import Utils.PODVoice.VoiceEventCommandController;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent;
import net.dv8tion.jda.api.events.interaction.SelectionMenuEvent;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageCommandController.eventManager(event);
    }

    @Override
    public void onGuildVoiceJoin(@NotNull GuildVoiceJoinEvent event) {
        //if (SystemCommands.isPOD())
            VoiceEventCommandController.eventManager(event);
    }

    @Override
    public void onGuildVoiceMove(@NotNull GuildVoiceMoveEvent event) {
        //if (SystemCommands.isPOD())
            VoiceEventCommandController.eventManager(event);
    }

    @Override
    public void onButtonClick(ButtonClickEvent event){
        PODSettingsController.buttonHandler(event);
    }

    @Override
    public void onSlashCommand(SlashCommandEvent event){
        PODSettingsController.slashCommandsHandler(event);
    }

    @Override
    public void onSelectionMenu(SelectionMenuEvent event){

    }

}
