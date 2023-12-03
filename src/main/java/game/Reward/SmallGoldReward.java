package main.java.game.Reward;

public class SmallGoldReward implements GoldReward {
    int amount = 10;

    @Override
    public void showReward() {
        System.out.printf("Вы полчили %d опыта!", this.amount);
    }
}
