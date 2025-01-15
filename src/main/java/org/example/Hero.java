package org.example;

public class Hero extends Entity {
    public String heroName;
    public double health;

    public Hero(String heroName, double health) {
        this.heroName = heroName;
        this.health = health;
    }

    public double GetDamage() {
        if (this instanceof Mage) {
            Mage mage = (Mage) this;
            return mage.weapon.GetDamage(mage.weapon.damage, mage.weapon.critdamage, mage.weapon.critChance);
        } else if (this instanceof Warrior) {
            Warrior warrior = (Warrior) this;
            return warrior.weapon.GetDamage(warrior.weapon.damage, warrior.weapon.critdamage, warrior.weapon.critChance);
        }
        return 0;
    }
}
