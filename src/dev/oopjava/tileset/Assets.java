package dev.oopjava.tileset;

import java.awt.image.BufferedImage;
import dev.oopjava.tileset.Tileset;

public class Assets {

    private static final int width = 16, height = 16;

    public static BufferedImage cornerLT, cornerRT, cornerLB, cornerRB, floor4x3, floor3x3, floor,
            wallTop1, wallTop2, wallTop3, char1, wallDown1, wallDown2;

    public static void init(){

        Tileset parts = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/character and tileset/Dungeon_Tileset.png"));

        cornerLT = parts.location(0, 0, width, height);
        cornerLB = parts.location(0,64, width,height);
        cornerRT = parts.location(80,0, width,height);
        cornerRB = parts.location(80,64, width,height);
        floor4x3 = parts.location(96, 0, 64, 48);
        floor3x3 = parts.location(96, 0, 64, 32);
        floor = parts.location(32, 32, 32, 16);
        wallTop1 = parts.location(16,0, width,height);
        wallTop2 = parts.location(32,0, width,height);
        wallTop3 = parts.location(48,0, width,height);
        wallDown1 = parts.location(16,64, width,height);
        wallDown2 = parts.location(32,64, width,height);

        Tileset characters = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/character and tileset/Dungeon_Character.png"));

        char1 = characters.location(0,0, width, height);

    }


}
