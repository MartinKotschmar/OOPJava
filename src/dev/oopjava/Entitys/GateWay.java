package dev.oopjava.Entitys;

import dev.oopjava.Level.LEVELS;

import java.awt.*;

public class GateWay extends ObjectSettings {

    private LEVELS destination;

    public GateWay(int x, int y, int speed, ID id, Handler handler) {
        super(x, y, speed, id);
        this.destination = LEVELS.LEVEL2;
        this.handler = handler;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Render(Graphics g) {
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32,16);
    }

    @Override
    protected void die() {
        handler.setLevel(destination);
    }

    public LEVELS getDestination() {
        return destination;
    }

    public void setDestination(LEVELS destination) {
        this.destination = destination;
    }
}
