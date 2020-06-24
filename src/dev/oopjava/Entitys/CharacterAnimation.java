package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.image.BufferedImage;

public class CharacterAnimation {

    private int timer, i;
    private long current, tick;
    private BufferedImage[] tiles;

    public CharacterAnimation(int timer, double velX) {
        this.timer = timer;
        //this.tiles = tiles;

        tiles = Assets.priest1v1;

        /*if(velX > 0) {
            tiles = Assets.priest1v1;
        }
        if(velX < 0) {
            tiles = Assets.priest1v1left;
        }*/

        i = 0;
        tick = 0;
        current = System.currentTimeMillis();
    }

    public void tick(double velX,double velY){

        tick += System.currentTimeMillis() - current;
        current = System.currentTimeMillis();

        if(tick > timer && velX != 0 || velY != 0) {
            i++;
            tick = 0;
            if(i >= tiles.length) {
                i = 0;
            }
        }
    }

    public BufferedImage getTiles() {

        return tiles[i];
    }
}
