package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import dev.oopjava.Display.*;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Backgroundaccessoires{
    private int x, y , width, height, a, a2;
    Graphics g;
    BufferedImage[] randomitems;
    BufferedImage[] flames;
    BufferedImage[] boxes;

    public Backgroundaccessoires(int x, int y, int a, int a2, Graphics g) {
        this.x =x;
        this.y =y;
        this.a = a;
        this.a2 = a2;
        this.g = g;

        width = 16;
        height = 16;

        Graphics2D g2 = (Graphics2D) g;

        randomitems = Assets.randomitems;
        flames = Assets.flames;
        boxes = Assets.boxes;
    }

    public void FirstLevel() {
        g.drawImage(Assets.stonesmedium, width + ((1920 - x)/10) + a2/5 + 16, height + a + 80, null);
        g.drawImage(Assets.stonessmall, width + ((1920 - x)/10) + a2/5 + 32, height + a + 80, null);
        g.drawImage(Assets.burningtorch, width + ((1920 - x)/10) + a2/5, height + a - 16, null);
        g.drawImage(Assets.burningtorch, width + ((1920 - x)/10) + a2/5 + 48, height + a - 16, null);
    }

    public void SecondLevel() {
        g.drawImage(Assets.skeleton, width + ((1920 - x)/10) + a2/5 + 192, height + a + 160, null);
        g.drawImage(Assets.skeleton, width + ((1920 - x)/10) + a2/5 + 208, height + a + 160, null);
        g.drawImage(Assets.skeleton, width + ((1920 - x)/10) + a2/5 + 224, height + a + 160, null);
        g.drawImage(Assets.randomitems[0], width + ((1920 - x)/10) + a2/5 + 224, height + a + 144, null);
        g.drawImage(Assets.skeleton, width + ((1920 - x)/10) + a2/5 + 240, height + a + 112, null);
        g.drawImage(Assets.skeleton, width + ((1920 - x)/10) + a2/5 + 240, height + a + 128, null);
        g.drawImage(Assets.skeleton, width + ((1920 - x)/10) + a2/5 + 240, height + a + 144, null);
        g.drawImage(Assets.skeleton, width + ((1920 - x)/10) + a2/5 + 240, height + a + 160, null);
        g.drawImage(Assets.randomitems[0], width + ((1920 - x)/10) + a2/5 + 64, height + a + 128, null);
        g.drawImage(Assets.stonesmedium, width + ((1920 - x)/10) + a2/5 + 96, height + a + 48, null);
        g.drawImage(Assets.stonesmedium, width + ((1920 - x)/10) + a2/5 + 96, height + a + 64, null);
        g.drawImage(Assets.stonesmedium, width + ((1920 - x)/10) + a2/5 + 80, height + a + 64, null);
        g.drawImage(Assets.burningconsolemedium, width + ((1920 - x)/10) + a2/5, height + a + 32, null);
        g.drawImage(Assets.burningconsolemedium, width + ((1920 - x)/10) + a2/5, height + a + 128, null);
        g.drawImage(Assets.burningtorch, width + ((1920 - x)/10) + a2/5 + 64, height + a - 16, null);
        g.drawImage(Assets.burningtorch, width + ((1920 - x)/10) + a2/5 + 176, height + a - 16, null);
    }

    public void ThirdLevel() {
        g.drawImage(Assets.boxes[4], width + ((1920 - x)/10) + a2/5 + 240, height + a, null);
        g.drawImage(Assets.trashmedium, width + ((1920 - x)/10) + a2/5 + 32, height + a + 112, null);
        g.drawImage(Assets.randomitems[0], width + ((1920 - x)/10) + a2/5 + 64, height + a + 128, null);
        g.drawImage(Assets.stonesmedium, width + ((1920 - x)/10) + a2/5 + 96, height + a + 48, null);
        g.drawImage(Assets.stonesmedium, width + ((1920 - x)/10) + a2/5 + 96, height + a + 64, null);
        g.drawImage(Assets.stonesmedium, width + ((1920 - x)/10) + a2/5 + 80, height + a + 64, null);
        g.drawImage(Assets.burningconsolemedium, width + ((1920 - x)/10) + a2/5 + 240, height + a + 32, null);
        g.drawImage(Assets.burningconsolemedium, width + ((1920 - x)/10) + a2/5 + 240, height + a + 128, null);
        g.drawImage(Assets.burningtorch, width + ((1920 - x)/10) + a2/5, height + a + 160, null);
        g.drawImage(Assets.burningtorch, width + ((1920 - x)/10) + a2/5+16, height + a + 160, null);
    }

    public void FourthLevel() {
        g.drawImage(Assets.burningtorch, width + ((1920 - x)/10) + a2/5, height + a - 16, null);
        g.drawImage(Assets.burningtorch, width + ((1920 - x)/10) + a2/5 + 48, height + a - 16, null);
        g.drawImage(Assets.randomitems[0], width + ((1920 - x)/10) + a2/5, height + a + 16, null);
        g.drawImage(Assets.trashsmall, width + ((1920 - x)/10) + a2/5 + 32, height + a + 32, null);
    }


}

