package dev.oopjava.tileset;

import java.awt.image.BufferedImage;

public class Tileset {

    private BufferedImage tile;

    public Tileset(BufferedImage tile) {
        this.tile = tile;

    }

    public BufferedImage location(int x, int y, int width, int height) {
        return tile.getSubimage(x, y, width, height);
    }
}
