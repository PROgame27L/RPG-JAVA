public class Warrior extends Hero {
    public Weapon weapon;

    public Warrior(String heroName, double health, Weapon weapon) {
        super(heroName, health);
        this.weapon = weapon;
    }
}
