package Classes;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Gamer implements Comparable<Gamer> {
    private Member user;
    private boolean isPlaying;
    private boolean isIN;
    private boolean isOut;
    private HashSet<Member> hashSet;

    public Gamer(Member user) {
        this.user = user;
        this.isPlaying = true;
        this.isOut = false;
        hashSet = new HashSet<>(100, 100);
    }

    public Member getUser() {
        return user;
    }

    public void setUser(Member user) {
        this.user = user;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public HashSet<Member> getHashSet() {
        return hashSet;
    }

    public void setHashSet(HashSet<Member> hashSet) {
        this.hashSet = hashSet;
    }

    public boolean isIN() {
        return isIN;
    }

    public void setIN(boolean IN) {
        isIN = IN;
    }

    @Override
    public int compareTo(Gamer gamer) {
        if (this.hashSet.size() < gamer.hashSet.size()) {
            return -1;
        } else if (this.hashSet.size() == gamer.hashSet.size()) {
            return 0;
        } else {
            return 1;
        }
    }
}
