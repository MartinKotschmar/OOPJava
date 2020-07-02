package dev.oopjava.Entitys;

import java.util.Random;


public class Randomizer {
    private Random r;
    private int[] randomNumbers;
    private int i;


    public Randomizer() {
        r = new Random();
        Generator();
    }



    public void Generator(){

        int[] arr =  new int[5];
        //Arrays erstellen, und rausziehen
        for(i = 0; i < 5; i++) {

            arr[i] = r.nextInt(9-0+1);
        }
        System.out.println(arr[0] + arr[1]);
    }
}
