package dev.oopjava.Entitys;

import java.awt.*;

public class Player extends ObjectSettings{

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void Update() {
        x += velX;
        y += velY;

        if (handler.isUp()) velY = -30;
        else if (!handler.isDown()) velY = 0;

        if (handler.isDown()) velY = 30;
        else if (!handler.isUp()) velY = 0;

        if (handler.isLeft()) velX = -30;
        else if (!handler.isRight()) velX = 0;

        if (handler.isRight()) velX = 30;
        else if (!handler.isLeft()) velX = 0;
    }

    @Override
    public void Render(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(x, y, 25, 25);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
