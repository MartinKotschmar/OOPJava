package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import dev.oopjava.Display.*;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Backgroundaccessoires{
    private int x;
    private int y;
    Graphics g;
    BufferedImage[] randomitems;

    public Backgroundaccessoires(int x, int y, Graphics g) {
        this.x =x;
        this.y =y;
        this.g = g;

        Graphics2D g2 = (Graphics2D) g;

        g.drawImage(Assets.bones, x/5, y/5, null);
        randomitems = Assets.randomitems;
    }
}

