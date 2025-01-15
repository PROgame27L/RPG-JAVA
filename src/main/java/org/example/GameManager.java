package org.example;

import java.util.Random;
import java.util.Scanner;

public class GameManager extends Entity {
    private int countRounds = 1;
    private boolean isPlaying = true;
    private Forgemobspawn forgemobspawn = new Forgemobspawn();
    private Player player;

    public void StartGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter name");
        String playerName = scanner.nextLine();
        player = CreatePlayer(playerName);
        while (isPlaying) {
            Enemy[] EnemiesThisround = forgemobspawn.GenerateEnemies(10);
            System.out.println("generated : " + EnemiesThisround.length + "enemy");

            for (Enemy enemy : EnemiesThisround) {
                Fight(player, enemy);
                if (player.playerHero.health <= 0) {
                    System.out.println("you died! game ended.");
                    isPlaying = false;
                    break;
                }
            }
            if (isPlaying) {
                isPlayingExit();
            }
        }
        System.out.println("thanks for playing betatest");
    }

    public Player CreatePlayer(String name) {
        return new Player(name);
    }

    public void GetRoundMessage() {

    }

    private void Fight(Player player, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("you start fight with " + enemy.name);

        while (player.playerHero.health > 0 && enemy.health > 0) {
            System.out.println("enter action:\n1 - attack enemy\n2 - run away lox");
            int action = scanner.nextInt();

            if (action == 1) {
                player.Attack(enemy);
                if (enemy.health > 0) {
                    enemy.Attack(player);
                }
            } else if (action == 2) {
                System.out.println("you trying run...");
                if (random.nextDouble() < 0.25) {
                    System.out.println("enemy catch you:0!");
                    enemy.Attack(player);
                    if (player.playerHero.health <= 0) {
                        System.out.println("you died! game ended.");
                        return;
                    }
                } else {
                    System.out.println("you successfully run " + enemy.name + "!");
                    return;
                }
            } else {
                System.out.println("false enter. please, enter 1 or 2.");
            }

            System.out.println("health player: " + player.playerHero.health);
            System.out.println("health enemy: " + enemy.health);
        }
        int healAmount = random.nextInt(10, 25);
        player.playerHero.health += healAmount;


        System.out.println("you regenerated " + healAmount + "health.");
        System.out.println("health player" + player.playerHero.health);
        System.out.println("health enemy" + enemy.health);
        if (enemy.health <= 0) {
            System.out.println("you won " + enemy.name + "!");
        }
    }

    private void isPlayingExit() {
        boolean isExit;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter:\n1 - continue game \2 - out of the game");
        String out = scanner.nextLine();
        if (out == "out") {
            isExit = true;
            System.exit(0);
        } else if (out == "notleave") {
            isExit = false;
            System.out.println("continue game");
        } else {
            isExit = true;
            System.exit(0);

        }
    }
}
