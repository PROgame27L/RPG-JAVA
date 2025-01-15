package org.example;

public class Rogue extends Enemy {
  public Rogue(String name, double health, Weapon weapon) {
      super(name, health, weapon);
    }
    @Override
    public void Attack(Player player) {

        Mage mage = null;
        Warrior warrior = null;

        if (player.playerHero instanceof Mage) {
            mage = (Mage) player.playerHero;
        }
        else if (player.playerHero instanceof Warrior) {
            warrior = (Warrior) player.playerHero;
        }
        if (mage != null){
            System.out.println("Rogue attack MAGE");
            System.out.println("health in MAGE before function Attack =" + mage.health);
            mage.health -= weapon.GetDamage(weapon.damage, weapon.critdamage, weapon.critChance);
            System.out.println("health in MAGE after function Attack =" + mage.health);
        }
        else if(warrior != null){
            System.out.println("Rogue attack Warrior");
            System.out.println("health in Warrior before function Attack =" + warrior.health);
            warrior.health -= weapon.GetDamage(weapon.damage, weapon.critdamage, weapon.critChance);
            System.out.println("health in Warrior after function Attack =" + warrior.health);
        }
    }

    @Override
    public void EnemyInfo() {
      super.EnemyInfo();
    }
}
