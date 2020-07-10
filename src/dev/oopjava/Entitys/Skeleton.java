package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Skeleton extends ObjectSettings {

    private static BufferedImage[] character;
    //Bewegungskonstanten
    private boolean horizontal = true;
    private int maxDistance = 50;
    private int movedDistance = 0;
    private boolean reverted = false;


    public Skeleton(int x, int y, int speed, int scale, ID id, Handler handler) {
        super(x, y, speed, id);
        this.handler = handler;
        this.scale = scale;
        tick = 150;
        width = 16;
        height = 16;
        health = 50;
        attackDamage = 0.5;

        character = Assets.skeleton2v1;
        animation = new CharacterAnimation(tick, speed, character);
    }

    public void Update() {
        if (horizontal) {
            if (reverted) {
                if (movedDistance > 0) {
                    x--;
                    movedDistance--;
                    velX = 1;
                } else {
                    reverted = false;
                }
            } else {
                if (movedDistance < maxDistance) {
                    x++;
                    movedDistance++;
                    velX = -1;
                } else {
                    reverted = true;
                }
            }
        } else {
            if (reverted) {
                if (movedDistance > 0) {
                    y--;
                    movedDistance--;
                    velY = 1;
                } else {
                    reverted = false;
                }
            } else {
                if (movedDistance < maxDistance) {
                    y++;
                    movedDistance++;
                    velY = -1;
                } else {
                    reverted = true;
                }
            }
        }
        animation.tick(velX, velY);
    }

    public void setMove(boolean horizontal, int distance) {
        this.horizontal = horizontal;
        this.maxDistance = distance;
    }

    public void Render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(animation.getTiles(), x, y, null);

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    @Override
    protected void die() {
        handler.removeObject(this);
        handler.removeCollidableObject(this);
        Flask flask = new Flask(x, y, 0, null, handler);
        handler.addObject(flask);
        handler.addCollidableObject(flask);
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {
        return this.id;
    }
}

