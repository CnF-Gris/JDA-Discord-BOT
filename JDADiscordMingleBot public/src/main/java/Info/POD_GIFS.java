package Info;

public enum POD_GIFS {
    Gif0("https://c.tenor.com/vHX5PROCREIAAAAC/fresh-prince-of-bel-air-dancing.gif"),
    Gif1("https://c.tenor.com/4-C47Bn_MUgAAAAd/friday-happy-dance.gif"),
    Gif2("https://c.tenor.com/GjHsTaewY28AAAAC/chris-pratt-andy.gif"),
    Gif3("https://c.tenor.com/m5DhDpCUBrQAAAAC/happy-im-so-happy.gif"),
    Gif4("https://c.tenor.com/mhCw9HpvfIAAAAAC/fresh-prince-of-bel-air-carlton.gif"),
    Gif5("https://c.tenor.com/SkUhBTtiQG0AAAAC/friends-phoebe.gif"),
    Gif6("https://c.tenor.com/0nV04cpKAF8AAAAC/happy-dance.gif"),
    Gif7("https://c.tenor.com/fJh-W38iA3oAAAAC/dance-kid.gif"),
    Gif8("https://c.tenor.com/y_NLohYyZ6EAAAAC/playit-chuckberrystyle.gif"),
    Gif9("https://c.tenor.com/PiGmcEswsd0AAAAM/incredible-dance-crazy-dance.gif"),
    ;

    private String url;

    POD_GIFS(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
