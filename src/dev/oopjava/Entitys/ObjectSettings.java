package dev.oopjava.Entitys;

import java.awt.*;

public abstract class ObjectSettings {

    protected CharacterAnimation animation;
    protected int x, y;
    protected int velX = 1, velY = 1;
    protected int speed;
    protected ID id;
    protected Handler handler;
    protected int width, height, scale;
    protected int tick;
    protected double health;
    protected double attackDamage;

    public ObjectSettings(int x, int y, int speed, ID id) {
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

    public void setId(ID id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public void removeHealth(double healthAmountToRemove) {
        if (health > 0) {
            health -= healthAmountToRemove;
        }
        if (health <= 0) {
            die();
        }
    }

    protected abstract void die();

    public void addHealth(double healthAmountToAdd) {
        if (health < 100) {
            health += healthAmountToAdd;
        } else {
            return;
        }
        if (health > 100) {
            health = 100;
        }
    }

    public double getAttackDamage() {
        return attackDamage;
    }
}
