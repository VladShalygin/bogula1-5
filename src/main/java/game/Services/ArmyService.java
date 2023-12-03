package main.java.game.Services;

import main.java.game.Army.Army;
import main.java.game.Army.ArmyBuilder;

public class ArmyService {

    public Army createArmy(ArmyBuilder builder) {
        builder.createArmy();
        builder.addGoblin();
        builder.addSkeleton();
        builder.addDemon();
        return builder.getArmy();
    };

}
