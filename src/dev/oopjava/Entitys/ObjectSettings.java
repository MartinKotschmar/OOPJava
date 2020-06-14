package dev.oopjava.Entitys;

import java.awt.*;

public abstract class ObjectSettings {

    protected int x,y;
    protected float velX = 0, velY = 0;
    protected ID id;


    public ObjectSettings(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;

    }


    public abstract void Update();
    public abstract void Render(Graphics g);
    public abstract Rectangle getBounds();

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
