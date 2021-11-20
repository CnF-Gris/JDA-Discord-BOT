package Utils.System;

import net.dv8tion.jda.api.interactions.components.selections.SelectionMenu;

public class MenuBuilder {

    public static SelectionMenu roundTIMEPOD(){
        SelectionMenu menu = SelectionMenu.create("ROUND TIME").setRequiredRange(1,1).setPlaceholder("Round Time")
                .addOption("5 min", "5")
                .addOption("10 min", "10")
                .addOption("15 min", "15")
                .build();
        return menu;
    }

    public static SelectionMenu roundNUMBERPOD(){
        SelectionMenu menu = SelectionMenu.create("ROUND NUMBER").setRequiredRange(1,1).setPlaceholder("Numbers of rounds")
                .addOption("5 rounds", "5")
                .addOption("10 rounds", "10")
                .addOption("15 rounds", "15")
                .addOption("20 rounds", "20")
                .addOption("30 rounds", "30")
                .addOption("40 rounds", "40")
                .addOption("50 rounds", "50")
                .build();
        return menu;
    }
}
