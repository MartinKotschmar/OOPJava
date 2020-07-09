package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Skeleton {

    private CharacterAnimation animation;
    private static BufferedImage[] character;
    public int ID;
    private int tick;

    Handler handler;
    int width, height, scale;
    int x, y;
    double speed;
    ID id;

    public Skeleton(int x, int y, double speed,int scale, ID id, Handler handler){
        this.x = x;
        this.y = y;
        this.speed =speed;
        this.id = id;
        this.handler = handler;
        this.scale = scale;
        tick = 150;
        width = 16;
        height = 16;

        character = Assets.skeleton2v1;
        animation = new CharacterAnimation(tick, speed, character);

    }

    public void Update() {

    }

    public void Render(Graphics g, long timer) {

        Graphics2D g2 = (Graphics2D) g;
        g2.scale(scale,scale);
        g.drawImage(animation.getTiles(),x,y, null);

    }

    public void MoveRight() {
        x += speed;
    }
    public void MoveLeft() {
        x += -speed;
    }

    public Rectangle getBounds() {
        return null;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }
}

