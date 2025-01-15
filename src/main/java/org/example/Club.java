package org.example;

public class Club extends Weapon{
    public String name;
    public double damage;
    public double critdamage;
    public double critChance;

    public Club(String name, double damage, double critdamage, double critChance) {
        this.name = name;
        this.damage = damage;
        this.critChance = critChance;
        this.critdamage = critdamage;
    }

    public void WearonInfo() {
        super.weaponinfo(name, damage, critChance, critdamage);

    }
    public double GetDamage() {
        return super.GetDamage(damage, critdamage, critChance);
    }
}

