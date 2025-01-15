import java.util.Random;
import java.util.Scanner;

public class GameManager extends Entity {
    private int countRounds = 0;
    private boolean isPlaying = true;
    private SpawnSystem spawnSystem = new SpawnSystem();
    private Player player;

    public void StartGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя вашего персонажа: ");
        String playerName = scanner.nextLine();
        player = CreatePlayer(playerName);

        while (isPlaying) {
            countRounds++;
            System.out.println("Раунд " + countRounds);
            Enemy[] enemiesThisRound = spawnSystem.GenerateEnemies(10);
            System.out.println("Сгенерировано: " + enemiesThisRound.length + " врагов");

            for (Enemy enemy : enemiesThisRound) {
                Fight(player, enemy);
                if (player.playerHero.health <= 0) {
                    System.out.println("Вы погибли! Игра окончена.");
                    isPlaying = false;
                    break;
                }
            }

            if (isPlaying) {
                PlayerExit();
            }
        }
        EndGame();
    }

    public Player CreatePlayer(String name) {
        return new Player(name);
    }

    private void EndGame() {
        System.out.println("Вы прошли " + countRounds + " волн. Спасибо за игру! 👋");
    }

    private void Fight(Player player, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Вы начали бой с " + enemy.name);

        while (player.playerHero.health > 0 && enemy.health > 0) {
            System.out.println("Выберите действие:\n1 - Атаковать врага\n2 - Сбежать");
            int action = scanner.nextInt();

            if (action == 1) {
                player.Attack(enemy);
                if (enemy.health > 0) {
                    enemy.Attack(player);
                }
            } else if (action == 2) {
                System.out.println("Вы пытаетесь сбежать...");
                if (random.nextDouble() < 0.25) {
                    System.out.println("Враг поймал вас!");
                    enemy.Attack(player);
                    if (player.playerHero.health <= 0) {
                        System.out.println("Вы погибли! Игра окончена.");
                        return;
                    }
                } else {
                    System.out.println("Вы успешно сбежали от " + enemy.name + "!");
                    return;
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, выберите 1 или 2.");
            }


            int healAmount = random.nextInt(10,25);
            player.playerHero.health += healAmount;


            System.out.println("Вы восстановили " + healAmount + " здоровья.");
            System.out.println("Здоровье игрока: " + player.playerHero.health);
            System.out.println("Здоровье врага: " + enemy.health);
        }

        if (enemy.health <= 0) {
            System.out.println("Вы победили " + enemy.name + "!");

            if (enemy.weapon != null) {
                Weapon droppedWeapon = enemy.weapon;
                System.out.println("Вы подобрали оружие: " + droppedWeapon.name);
            } else {
                System.out.println("У врага не было оружия.");
            }
        }
    }



    private void PlayerExit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите:\n1 - Продолжить игру 🎮\n2 - Выйти из игры 🚪");
        int playerChoice = scanner.nextInt();

        if (playerChoice == 1) {
            System.out.println("Продолжаем игру! 🕹️");
        } else if (playerChoice == 2) {
            isPlaying = false;
        } else {
            System.out.println("Некорректный ввод. Продолжаем игру! 🕹️");
        }
    }
}
