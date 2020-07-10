package dev.oopjava.Entitys;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Processing {

    LinkedList<Background> object = new LinkedList<Background>();

    private int x, y, i;
    private BufferedImage image;

    public void Update() {
        for (int i = 0; i < object.size(); i++) {
            Background tempObject = object.get(i);

            tempObject.Update();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void Render(Graphics g) {

        for (int i = 0; i < object.size(); i++) {
            Background tempObject = object.get(i);

            tempObject.Render(g);
        }
    }
}
