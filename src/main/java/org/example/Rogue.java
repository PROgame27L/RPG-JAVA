package org.example;

public class Rogue extends Enemy {
  public Rogue(String name, double health, Weapon weapon) {
      super(name, health, weapon);
    }
    @Override
    public void Attack(Player player) {

        if (player.playerHero instanceof Mage){
            Mage mage = (Mage) player.playerHero;

            System.out.println("Rogue attack MAGE");
            System.out.println("health in MAGE before function Attack =" + mage.health);
            mage.health -= weapon.GetDamage(weapon.damage, weapon.critdamage, weapon.critChance);
            System.out.println("health in MAGE after function Attack =" + mage.health);
        }
        else if(player.playerHero instanceof Warrior){
            Warrior  warrior = (Warrior) player.playerHero;

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
