import java.util.Random;

public abstract class Weapon extends Entity {
    public String name;
    public double damage;
    public double criticalMultiplier;
    public double criticalChance;

    public Weapon(String name, double damage, double criticalMultiplier, double criticalChance) {
        this.name = name;
        this.damage = damage;
        this.criticalMultiplier = criticalMultiplier;
        this.criticalChance = criticalChance;
    }


    public double GetDamage(double damage, double criticalMultiplier, double criticalChance) {
        Random random = new Random();
        double randomValue = random.nextDouble(1);

        if (criticalChance >= randomValue) {
            return damage * criticalMultiplier;
        }
        return damage;
    }

    public void WeaponInfo(String name, double damage, double criticalChance, double criticalMultiplier) {
        System.out.println(
                "Оружие : " + name
                + "\nНаносит : " + damage + " урона 🩸"
                + "\nКритический шанс 🦹 : " + criticalChance * 100 + " %"
                + "\nКритический множитель : " + criticalMultiplier
        );
    }
}
