package org.example;

public class Mage extends Hero {
    public Weapon weapon;

    public Mage(String heroName, double health, Weapon weapon) {
         super(heroName, health);
         this.weapon = weapon;
    }
}
