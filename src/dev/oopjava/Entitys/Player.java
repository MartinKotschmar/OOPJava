package dev.oopjava.Entitys;

import dev.oopjava.Level.LEVELS;
import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Player extends ObjectSettings{

    private Camera camera;
    private int exX, exY;
    private static BufferedImage[] character;
    private DIRECTIONS viewDirection;
    private int attackRectSize;

    int minCenterDoor, maxCenterDoor,minBorderX,maxBorderX,minBorderY,maxBorderY;

    public Player(int x, int y, int speed,int scale, ID id, Handler handler){
        super(x, y, speed, id);
        this.handler = handler;
        this.scale = scale;
        tick = 150;
        width = 16;
        height = 16;
        health = 100;
        viewDirection = DIRECTIONS.RIGHT;
        attackRectSize = 8;
        attackDamage = 0.5;

        character = Assets.priest1v1;
        animation = new CharacterAnimation(tick, velX, character);
    }

    public void Render(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        //g2.scale(scale,scale);

        g.drawImage(animation.getTiles(),x,y, null);
        g.setColor(Color.red);
        ((Graphics2D) g).draw(getBounds());
        g.setColor(Color.green);

        // Render Health
        g.setColor(Color.white);
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 5));
        int viewHealth = (int) health;
        g.drawString(""+ viewHealth, x+3, y+20);
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


        animation.tick(velX,velY);

        move();
        checkAttack();
    }

    private void move() {
        // UP
        if (handler.isUp() && !isColliding("up")){
            velY = -speed;
            viewDirection = DIRECTIONS.UP;
        } else if (!handler.isDown()){
            velY = 0;
        }
        // DOWN
        if (handler.isDown() && !isColliding("down")){
            velY = speed;
            viewDirection = DIRECTIONS.DOWN;
        } else if (!handler.isUp()){
            velY = 0;
        }
        // LEFT
        if (handler.isLeft() && !isColliding("left")) {
            velX = -speed;
            viewDirection = DIRECTIONS.LEFT;
        } else if (!handler.isRight()){
            velX = 0;
        }
        // RIGHT
        if (handler.isRight() && !isColliding("right")) {
            velX = speed;
            viewDirection = DIRECTIONS.RIGHT;
        } else if (!handler.isLeft()){
            velX = 0;
        }
    }

    private void checkAttack() {
        if(handler.isAttacking()) {
            Rectangle attackRect = getBounds();

            switch (viewDirection) {
                case UP -> attackRect.y -= attackRectSize;
                case DOWN -> attackRect.y += attackRectSize;
                case LEFT -> attackRect.x -= attackRectSize;
                case RIGHT -> attackRect.x += attackRectSize;
            }

            for(ObjectSettings tempObj : handler.getCollidableObjects()) {
                if (attackRect.getBounds().intersects(tempObj.getBounds())) {
                    tempObj.removeHealth(attackDamage);
                }
            }
        }
    }

    public boolean isColliding(String direction){
        LinkedList<ObjectSettings> collidableObjects = handler.getCollidableObjects();
        LinkedList<Rectangle> wallRectangles = handler.getWallRectangles();
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
                if(tempObj instanceof Flask) {
                    addHealth(tempObj.health);
                    tempObj.die();
                } else {
                    removeHealth(tempObj.getAttackDamage());
                }
                return true;
            }
        }

        for(Rectangle wallrect : wallRectangles){
            if(newPosition.getBounds().intersects(wallrect)) {
                return true;
            }
        }

        return false;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    protected void die() {
        handler.playerDied();
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
