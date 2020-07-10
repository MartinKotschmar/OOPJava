package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class ThirdLevelBackgroundaccessoires {
    private int x, y, width, height, a, a3;
    Graphics g;
    BufferedImage[] randomitems;
    BufferedImage[] flames;
    BufferedImage[] boxes;

    public ThirdLevelBackgroundaccessoires(int x, int y, int a, int a3, Graphics g) {
        this.x = x;
        this.y = y;
        this.a = a;
        this.a3 = a3;
        this.g = g;

        width = 16;
        height = 16;

        Graphics2D g2 = (Graphics2D) g;

        randomitems = Assets.randomitems;
        flames = Assets.flames;
        boxes = Assets.boxes;
    }

    public void FirstLevel() {
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 2 * width), height + a + 64, null);
        g.drawImage(Assets.stonessmall, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 1 * width), height + a + 64, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 3 * width), height + a - 16, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 0 * width), height + a - 16, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 0 * width), height + a + 48, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 0 * width), height + a + 64, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 0 * width), height + a + 176, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 3 * width), height + a + 176, null);

    }

    public void SecondLevel() {
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 0 * width), height + a + 16, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 0 * width), height + a + 0, null);
        g.drawImage(Assets.skeleton, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 1 * width), height + a + 0, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 0 * width), height + a + 32, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 2 * width), height + a + 48, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 2 * width), height + a + 64, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 3 * width), height + a + 64, null);
    }

    public void ThirdLevel() {
        g.drawImage(Assets.trashmedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 4 * width), height + a + 96, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 3 * width), height + a + 112, null);
        g.drawImage(Assets.trashmedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 4 * width), height + a + 112, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 3 * width), height + a + 128, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 6 * width), height + a - 16, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 3 * width), height + a - 16, null);
        g.drawImage(Assets.stonesmedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 9 * width), height + a + 48, null);
        g.drawImage(Assets.stonessmall, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 9 * width), height + a + 64, null);
        g.drawImage(Assets.torch, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 8 * width), height + a + 80, null);
        g.drawImage(Assets.stonessmall, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 2 * width), height + a + 48, null);
        g.drawImage(Assets.stonessmall, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 1 * width), height + a + 48, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 1 * width), height + a + 176, null);
        g.drawImage(Assets.burningconsolemedium, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 8 * width), height + a + 176, null);
    }

    public void FourthLevel() {
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 6 * width), height + a - 16, null);
        g.drawImage(Assets.burningtorch, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 3 * width), height + a - 16, null);
        g.drawImage(Assets.randomitems[0], (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 5 * width), height + a + 16, null);
        g.drawImage(Assets.trashsmall, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 5 * width), height + a + 32, null);
    }

    public void FifthLevel() {
        g.drawImage(Assets.walltop, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 0 * width), height + a + 32, null);
        g.drawImage(Assets.walldown, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 0 * width), height + a + 48, null);
        g.drawImage(Assets.walls, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 1 * width), height + a + 48, null);
        g.drawImage(Assets.walls, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 2 * width), height + a + 48, null);
        g.drawImage(Assets.walls, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 3 * width), height + a + 48, null);
        g.drawImage(Assets.walls, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) - 4 * width), height + a + 48, null);

        g.drawImage(Assets.walltop, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 9 * width), height + a + 32, null);
        g.drawImage(Assets.walldown, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 9 * width), height + a + 48, null);
        g.drawImage(Assets.walls, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 10 * width), height + a + 48, null);
        g.drawImage(Assets.walls, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 11 * width), height + a + 48, null);
        g.drawImage(Assets.walls, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 12 * width), height + a + 48, null);
        g.drawImage(Assets.walls, (width + ((1920 - x) / 10) + a3 / 5 + (int) Math.ceil(x / 10) + 13 * width), height + a + 48, null);
    }
}