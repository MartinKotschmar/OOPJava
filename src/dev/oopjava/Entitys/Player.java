package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;
import dev.oopjava.tileset.ImageLoader;

import java.awt.*;

public class Player extends ObjectSettings{

    Handler handler;

    public Player(int x, int y, double speed, ID id, Handler handler) {
        super(x, y, speed, id);
        this.handler = handler;

    }

    public void Update() {
        x += velX;
        y += velY;

        if (handler.isUp()) velY = -speed;
        else if (!handler.isDown()) velY = 0;

        if (handler.isDown()) velY = speed;
        else if (!handler.isUp()) velY = 0;

        if (handler.isLeft()) velX = -speed;
        else if (!handler.isRight()) velX = 0;

        if (handler.isRight()) velX = speed;
        else if (!handler.isLeft()) velX = 0;
    }

    public void Render(Graphics g) {

        int x2 = x * 8;
        int y2 = y * 8;

        Graphics2D g2 = (Graphics2D) g;
        g2.scale(5,5);
        g.drawImage(Assets.oldieknife,x2,y2, null);


    }

    public Rectangle getBounds() {
        return null;
    }
}
