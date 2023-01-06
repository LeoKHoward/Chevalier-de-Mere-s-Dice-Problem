package Relax;

import java.util.Random;

public class Die {

    private static final int DICE_SIDES = 6;

    /**
     * Used to simulate the roll of a 6 sided die
     **/
    public static int throwDie() {
        return new Random().nextInt(DICE_SIDES) + 1;
    }
}
