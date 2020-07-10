package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Boss extends ObjectSettings {

    private static BufferedImage[] character;
    private boolean horizontal = true;
    private int maxDistanceY = 80;
    private int maxDistanceX = 160;
    private int movedDistance = 0;
    private DIRECTIONS direction;

    public Boss(int x, int y, int speed,int scale, ID id, Handler handler) {
        super(x, y, speed, id);
        this.handler = handler;
        this.scale = scale;
        tick = 150;
        width = 16;
        height = 16;
        health = 10;
        attackDamage = 0.7;
        direction = DIRECTIONS.DOWN;

        character = Assets.Boss;
        animation = new CharacterAnimation(tick, speed, character);
    }

    @Override
    public void Update() {
        switch (direction) {
            case RIGHT -> {
                if(movedDistance < maxDistanceX) {
                    x++;
                    movedDistance++;
                } else {
                    movedDistance = 0;
                    direction = DIRECTIONS.UP;
                }
            }
            case LEFT -> {
                if(movedDistance < maxDistanceX) {
                    x--;
                    movedDistance++;
                } else {
                    movedDistance = 0;
                    direction = DIRECTIONS.DOWN;
                }
            }
            case DOWN -> {
                if(movedDistance < maxDistanceY) {
                    y++;
                    movedDistance++;
                } else {
                    movedDistance = 0;
                    direction = DIRECTIONS.RIGHT;
                }
            }
            case UP -> {
                if(movedDistance < maxDistanceY) {
                    y--;
                    movedDistance++;
                } else {
                    movedDistance = 0;
                    direction = DIRECTIONS.LEFT;
                }
            }
        }
        animation.tick(1,1);
    }

    @Override
    public void Render(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //g2.scale(scale,scale);
        g.drawImage(animation.getTiles(),x,y, null);
        g.setColor(Color.red);
        ((Graphics2D) g).draw(getBounds());
    }

    @Override
    public Rectangle getBounds() { return new Rectangle(x, y, width, height);}


    @Override
    protected void die() {
        handler.removeObject(this);
        handler.removeCollidableObject(this);
        Coin coin = new Coin(x, y, 0, null, handler);
        handler.addObject(coin);
        handler.addCollidableObject(coin);

    }

}
