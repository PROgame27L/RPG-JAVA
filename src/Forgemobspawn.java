package org.example;

import java.util.Random;

public class Forgemobspawn extends Entity {
    public Enemy[] GenerateEnemies(int count) {
        Enemy[] enemies = new Enemy[count];

        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = CreateEnemy();
        }
        return enemies;
    }

    private Enemy CreateEnemy() {
        Random random = new Random();
        int randomValue = random.nextInt(0, 2);
        if (randomValue == 0) {
            return new Rogue("rogue", 30, Stafflaboratory.GetRandomWearon());
        } else if (randomValue == 1) {
            return new Troll("troll", 70, Stafflaboratory.GetRandomWearon());
        } else {
            return null;
        }
    }
}

