package main.java.game.Location;

class Castle implements Location {
    @Override
    public void enter() {
        System.out.println("Вы переместились в замок.");
    }

    @Override
    public Location clone() {
        return new Castle();
    }
}