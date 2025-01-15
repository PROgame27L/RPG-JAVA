import java.util.*;

public class SpawnSystem extends Entity {


    public Enemy[] GenerateEnemies(int count) {
        Enemy[] enemies = new Enemy[count];

        for(int i = 0; i < enemies.length; i++){
            enemies[i] = CreateEnemy();
            System.out.println("Создан враг №" + i + " " + "Враг : " + enemies[i]);

            if (enemies[i] instanceof Troll) {
                Troll troll = (Troll) enemies[i];
                troll.EnemyInfo();
            } else if (enemies[i] instanceof Rogue) {
                Rogue rogue = (Rogue) enemies[i];
                rogue.EnemyInfo();
            }
        }
        return enemies;
    }

    public Enemy CreateEnemy(){
        Random random = new Random();
        int enemyChoice = random.nextInt(0,2);

        if (enemyChoice == 0) {
            return new Rogue("Разбойник", 25, GameWeapons.GetRandomWeapon());
        }
        else if (enemyChoice == 1){
            return new Troll("Тролль", 40, GameWeapons.GetRandomWeapon());
        }
        return new Rogue("Разбойник", 25, GameWeapons.GetRandomWeapon());
    }


}
