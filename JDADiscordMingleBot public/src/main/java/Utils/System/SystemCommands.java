package Utils.System;

import Classes.Gamer;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class SystemCommands {

    //Nested class
    protected static class GamerArray {
        private static Gamer[] gamers;
        private static int size = 0;
        private static boolean isEmpty;

        public static void initialize() {
            gamers = new Gamer[100];
        }

        protected static void deinitialize() {
            gamers = null;
        }

        protected static void sortArray() {
            Arrays.sort(gamers);
        }

        protected static void REGISTER(Gamer gamer) {
            gamers[size] = gamer;
            size++;
        }

        protected static void DEREGISTER(Gamer gamer) {
            //Search before Deregistering
            for (int i = 0; i < gamers.length; i++) {
                if (gamers[i] == gamer) {
                    gamers[i] = null;
                    sortArray();
                    size--;
                    break;
                }
            }
        }
    }

    //Attributes
    private static Guild guild;
    //TODO: Clean all of this mess
    private static Category POD = guild.getCategoriesByName("POD Channel", false).get(0);
    private static VoiceChannel PODHOME;
    private static boolean isPOD;
    private static int PODROUNDS = 20;
    private static int PODROUNDTIME = 5;
    private static HashMap<Member, Gamer> GamerMap;
    private static Timer timer;

    public static int getPODROUNDS() {
        return PODROUNDS;
    }

    public static void setPODROUNDS(int PODROUNDS) {
        SystemCommands.PODROUNDS = PODROUNDS;
    }

    public static int getPODROUNDTIME() {
        return PODROUNDTIME;
    }

    public static void setPODROUNDTIME(int PODROUNDTIME) {
        SystemCommands.PODROUNDTIME = PODROUNDTIME;
    }

    //#Timer Tasks
    //----------------------------------------------------------
    private static final TimerTask ClosePOD = new TimerTask() {
        @Override
        public void run() {
            stopPOD();
            timer.cancel();
        }
    };

    private static final TimerTask shuffle = new TimerTask() {
        @Override
        public void run() {
            SHUFFLE();
        }
    };
    //----------------------------------------------------------


    //Starts Pod and Initialize the Hashmap
    public static void startPOD() {
        setPODHOME();
        SystemCommands.isPOD = true;
        GamerMap = new HashMap<>(100, 100);
        GamerArray.initialize();
        timer = new Timer();
        timer.schedule(ClosePOD, 30 * 60 * 1000 + ((long) PODROUNDTIME * 60 * 1000 * PODROUNDS));
        timer.schedule(shuffle, 30 * 60 * 1000, ((long) PODROUNDTIME * 60 * 1000));
    }

    //Helps reducing garbage
    public static void stopPOD() {
        SystemCommands.isPOD = false;
        GamerMap = null;
        GamerArray.deinitialize();
        timer = null;
        PODROUNDTIME = 5;
        PODROUNDS = 20;
    }

    //Checks if the member requesting the command is allowed
    public static boolean validateMOD(MessageReceivedEvent event) {
        if (event.getMember() != null)
            return event.getMember().getPermissions().contains(Permission.ADMINISTRATOR);
        return false;
    }

    //Todo: Add a shuffle method
    private static void SHUFFLE() {
        int i = 0;
        GamerArray.sortArray();
        for (int f = 0; f < GamerArray.gamers.length; f++) {
            guild.moveVoiceMember(GamerArray.gamers[f].getUser(), PODHOME).queue();
            GamerArray.gamers[f].setIN(false);
        }
        DECONSTRUCT();
        INITIALIZE();
        for (VoiceChannel vc : POD.getVoiceChannels()) {
            if (vc.getName().contains("%")) {
                while (GamerArray.gamers[i].isIN() && i < GamerArray.gamers.length)
                    i++;
                if (!(i < GamerArray.gamers.length))
                    break;
                Gamer Player1 = GamerArray.gamers[i];
                guild.moveVoiceMember(Player1.getUser(), vc).queue();
                Gamer Player2 = searchNonDuplicate(Player1);
                if (Player2 != null) {
                    guild.moveVoiceMember(Player2.getUser(), vc).queue();
                    Player2.setIN(true);
                }
                Player1.setIN(true);
            }
            i++;
        }
    }

    private static Gamer searchNonDuplicate(Gamer gamer) {
        for (int i = 0; i < GamerArray.gamers.length; i++) {
            if (!GamerArray.gamers[i].getHashSet().contains(GamerArray.gamers[i].getUser()) && !GamerArray.gamers[i].isIN())
                gamer.getHashSet().add(GamerArray.gamers[i].getUser());
                return GamerArray.gamers[i];
        }
        for (int i = 0; i < GamerArray.gamers.length; i++) {
            if (!GamerArray.gamers[i].isIN())
                return GamerArray.gamers[i];
        }
        return null;
    }



    private static void INITIALIZE() {
        final int voiceChannelNumber = GamerMap.size() / 2;
        final String voicePodChannel = "%POD ";
        for (int i = 0; i < voiceChannelNumber; i++) {
            guild.createVoiceChannel(voicePodChannel + i, POD).setUserlimit(2).queue();
        }
    }

    private static void DECONSTRUCT() {
        for (VoiceChannel vc : POD.getVoiceChannels()) {
            if (vc.getName().contains("%")) {
                vc.delete().queue();
            }
        }
    }

    public static boolean isPOD() {
        return isPOD;
    }

    public static int roll(int upperBound) {
        return (int) (Math.floor(Math.random() * upperBound));
    }

    public static void REGISTER(Member user) {
        if (!GamerMap.containsKey(user)) { //Check if the user is already registered
            Gamer temp = new Gamer(user);
            GamerMap.put(user, temp);
            GamerArray.REGISTER(temp);
        }


    }

    //To be done only if the player has been out for a long time
    public static void UNREGISTER(User user) {
        if (!GamerMap.containsKey(user)) {
            Gamer temp = GamerMap.remove(user);
            GamerArray.DEREGISTER(temp);
        }
    }

    public static Guild getGuild() {
        return guild;
    }

    public static void setGuild(Guild guild) {
        SystemCommands.guild = guild;
    }

    public static void setPODHOME() {
        for (VoiceChannel vc : POD.getVoiceChannels()) {
            if (vc.getName().equals("General POD")) {
                PODHOME = vc;
            }
        }
    }
}
