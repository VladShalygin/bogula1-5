package main.java.game.Enemies;

public class Skeleton implements Enemy {
    private int health = 50;

    @Override
    public void takeDamage() {
        System.out.println("Скелет получает урон!");
        health -= 10;
        if (health <= 0) {
            System.out.println("Skeleton is defeated!");
        }
    }

    @Override
    public String getEnemyType() {
        return "Скелет";
    }
}