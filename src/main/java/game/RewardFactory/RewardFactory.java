package main.java.game.RewardFactory;

import main.java.game.Reward.ExperienceReward;
import main.java.game.Reward.GoldReward;

public interface RewardFactory {
    GoldReward createGoldReward();
    ExperienceReward createExperienceReward();
}
