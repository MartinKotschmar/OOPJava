package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;
import dev.oopjava.tileset.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Player extends ObjectSettings{

    private Camera camera;
    private int exX, exY;
    private static BufferedImage[] character;

    int minCenterDoor, maxCenterDoor,minBorderX,maxBorderX,minBorderY,maxBorderY;

    public Player(int x, int y, int speed,int scale, ID id, Handler handler){
        super(x, y, speed, id);
        this.handler = handler;
        this.scale = scale;
        tick = 150;
        width = 16;
        height = 16;

        character = Assets.priest1v1;
        animation = new CharacterAnimation(tick, velX, character);
    }

    public void Render(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        //g2.scale(scale,scale);

        g.drawImage(animation.getTiles(),x,y, null);
        g.setColor(Color.red);
        ((Graphics2D) g).draw(getBounds());
    }

    public void Update() {
        x += velX;
        y += velY;
        exX = x;
        exY = y;
        minCenterDoor = 1920/(scale * 2) - 2 * width;
        maxCenterDoor = 1920/(scale * 2);
        minBorderX = width;
        maxBorderX = 1920/scale - 2 * width;
        minBorderY = height;
        maxBorderY = 1080/scale - 2 * height;

       /* if(x < width) { x = width; }
        if(x > maxBorderX) { x = maxBorderX; }
        if(y < height) {
            y = height;
            if(x > minCenterDoor && x < maxCenterDoor) {
                y += velY;
            } else if(x <= minCenterDoor){ x = minCenterDoor;
            } else if(x >= maxCenterDoor){ x = maxCenterDoor;
            }
        }
        if(y > maxBorderY) { y = maxBorderY; }*/

        animation.tick(velX,velY);

        if (handler.isUp() && !isColliding("up")) velY = -speed;
        else if (!handler.isDown()) velY = 0;

        if (handler.isDown() && !isColliding("down")) velY = speed;
        else if (!handler.isUp()) velY = 0;

        if (handler.isLeft() && !isColliding("left")) {
            velX = -speed;
        }
        else if (!handler.isRight()) velX = 0;
        if (handler.isRight() && !isColliding("right")) {
            velX = speed;
        }
        else if (!handler.isLeft()) velX = 0;
    }

    public boolean isColliding(String direction){
        LinkedList<ObjectSettings> collidableObjects = handler.getCollidableObjects();
        Rectangle newPosition = getBounds();
        switch (direction) {
            case "up":
                newPosition.y -= speed;
                break;
            case "down":
                newPosition.y += speed;
                break;
            case "left":
                newPosition.x -= speed;
                break;
            case "right":
                newPosition.x += speed;
                break;
            default:
        }

        for(ObjectSettings tempObj : collidableObjects) {
            if (newPosition.getBounds().intersects(tempObj.getBounds())) {
                return true;
            }
        }

        return false;
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

    public int getExX() {
        return exX;
    }

    public void setExX(int exX) {
        this.exX = exX;
    }

    public int getExY() {
        return exY;
    }

    public void setExY(int exY) {
        this.exY = exY;
    }
}
