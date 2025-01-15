package org.example;

public abstract class Enemy extends Entity {
    public String name;
    public double health;
    public Weapon weapon;

    public Enemy(String name, double health, Weapon wearon) {
        this.name = name;
        this.health = health;
        this.weapon = wearon;
    }

    public abstract void Attack(Player player);

    public void EnemyInfo() {
        System.out.println(
                "enemy: " + name +
                "\nhealth:" + health +
                "\nhis weapon: " + (weapon != null ? weapon.name: "no weapon")
        );
    }
}

