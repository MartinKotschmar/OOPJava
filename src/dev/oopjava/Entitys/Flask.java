package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Flask extends ObjectSettings {

    private static BufferedImage[] character;

    public Flask(int x, int y, int speed, ID id, Handler handler) {
        super(x, y, speed, id);
        this.handler = handler;
        this.health = 20;

        character = Assets.flasks;
        animation = new CharacterAnimation(tick, velX, character);
    }

    @Override
    public void Update() {

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
        handler.removeObject(this);
        handler.removeCollidableObject(this);
    }
}
