import java.util.Random;

public class Player extends Entity {
    private Random random = new Random();
    public String name;
    public PlayerClasses playerClass;
    public Hero playerHero;

    public Player(String name) {
        this.name = name;
        this.playerClass = GetRandomPlayerClass();
        if (playerClass != null) {
            this.playerHero = GetPlayerHero();
        }
    }

    private PlayerClasses GetRandomPlayerClass() {
        int randomValue = random.nextInt(2);
        return randomValue == 0 ? PlayerClasses.MAGE : PlayerClasses.WARRIOR;
    }

    public Hero GetPlayerHero() {
        switch (playerClass) {
            case MAGE:
                return new Mage("Маг", 50.0, GameWeapons.WaterStaff);
            case WARRIOR:
                return new Warrior("Воин", 100.0, GameWeapons.WoodSword);
            default:
                return null;
        }
    }

    public void Attack(Enemy enemy) {
        double damage = playerHero.GetDamage();
        enemy.health -= damage;
        System.out.println(playerHero.heroName + " наносит " + damage + " урона " + enemy.name);
    }
}
