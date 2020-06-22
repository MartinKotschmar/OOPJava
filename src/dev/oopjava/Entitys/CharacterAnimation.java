package dev.oopjava.Entitys;

import java.awt.image.BufferedImage;

public class CharacterAnimation {

    private int timer, i;
    private long current, tick;
    private BufferedImage[] tiles;

    public CharacterAnimation(int timer, BufferedImage[] tiles) {
        this.timer = timer;
        this.tiles = tiles;
        i = 0;
        tick = 0;
        current = System.currentTimeMillis();
    }

    public void tick(){

        tick += System.currentTimeMillis() - current;
        current = System.currentTimeMillis();

        if(tick > timer) {
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

    /*public void setTiles(BufferedImage tiles) {
        this.tiles = tiles[i];
    }   */


}
