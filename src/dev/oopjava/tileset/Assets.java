package dev.oopjava.tileset;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 16, height = 16;

    public static BufferedImage cornerLT, cornerRT, cornerLB, cornerRB, floor4x3, floor, wallTop1, wallTop2, wallTop3;

    public static void init(){

        Tileset tile = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/character and tileset/Dungeon_Tileset.png"));

        cornerLT = tile.location(0, 0, width, height);
        cornerLB = tile.location(0,80,width,height);
        cornerRT = tile.location(80,0,width,height);
        cornerRB = tile.location(80,80,width,height);
        floor4x3 = tile.location(96, 0, 64, 48);
        floor = tile.location(32, 32, 32, 16);
        wallTop1 = tile.location(16,0, width,height);
        wallTop2 = tile.location(32,0, width,height);
        wallTop3 = tile.location(48,0, width,height);

    }

}
