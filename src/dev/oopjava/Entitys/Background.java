package dev.oopjava.Entitys;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Background {

    protected int x, y, i;
    protected BufferedImage image;
    protected ID id;

    public Background(int x, int y, int i, BufferedImage image, ID id) {
        this.x = x;
        this.y = y;
        this.i = i;
        this.image = image;
        this.id = id;
    }

    public abstract void Update();

    public abstract void Render(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}

