package main.java.game.Army;

import main.java.game.Enemies.Goblin;
import main.java.game.Enemies.Skeleton;

public class SimpleArmyBuilder extends ArmyBuilder {

    @Override
    public void createArmy() {
        this.army = new Army();
    }

    @Override
    public void addDemon() {
        System.out.println("Вы не можете добавить в простую армию демонов!");
    }

    @Override
    public void addGoblin() {
        this.army.goblins.add(new Goblin());
    }

    @Override
    public void addSkeleton() {
        this.army.skeletons.add(new Skeleton());
    }

    @Override
    public Army getArmy() {
        return this.army;
    }
}
