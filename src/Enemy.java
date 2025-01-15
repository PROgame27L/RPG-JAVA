public abstract class Enemy extends Entity {
    protected String name;
    protected double health;
    protected Weapon weapon;

    public Enemy(String name, double health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public abstract void Attack(Player player);

    public void EnemyInfo() {
        System.out.println(
                "Враг : " + name +
                        "\nЗдоровье : " + health + " 🩸" +
                        "\nЕго оружие 🦹 : " + (weapon != null ? weapon.name : "Нет оружия")
        );
    }
}