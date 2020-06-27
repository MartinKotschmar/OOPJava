package dev.oopjava.Entitys;

import dev.oopjava.Display.Game;

public class Camera {

    Game game;
    private MainBorder border;
    private Player player;
    private float x, y;
    private float X, Y;

    public Camera(Game game, float x, float y){
        this.game = game;
        this.x = x;
        this.y = y;

    }

    public void centerOnEntity(ObjectSettings object){
        x = ((object.getX()));
        y = ((object.getY()));
    }

   /*public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }*/

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