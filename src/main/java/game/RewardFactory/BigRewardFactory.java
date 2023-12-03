package main.java.game.RewardFactory;

import main.java.game.Reward.BigExperienceReward;
import main.java.game.Reward.BigGoldReward;
import main.java.game.Reward.ExperienceReward;
import main.java.game.Reward.GoldReward;

public class BigRewardFactory implements RewardFactory{
    @Override
    public GoldReward createGoldReward() {
        return new BigGoldReward();
    }

    @Override
    public ExperienceReward createExperienceReward() {
        return new BigExperienceReward();
    }
}
