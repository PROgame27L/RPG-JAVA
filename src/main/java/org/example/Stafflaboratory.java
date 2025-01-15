package org.example;

import java.util.Random;

public class Stafflaboratory {
    public static Sword Basesword = new Sword("ancient sword from astora", 15, 2, 0.35);
    public static Staff energystaff = new Staff("energy staff from astora", 30, 1.5, 0.4);
    public static Staff lightningstaff = new Staff("lightning staff from mithrill", 40, 3.5, 0.001);
    public static Staff bloodstaff = new Staff("blood staff from mitochor", 20, 1.1, 0.3);
    public static Club clubstep = new Club("clubstep from mitochor", 50, 0.1, 0.1);
    public static Bow longbow = new Bow("ancient longbow from mithfill", 35, 1.1, 0.5);

    public static Weapon[] GAME_WEAPONS = {Basesword, energystaff, lightningstaff, bloodstaff, clubstep, longbow};

    public static Weapon GetRandomWearon() {
        Random random = new Random();
        int randomNumber = random.nextInt(0, GAME_WEAPONS.length - 1);

        return GAME_WEAPONS[randomNumber];
    }
}


