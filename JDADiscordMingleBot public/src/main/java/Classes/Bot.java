package Classes;

import Info.INFO_BOT;
import Utils.EventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Bot {

    //Attributes
    private final JDA discordAPI;
    private final EventListener events;

    public EventListener getEvents() {
        return events;
    }

    //Initializer
    public Bot(String TOKEN) throws Exception{
        discordAPI = JDABuilder.createDefault(INFO_BOT.Token.getString()).build();
        events = new EventListener();
        eventListenerRegistration();
    }

    //I don't know if it is useful or not
    private void eventListenerRegistration(){
        discordAPI.addEventListener(events);
    }


}
