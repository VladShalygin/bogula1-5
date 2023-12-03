package main.java.game.Weapons;

public class Wand implements Weapon {
    @Override
    public void useWeapon() {
        System.out.println("Вызов заклинания с помощью волшебной палочки!");
    }

    @Override
    public String getWeaponType() {
        return "Волшебная палочка";
    }
}