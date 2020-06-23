package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;
import dev.oopjava.tileset.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends ObjectSettings{

    private CharacterAnimation animation;
    private Image img;
    private int timer;
    private static BufferedImage[] character;
    public int ID;

    Handler handler;
    String image;
    int width, height, scale;


    public Player(int x, int y, double speed,int scale, ID id, Handler handler){
        super(x, y, speed, id);
        this.handler = handler;
        this.scale = scale;
        timer = 150;
        width = 16;
        height = 16;

        character = Assets.priest1v1;
        animation = new CharacterAnimation(timer, velX);
    }

    public void Update() {
        x += velX;
        y += velY;

        if(x < 0) { x = 0; }
        if(x > 1920/scale - width) { x = 1920/scale - width; }
        if(y < 0) { y = 0; }
        if(y > 1080/scale - width) { y = 1080/scale - width; }

        animation.tick(velX,velY);

        if (handler.isUp()) velY = -speed;
        else if (!handler.isDown()) velY = 0;

        if (handler.isDown()) velY = speed;
        else if (!handler.isUp()) velY = 0;

        if (handler.isLeft()) {
            velX = -speed;
           // animation = new CharacterAnimation(timer, Assets.priest1v1left);
        }
        else if (!handler.isRight()) velX = 0;
        if (handler.isRight()) {
            velX = speed;
           // animation = new CharacterAnimation(timer, Assets.priest1v1);
        }
        else if (!handler.isLeft()) velX = 0;
    }

    public void Render(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.scale(scale,scale);

        g.drawImage(animation.getTiles(),x,y, null);
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
