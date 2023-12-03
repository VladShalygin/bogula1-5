package main.java.game.RewardFactory;

import main.java.game.Reward.ExperienceReward;
import main.java.game.Reward.GoldReward;
import main.java.game.Reward.SmallExperienceReward;
import main.java.game.Reward.SmallGoldReward;

public class SmallRewardFactory implements RewardFactory{
    @Override
    public GoldReward createGoldReward() {
        return new SmallGoldReward();
    }

    @Override
    public ExperienceReward createExperienceReward() {
        return new SmallExperienceReward();
    }
}
