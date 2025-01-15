public class Troll extends Enemy {
    public Troll(String name, double health, Weapon weapon) {
        super(name, health, weapon);
    }

    @Override
    public void Attack(Player player) {
        if (player.playerHero instanceof Mage) {
            Mage mage = (Mage) player.playerHero;
            System.out.println("Troll бьёт класс Mage");
            System.out.println("Здоровье врага Внутри Troll до функции Attack = " + mage.health);
            mage.health -= weapon.GetDamage(weapon.damage, weapon.criticalMultiplier, weapon.criticalChance);
            System.out.println("Здоровье врага Внутри Troll после функции Attack = " + mage.health);
        } else if (player.playerHero instanceof Warrior) {
            Warrior warrior = (Warrior) player.playerHero;
            System.out.println("Troll бьёт класс Warrior");
            System.out.println("Здоровье врага Внутри Troll до функции Attack = " + warrior.health);
            warrior.health -= weapon.GetDamage(weapon.damage, weapon.criticalMultiplier, weapon.criticalChance);
            System.out.println("Здоровье врага Внутри Troll после функции Attack = " + warrior.health);
        }
    }

    @Override
    public void EnemyInfo() {
        super.EnemyInfo();
    }
}