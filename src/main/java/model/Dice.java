package model;

import java.util.Random;

public class Dice {
    private int max_no;
    private Random random;

    public Dice() {
        this.max_no = 6;
        random = new Random();
    }

    public int diceRoll() {
        return random.nextInt(max_no) + 1;
    }
}

