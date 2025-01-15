package org.example;

import javax.xml.namespace.QName;
import java.util.Random;

public class Weapon extends Entity {
    public String name;
    public double damage;
    public double critdamage;
    public double critChance;

    public Weapon(String name, double damage, double critdamage, double critChance) {
        this.name = name;
        this.damage = damage;
        this.critdamage = critdamage;
        this.critChance = critChance;
    }


    public double GetDamage(double damage, double critdamage, double critChance) {
        Random random = new Random();
        double randomValue = random.nextDouble(1);

        if (critChance >= randomValue) {
            return damage * critdamage;
        }
        return damage;
    }

    public void weaponinfo(String name, double damage, double critChance, double critdamage) {
        System.out.println("wearon: " + name
                + "\ndamage:" + damage
                + "\ncritchance:" + critChance * 100 + "%"
                + "\ncritmultipl:" + critdamage
        );
    }
}
