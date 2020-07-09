package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Skeleton extends ObjectSettings{

    private static BufferedImage[] character;

    public Skeleton(int x, int y, int speed,int scale, ID id, Handler handler){
        super(x, y, speed, id);
        this.handler = handler;
        this.scale = scale;
        tick = 150;
        width = 16;
        height = 16;

        //TODO Change
        character = Assets.priest1v1;
        animation = new CharacterAnimation(tick, speed, character);

    }

    public void Update() {

    }

    public void Render(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        //g2.scale(scale,scale);
        g.drawImage(animation.getTiles(),x,y, null);
        g.setColor(Color.red);
        ((Graphics2D) g).draw(getBounds());
    }

    public void MoveRight() {
        x += speed;
    }
    public void MoveLeft() {
        x += -speed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {
        return this.id;
    }
}

