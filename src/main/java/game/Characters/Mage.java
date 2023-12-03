package main.java.game.Characters;

public class Mage implements Hero {
    private int level = 1;

    @Override
    public void attack() {
        System.out.println("Маг колдует заклинание с помощью волшебной палочки!");
    }

    @Override
    public void levelUp() {
        level++;
        System.out.println("Маг поднял свой уровень до " + level);
    }

    @Override
    public String getHeroType() {
        return "Маг";
    }
}