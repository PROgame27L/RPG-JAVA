import java.util.Random;

public class GameWeapons {
    public static Sword WoodSword = new Sword("Деревянный меч 🪵", 13, 1.4, 0.15);
    public static Sword FireSword = new Sword("Огненный меч 🔥", 34, 1.4, 0.35);
    public static Staff FireStaff = new Staff("Огненный посох 🔥", 50, 1.23, 0.15);
    public static Staff EarthStaff = new Staff("Посох сил земли 🌍", 22, 1.25, 0.35);
    public static Staff WaterStaff = new Staff("Посох сил воды 💧", 16, 1.4, 0.35);
    public static Bow RoseBow = new Bow("Лук из роз 🌹", 11, 2.3, 0.5);
    public static Club BigClub = new Club("Двуручная дубина 🪵🪓", 30, 2, 0.1);


    private static Weapon[] GAME_WEAPONS = { WoodSword, FireSword , FireStaff, EarthStaff, RoseBow, BigClub };

    public static Weapon GetRandomWeapon() {
        Random random = new Random();
        int randomNumber = random.nextInt(0, GAME_WEAPONS.length - 1);

        return GAME_WEAPONS[randomNumber];
    }

}
