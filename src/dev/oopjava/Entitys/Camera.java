package dev.oopjava.Entitys;

import dev.oopjava.Display.Game;

public class Camera {

    Game game;
    private float x, y;
    private float X, Y;

    public Camera(Game game, float x, float y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    public void centerOnEntity(ObjectSettings object) {
        x = object.getX() * 5 - 1920 / 2;
        y = object.getY() * 5 - 1080 / 2;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}