package dev.oopjava.Entitys;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

        LinkedList<ObjectSettings> object = new LinkedList<ObjectSettings>();

        private boolean up = false, down = false, left = false, right = false;

    public void Update() {
            for(int i = 0; i < object.size(); i++) {
                ObjectSettings tempObject = object.get(i);

                tempObject.Update();
            }
    }

    public LinkedList<ObjectSettings> getObject() {
        return object;
    }

    public void setObject(LinkedList<ObjectSettings> object) {
        this.object = object;
    }

    public void Render (Graphics g) {

        for(int i = 0; i < object.size(); i++) {
            ObjectSettings tempObject = object.get(i);

            tempObject.Render(g);
        }
    }

    public void addObject(ObjectSettings tempObject){
        object.add(tempObject);
    }

    public void removeObject(ObjectSettings tempObject) {
        object.remove(tempObject);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() { return right; }

    public void setRight(boolean right) {
        this.right = right;
    }

}
