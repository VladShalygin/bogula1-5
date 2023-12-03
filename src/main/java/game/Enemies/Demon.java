package main.java.game.Enemies;

public class Demon implements Enemy {
    @Override
    public void takeDamage() {
        System.out.println("Демон получает урон!");
    }

    @Override
    public String getEnemyType() {
        return "Демон";
    }

    
}
