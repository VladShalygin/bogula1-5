package main.java.game.Reward;

public class BigExperienceReward implements ExperienceReward {
    int amount = 1000;

    @Override
    public void showReward() {
        System.out.printf("Вы полчили %d опыта!", this.amount);
    }
}
