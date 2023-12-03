package main.java.game.Menu;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.game.Army.Army;
import main.java.game.Army.DemonArmyBuilder;
import main.java.game.Army.SimpleArmyBuilder;
import main.java.game.Characters.Hero;
import main.java.game.Characters.Warrior;
import main.java.game.Characters.Mage;
import main.java.game.Enemies.Enemy;
import main.java.game.Enemies.Goblin;
import main.java.game.Enemies.Skeleton;
import main.java.game.Location.PrototypeManager;
import main.java.game.Reward.Reward;
import main.java.game.Services.ArmyService;
import main.java.game.Services.RewardService;
import main.java.game.Weapons.Sword;
import main.java.game.Weapons.Wand;
import main.java.game.Weapons.Weapon;
import main.java.game.Factories.CharacterFactory;
import main.java.game.Factories.EnemyFactory;
import main.java.game.Factories.WeaponFactory;
import main.java.game.Location.Location;
public class GameMenu implements Menu {
    private final Scanner scanner = new Scanner(System.in);
    private Hero hero;
    private Weapon weapon;

    private final RewardService rewardService = new RewardService();
    private final ArmyService armyService = new ArmyService();
    private final ArrayList<Reward> rewards = new ArrayList<Reward>();

    private final PrototypeManager prototypeManager = PrototypeManager.getInstance();

    public GameMenu() {
    }

    @Override
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n===== Game Menu =====");
            System.out.println("1. Выбрать героя");
            System.out.println("2. Атаковать врага");
            System.out.println("3. Улучшить оружие");
            System.out.println("4. Улучшить героя");
            System.out.println("5. Призвать армию");
            System.out.println("6. Сменить локацию");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> selectHero();
                case 2 -> attackEnemy();
                case 3 -> upgradeWeapon();
                case 4 -> upgradeHero();
                case 5 -> summonArmy();
                case 6 -> enterLocation();
                case 0 -> System.out.println("Выход из игры!");
                default -> System.out.println("Неправельный выбор! Выберите существующий пункт меню!");
            }
        } while (choice != 0);

        scanner.close();
    }

    private void enterLocation() {
        System.out.println("Выберите локацию:");
        System.out.println("1. Лес");
        System.out.println("2. Замок");
        int locationChoice = scanner.nextInt();

        Location location;
        switch (locationChoice) {
            case 1 -> location = prototypeManager.getLocation("forest");
            case 2 -> location = prototypeManager.getLocation("castle");
            default -> {
                System.out.println("Неверный выбор. По умолчанию выбирается лес.");
                location = prototypeManager.getLocation("forest");
            }
        }

        if (location != null) {
            location.enter();
        }
    }
    private void summonArmy() {
        System.out.println("Выберите тип армии:");
        System.out.println("1. Простая");
        System.out.println("2. С демоном");
        System.out.print("Выберите действие: ");
        int armyChoice = scanner.nextInt();

        Army army;
        switch (armyChoice) {
            case 1 -> {
                SimpleArmyBuilder simpleArmyBuilder = new SimpleArmyBuilder();
                army = armyService.createArmy(simpleArmyBuilder);
            }
            case 2 -> {
                DemonArmyBuilder demonArmyBuilder = new DemonArmyBuilder();
                army = armyService.createArmy(demonArmyBuilder);
            }
            default -> {
                System.out.println("Неверное значение! Выберается значение по умолчанию: Простая армия.");
                SimpleArmyBuilder defaultArmyBuilder = new SimpleArmyBuilder();
                army = armyService.createArmy(defaultArmyBuilder);
            }
        }
        army.show();
    }

    private void selectHero() {
        System.out.println("Выберите героя:");
        System.out.println("1. Солдат");
        System.out.println("2. Маг");
        int heroChoice = scanner.nextInt();

        CharacterFactory characterFactory;
        WeaponFactory weaponFactory;
        switch (heroChoice) {
            case 1 -> {
                characterFactory = new WarriorFactory();
                weaponFactory = new SwordFactory();
            }
            case 2 -> {
                characterFactory = new MageFactory();
                weaponFactory = new WandFactory();
            }
            default -> {
                System.out.println("Неверное значение! Выберается значение по умолчанию: Солдат.");
                characterFactory = new WarriorFactory();
                weaponFactory = new SwordFactory();
            }
        }
        hero = characterFactory.createHero();
        weapon = weaponFactory.createWeapon();
        System.out.println("Вы выбрали: " + hero.getHeroType());
        System.out.println("Выдано оружие: " + weapon.getWeaponType());
    }

    private void attackEnemy() {
        if (this.hero == null) {
            System.out.println("Вы не выбрали героя!");
            return ;
        }
        System.out.println("Выберите врага для атаки:");
        System.out.println("1. Гоблин");
        System.out.println("2. Скелет");
        int enemyChoice = scanner.nextInt();

        EnemyFactory enemyFactory;
        switch (enemyChoice) {
            case 1 -> enemyFactory = new GoblinFactory();
            case 2 -> enemyFactory = new SkeletonFactory();
            default -> {
                System.out.println("Невыерный выбор! Выбирается враг по умолчанию: Гоблин.");
                enemyFactory = new GoblinFactory();
            }
        }

        Enemy enemy = enemyFactory.createEnemy();
        System.out.println("Вы атаковали " + enemy.getEnemyType());
        hero.attack();
        enemy.takeDamage();
        Reward reward = rewardService.createReward();
        reward.showReward();
        this.rewards.add(reward);
    }

    private void upgradeWeapon() {
        if (this.weapon == null) {
            System.out.println("Вы не выбрали оружие!");
            return;
        }
        System.out.println("Выберите оружие для улучшения:");
        System.out.println("1. Меч");
        System.out.println("2. Волшебная палочка");
        int weaponChoice = scanner.nextInt();

        WeaponFactory weaponFactory;
        switch (weaponChoice) {
            case 1 -> weaponFactory = new SwordFactory();
            case 2 -> weaponFactory = new WandFactory();
            default -> {
                System.out.println("Неверный выбор! По умолчанию выбирается: Меч.");
                weaponFactory = new SwordFactory();
            }
        }

        weapon = weaponFactory.createWeapon();
        System.out.println("Вы улучшили " + weapon.getWeaponType());
    }

    private void upgradeHero() {
        if (hero != null) {
            System.out.println("Обновляем вашего героя: " + hero.getHeroType());
            hero.levelUp();
        } else {
            System.out.println("Прежде выберите героя.");
        }
    }

    private static class WarriorFactory implements CharacterFactory {
        @Override
        public Hero createHero() {
            return new Warrior();
        }
    }

    private static class MageFactory implements CharacterFactory {
        @Override
        public Hero createHero() {
            return new Mage();
        }
    }

    private static class GoblinFactory implements EnemyFactory {
        @Override
        public Enemy createEnemy() {
            return new Goblin();
        }
    }

    private static class SkeletonFactory implements EnemyFactory {
        @Override
        public Enemy createEnemy() {
            return new Skeleton();
        }
    }

    private static class SwordFactory implements WeaponFactory {
        @Override
        public Weapon createWeapon() {
            return new Sword();
        }
    }

    private static class WandFactory implements WeaponFactory {
        @Override
        public Weapon createWeapon() {
            return new Wand();
        }
    }
}