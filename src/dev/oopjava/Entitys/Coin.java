package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends ObjectSettings  {

    private static BufferedImage[] character;

    public Coin(int x, int y, int speed, ID id, Handler handler) {
        super(x, y, speed, id);
        this.handler = handler;

        character = Assets.Coin;
        animation = new CharacterAnimation(tick, velX, character);
    }


    @Override
    public void Update() {
        animation.tick(0.5,0.5);
    }

    @Override
    public void Render(Graphics g) {
        g.drawImage(animation.getTiles(),x,y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x+7, y+7,2, 3);
    }

    @Override
    protected void die() {

    }
}
