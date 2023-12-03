package main.java.game.Location;

class Forest implements Location {
    @Override
    public void enter() {
        System.out.println("Вы переместились в лес.");
    }

    @Override
    public Location clone() {
        return new Forest();
    }
}