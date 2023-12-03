package main.java.game.Reward;

public class SmallExperienceReward implements ExperienceReward {
    int amount = 100;

    @Override
    public void showReward() {
        System.out.printf("Вы полчили %d опыта!", this.amount);

    }
}
