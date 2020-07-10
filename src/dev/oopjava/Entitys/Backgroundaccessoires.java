package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Backgroundaccessoires {
    private int x, y, width, height, a;
    Graphics g;
    BufferedImage[] randomitems;
    BufferedImage[] flames;
    BufferedImage[] boxes;

    public Backgroundaccessoires(int x, int y, int a, Graphics g) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.g = g;

        width = 16;
        height = 16;

        randomitems = Assets.randomitems;
        flames = Assets.flames;
        boxes = Assets.boxes;
    }

    public void FirstLevel() {
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 2 * width), height + a + 64, null);
        g.drawImage(Assets.stonessmall, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 1 * width), height + a + 64, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 3 * width), height + a - 16, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 0 * width), height + a - 16, null);
    }

    public void SecondLevel() {
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 3 * width), height + a + 176, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 4 * width), height + a + 176, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 5 * width), height + a + 176, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 4 * width), height + a + 144, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 6 * width), height + a + 128, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 6 * width), height + a + 144, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 6 * width), height + a + 160, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 6 * width), height + a + 176, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 4 * width), height + a + 128, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 1 * width), height + a + 48, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 0 * width), height + a + 64, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 1 * width), height + a + 64, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 9 * width), height + a + 32, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 9 * width), height + a + 128, null);
    }

    public void ThirdLevel() {
        g.drawImage(Assets.blueflame, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 1 * width), height + a + 16, null);
        g.drawImage(Assets.trashmedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 5 * width), height + a + 112, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 4 * width), height + a + 128, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 0 * width), height + a - 16, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 3 * width), height + a - 16, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 3 * width), height + a + 48, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 3 * width), height + a + 64, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 2 * width), height + a + 64, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 6 * width), height + a + 32, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 6 * width), height + a + 128, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 6 * width), height + a + 176, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 3 * width), height + a + 176, null);
    }

    public void FourthLevel() {
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 3 * width), height + a - 16, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) + 0 * width), height + a - 16, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 2 * width), height + a + 16, null);
        g.drawImage(Assets.trashsmall, (width + ((1920 - x) / 10) + (int) Math.ceil(x / 10) - 2 * width), height + a + 32, null);
    }
}

