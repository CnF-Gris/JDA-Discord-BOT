package Info;

public enum INFO_COMMANDS {

    Prefix("!"),
    PODRules("RULES"),
    HELP("Placeholder");

    private String message;

    INFO_COMMANDS(String prefix){
        this.message = prefix;
    }

    public String getMessage() {
        return message;
    }
}
