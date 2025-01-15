package org.example;

import java.util.Random;

public class Player extends Entity {
    private Random random = new Random();

    public String name;
    public PlayerClasses playerClass;
    public Hero playerHero;

    public Player(String name) {
        this.name = name;
        this.playerClass = GetRandomPlayerClasses();
        if (playerClass != null) {
            this.playerHero = GetPlayerClass();
        }
    }

    private PlayerClasses GetRandomPlayerClasses() {
        int randomValue = random.nextInt(0, 2);
        if (randomValue == 0) {
            return PlayerClasses.MAGE;
        } else if (randomValue == 1) {
            return PlayerClasses.WARRIOR;
        } else {
            return null;
        }
    }


    public Hero GetPlayerClass() {
        switch (playerClass) {
            case PlayerClasses.MAGE -> {
                return new Mage( "mage", 50.0, Stafflaboratory.energystaff);
            }
            case PlayerClasses.WARRIOR -> {
                return new Warrior("warrior", 100.0, Stafflaboratory.Basesword);
            }
            default -> {
                return null;
            }
        }
    }

    public void Attack(Enemy enemy) {
    double damage = playerHero.GetDamage();
    enemy.health -= damage;
    System.out.println(playerHero.heroName + " attack" + damage + " damage" + enemy.name);
    }
}
