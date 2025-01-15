package org.example;

public class Sword extends Weapon{
    public String name;
    public double damage;
    public double critdamage;
    public double critChance;

    public Sword(String name, double damage, double critdamage, double critChance) {
        super(name, damage, critdamage, critChance);
    }

    public void WearonInfo() {
        super.weaponinfo(name, damage, critChance, critdamage);

    }
    public double GetDamage() {
        return super.GetDamage(damage, critdamage, critChance);
    }
}

