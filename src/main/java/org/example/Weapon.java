package org.example;

import javax.xml.namespace.QName;
import java.util.Random;

public class Weapon extends Entity {
    public double name;
    public double damage;
    public double critdamage;
    public double critChance;


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
