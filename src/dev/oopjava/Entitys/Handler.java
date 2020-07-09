package dev.oopjava.Entitys;

import javax.management.ObjectName;
import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<ObjectSettings> object = new LinkedList<>();
    private LinkedList<ObjectSettings> collidableObjects = new LinkedList<>();

    private boolean up = false, down = false, left = false, right = false, attack = false;

    public void Update() {
        for (ObjectSettings tempObject : object) {
            tempObject.Update();
        }
    }

    public LinkedList<ObjectSettings> getObject() {
        return object;
    }

    public void setObject(LinkedList<ObjectSettings> object) {
        this.object = object;
    }

    public void Render(Graphics g) {

        for (ObjectSettings tempObject : object) {
            tempObject.Render(g);
        }
    }

    public void addObject(ObjectSettings tempObject) {
        object.add(tempObject);
    }

    public void addCollidableObject(ObjectSettings tempObject) {
        collidableObjects.add(tempObject);
    }

    public void removeObject(ObjectSettings tempObject) {
        object.remove(tempObject);
    }

    public void removeCollidableObject(ObjectSettings tempObject) {
        collidableObjects.remove(tempObject);
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

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isAttacking() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    public LinkedList<ObjectSettings> getCollidableObjects() {
        return collidableObjects;
    }
}
