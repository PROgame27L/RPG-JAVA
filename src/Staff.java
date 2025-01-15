public class Staff extends Weapon {
    public String name;
    public double damage;
    public double criticalMultiplier;
    public double criticalChance;

    public Staff(String name, double damage, double criticalMultiplier, double criticalChance) {
        super(name, damage, criticalMultiplier, criticalChance);
    }

    public void WeaponInfo() {
        super.WeaponInfo(name, damage, criticalChance, criticalMultiplier);
    }

    public double GetDamage() {
        return super.GetDamage(damage, criticalMultiplier, criticalChance);
    }
}