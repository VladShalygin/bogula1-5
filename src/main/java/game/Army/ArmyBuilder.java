package main.java.game.Army;

public abstract class ArmyBuilder {
    Army army;
    public abstract void createArmy();

    public abstract void addDemon();

    public abstract void addGoblin();

    public abstract void addSkeleton();

    public abstract Army getArmy();

}
