package main.java.game.Army;

import main.java.game.Enemies.Demon;
import main.java.game.Enemies.Goblin;
import main.java.game.Enemies.Skeleton;

import java.util.ArrayList;
public class Army {
    public ArrayList<Demon> demons = new ArrayList<Demon>();
    public ArrayList<Goblin> goblins = new ArrayList<Goblin>();
    public ArrayList<Skeleton> skeletons = new ArrayList<Skeleton>();

    public void show() {
        demons.forEach(demon -> System.out.println(demon.getEnemyType()));
        goblins.forEach(goblin -> System.out.println(goblin.getEnemyType()));
        skeletons.forEach(skeleton -> System.out.println(skeleton.getEnemyType()));
    }
}
