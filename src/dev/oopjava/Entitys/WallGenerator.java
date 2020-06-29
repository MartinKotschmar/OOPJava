package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;

public class WallGenerator {

    int x,y, z, xz,yz;
    int height;
    int width;
    Graphics g;

    public WallGenerator(int x, int y, int xz, int yz, Graphics g) {

        this.x = x;
        this.y = y;
        this.xz = xz;
        this.yz = yz;
        this.g = g;

        width = 16;
        height = 16;

        if(x == xz) { CreateWallStraight(); }
        if(y == yz) {CreateWallDown();}
    }

    public void CreateWallDown() {

        z = yz - y;
        g.drawImage(Assets.walltop, x,y,null);
        for(;z > 2; z--) {
            g.drawImage(Assets.walldown,x,y + height,null);
            y+= height;
        }
        g.drawImage(Assets.wallbot,x,yz,null);
    }
    public void CreateWallStraight() {

        z = xz - x;
        g.drawImage(Assets.wallleft, x,y,null);
        for(;z > 2; z--) {
            g.drawImage(Assets.walls,x + width,y,null);
            x+= width;
        }
        g.drawImage(Assets.wallright,xz,y,null);

    }
}
