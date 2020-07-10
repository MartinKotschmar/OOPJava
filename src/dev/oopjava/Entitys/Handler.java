package dev.oopjava.Entitys;

import dev.oopjava.Display.Game;
import dev.oopjava.Level.LEVELS;

import javax.management.ObjectName;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<ObjectSettings> object = new LinkedList<>();
    private LinkedList<ObjectSettings> collidableObjects = new LinkedList<>();
    private LinkedList<Rectangle> wallRectangles = new LinkedList<>();
    private LinkedList<ObjectSettings> collectableObjects = new LinkedList<>();
    private Game activeGame;

    private static Handler instance;
    public static Handler getInstance() {
        return instance;
    }

    private boolean up = false, down = false, left = false, right = false, attack = false;

    public Handler(Game game) {
        this.activeGame = game;
        instance = this;
    }

    public void Render(Graphics g) {
        LinkedList<ObjectSettings> listToRender = new LinkedList<>(object);
        for (ObjectSettings tempObject : listToRender) {
            tempObject.Render(g);
        }
    }

    public void Update() {
        LinkedList<ObjectSettings> listToUpdate = new LinkedList<>(object);
        for (ObjectSettings tempObject : listToUpdate) {
            tempObject.Update();
        }
    }

    public LinkedList<ObjectSettings> getObject() {
        return object;
    }

    public void setObject(LinkedList<ObjectSettings> object) {
        this.object = object;
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

    public LinkedList<Rectangle> getWallRectangles() {
        return wallRectangles;
    }

    public void addWallRectangles(Rectangle wallRectangle) {
        this.wallRectangles.add(wallRectangle);
    }

    public void playerDied(){
        showDeathScreen();
        activeGame.stop();
    }

    private void showDeathScreen() {
        JFrame deathScreen = new JFrame();
        deathScreen.add(new JLabel("Du bist gestorben"));
        deathScreen.pack();
        deathScreen.setLocationRelativeTo(null);
        deathScreen.setVisible(true);
    }

    public void setLevel(LEVELS level) {
        activeGame.setLevel(level);
    }
}
