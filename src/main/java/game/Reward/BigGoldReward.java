package main.java.game.Reward;

public class BigGoldReward implements GoldReward {
    int amount = 100;

    @Override
    public void showReward() {
        System.out.printf("Вы полили %d золота", this.amount);
    }
}
