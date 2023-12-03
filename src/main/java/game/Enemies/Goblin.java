package main.java.game.Enemies;

public class Goblin implements Enemy {
    @Override
    public void takeDamage() {
        System.out.println("Гоблин получает урон!");
    }

    @Override
    public String getEnemyType() {
        return "Гоблин";
    }
}