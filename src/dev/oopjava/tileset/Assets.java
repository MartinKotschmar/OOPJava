package dev.oopjava.tileset;

import java.awt.image.BufferedImage;

import dev.oopjava.tileset.Tileset;

public class Assets {

    private static final int width = 16, height = 16;

    public static BufferedImage cornerLT, cornerRT, cornerLB, cornerRB, floor3x3, floor4x3,
                                wallTop1, wallTop2, wallTop3, wallDown1, wallDown2,
                                brownboxsmall, greyboxsmall, greyboxmedium, greyboxlarge,
                                brownboxmedium, greyboxsmall2, goldcoin, bluedrinksmall,
                                silverkey, reddrinkmedium, burningtorch, burninghalftorch,
                                torch, burningconsolemedium, consolemedium, burningconsolesmall,
                                consolesmall, bluedrinkmedium, reddrinksmall, goldenkey,
                                flag, trophysmall, trophymedium, skeleton, trashmedium,
                                trashsmall, roundentryleft, roundentryright, bones,
                                bordermiddledown, borderleftdown, borderrightdown, stonessmall,
                                bordermiddleup, borderleftup, borderrightup, stonesmedium,
                                entryleft, entryright, entry, ladder, oldiespear, oldienormal,
                                oldiehat, oldieknife, newbiespear, newbieknife, newbienormal,
                                blueflame, blueflameghost, femalefrankenstein, malefrankenstein,
                                ghostknife, ghostspear, ghostsythe;
    public static BufferedImage[] priest1v1, priest1v1left;

    public static void init(){

        Tileset parts = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/character and tileset/Dungeon_Tileset.png"));


        //borders and ground

        cornerLT = parts.location(0, 0, width, height);
        cornerLB = parts.location(0,64, width,height);
        cornerRT = parts.location(80,0, width,height);
        cornerRB = parts.location(80,64, width,height);
        floor4x3 = parts.location(96, 0, 64, 48);
        floor3x3 = parts.location(96, 0, 64, 32);
        wallTop1 = parts.location(16,0, width,height);
        wallTop2 = parts.location(32,0, width,height);
        wallTop3 = parts.location(48,0, width,height);
        wallDown1 = parts.location(16,64, width,height);
        wallDown2 = parts.location(32,64, width,height);

        //items and accessoires

        entryleft = parts.location(96,48, width,height);
        entryright = parts.location(112,48, width,height);
        entry = parts.location(128,48, width,height);
        ladder = parts.location(144,48, width,height);

        bordermiddleup = parts.location(96,64, width,height);
        borderleftup = parts.location(112,64, width,height);
        borderrightup = parts.location(128,64, width,height);
        stonesmedium = parts.location(144,64, width,height);

        bordermiddledown = parts.location(96,80, width,height);
        borderleftdown = parts.location(112,80, width,height);
        borderrightdown = parts.location(128,80, width,height);
        stonessmall = parts.location(144,80, width,height);

        trashmedium = parts.location(64,96, width,height);
        trashsmall = parts.location(80,96, width,height);
        roundentryleft = parts.location(96,96, width,height);
        roundentryright = parts.location(112,96, width,height);
        bones = parts.location(128,96, width,height);

        flag = parts.location(64,112, width,height);
        trophysmall = parts.location(80,112, width,height);
        trophymedium = parts.location(96,112, width,height);
        skeleton = parts.location(112,112, width,height);

        brownboxsmall = parts.location(0,128, width,height);
        greyboxsmall = parts.location(16,128, width,height);
        greyboxmedium = parts.location(32,128, width,height);
        brownboxmedium = parts.location(48,128, width,height);
        greyboxlarge = parts.location(64,128, width,height);
        greyboxsmall2 = parts.location(80,128, width,height);
        goldcoin = parts.location(96,128, width,height);
        bluedrinksmall = parts.location(112,128, width,height);
        silverkey = parts.location(128,128, width,height);
        reddrinkmedium = parts.location(144,128, width,height);

        burningtorch = parts.location(0,144, width,height);
        burninghalftorch = parts.location(16,144, width,height);
        torch = parts.location(32,144, width,height);
        burningconsolemedium = parts.location(48,144, width,height);
        consolemedium = parts.location(64,144, width,height);
        burningconsolesmall = parts.location(80,144, width,height);
        consolesmall = parts.location(96,144, width,height);
        bluedrinkmedium = parts.location(112,144, width,height);
        reddrinksmall = parts.location(128,144, width,height);
        goldenkey = parts.location(144,144, width,height);


        //Characters
        Tileset characters = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/character and tileset/Dungeon_Character_2.png"));

        oldiespear = characters.location(0,0, width, height);
        oldienormal = characters.location(16,0, width, height);
        oldiehat = characters.location(32,0, width, height);
        oldieknife = characters.location(48,0, width, height);
        newbiespear = characters.location(64,0, width, height);
        newbieknife = characters.location(80,0, width, height);
        newbienormal = characters.location(96,0, width, height);

        blueflame = characters.location(0,16, width, height);
        blueflameghost = characters.location(16,16, width, height);
        femalefrankenstein = characters.location(32,16, width, height);
        malefrankenstein = characters.location(48,16, width, height);
        ghostknife = characters.location(64,16, width, height);
        ghostspear = characters.location(80,16, width, height);
        ghostsythe = characters.location(96,16, width, height);

        //Animation
        priest1v1 = new BufferedImage[4];


        Tileset animation_priest1v1_2 = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest1_v1_2.png"));

        priest1v1[0] = animation_priest1v1_2.location(0,0,width,height);
        Tileset animation_priest1v1_1 = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest1_v1_1.png"));

        priest1v1[1] = animation_priest1v1_1.location(0,0,width,height);

        Tileset animation_priest1v1_3 = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest1_v1_3.png"));

        priest1v1[2] = animation_priest1v1_3.location(0,0,width,height);

        Tileset animation_priest1v1_4 = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest1_v1_4.png"));

        priest1v1[3] = animation_priest1v1_4.location(0,0,width,height);

        //left

        Tileset animation_priest1v1_1left = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest1_v1_1left.png"));

        priest1v1left = new BufferedImage[4];

        priest1v1left[0] = animation_priest1v1_1left.location(0,0,width,height);

        Tileset animation_priest1v1_2left = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest1_v1_2left.png"));

        priest1v1left[1] = animation_priest1v1_2left.location(0,0,width,height);

        Tileset animation_priest1v1_3left = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest1_v1_3left.png"));

        priest1v1left[2] = animation_priest1v1_3left.location(0,0,width,height);

        Tileset animation_priest1v1_4left = new Tileset(ImageLoader.loadImage("/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest1_v1_4left.png"));

        priest1v1left[3] = animation_priest1v1_4left.location(0,0,width,height);

    }


}
