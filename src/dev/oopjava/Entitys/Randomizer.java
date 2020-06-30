package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.image.BufferedImage;
import java.util.Random;


public class Randomizer {
    private Random r;
    private int[] randomNumbers;
    private int i;


    public Randomizer() {
        r = new Random();
    }

    public void Generator(){
        //Arrays erstellen, und rausziehen
        for(i = 0; i < 5; i++) {
            randomNumbers[i] = r.nextInt(9-0+1);
        }
    }
}
