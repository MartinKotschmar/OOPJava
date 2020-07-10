package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class FirstLevelBackgroundaccessoires {
    private int x, y, width, height, a, a1;
    Graphics g;
    BufferedImage[] randomitems;
    BufferedImage[] flames;
    BufferedImage[] boxes;

    public FirstLevelBackgroundaccessoires(int x, int y, int a, int a1, Graphics g) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.a1 = a1;
        this.g = g;

        width = 16;
        height = 16;

        randomitems = Assets.randomitems;
        flames = Assets.flames;
        boxes = Assets.boxes;
    }

    public void FirstLevel() {
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 2 * width), height + a + 64, null);
        g.drawImage(Assets.stonessmall, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 1 * width), height + a + 64, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 3 * width), height + a - 16, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 0 * width), height + a - 16, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 0 * width), height + a + 48, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 0 * width), height + a + 64, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 0 * width), height + a + 176, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 3 * width), height + a + 176, null);

    }

    public void SecondLevel() {
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 7 * width), height + a + 16, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 7 * width), height + a + 0, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 6 * width), height + a + 0, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) - 5 * width), height + a + 32, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) + 1 * width), height + a + 48, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) + 2 * width), height + a + 64, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) + 3 * width), height + a + 64, null);
    }

    public void ThirdLevel() {
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) + 15 * width), height + a - 16, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) + 18 * width), height + a - 16, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) + 16 * width), height + a + 16, null);
        g.drawImage(Assets.trashsmall, (width + ((1920 - x) / 10) + a1 / 5 + (int) Math.ceil(x / 10) + 16 * width), height + a + 32, null);
    }
}