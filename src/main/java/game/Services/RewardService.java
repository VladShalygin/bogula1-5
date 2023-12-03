package main.java.game.Services;

import main.java.game.Reward.Reward;
import main.java.game.RewardFactory.BigRewardFactory;
import main.java.game.RewardFactory.SmallRewardFactory;

import java.util.Random;

public class RewardService {

    BigRewardFactory bigRewardFactory = new BigRewardFactory();
    SmallRewardFactory smallRewardFactory = new SmallRewardFactory();

    public Reward createReward() {
        Random rand = new Random();
        int reward_number = rand.nextInt(1, 5);

        switch (reward_number){
            case 1: return bigRewardFactory.createGoldReward();
            case 2: return bigRewardFactory.createExperienceReward();
            case 3: return smallRewardFactory.createExperienceReward();
            case 4: return smallRewardFactory.createGoldReward();
        }

        return smallRewardFactory.createGoldReward();
    }

}
