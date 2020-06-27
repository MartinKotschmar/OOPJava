package dev.oopjava.Entitys;

import java.awt.*;

public abstract class ObjectSettings {

    protected int x,y;
    protected double velX = 1, velY = 1;
    protected double speed;
    protected ID id;


    public ObjectSettings(int x, int y, double speed, ID id) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.id = id;
    }


    public abstract void Update();
    public abstract void Render(Graphics g);
    public abstract Rectangle getBounds();

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getSpeed() {
        return speed;
    }

    public ID getId() {
        return id;
    }

}
