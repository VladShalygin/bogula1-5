package main.java.game.Characters;

public class Warrior implements Hero {
    private int level = 1;

    @Override
    public void attack() {
        System.out.println("Солдат атакует с помощтю своего оружия!");
    }

    @Override
    public void levelUp() {
        level++;
        System.out.println("Солдал повысил уровень до " + level);
    }

    @Override
    public String getHeroType() {
        return "Солдат";
    }
}