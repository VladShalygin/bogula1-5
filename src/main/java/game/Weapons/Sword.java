package main.java.game.Weapons;

public class Sword implements Weapon {
    @Override
    public void useWeapon() {
        System.out.println("Махание мечом!");
    }

    @Override
    public String getWeaponType() {
        return "Меч";
    }
}