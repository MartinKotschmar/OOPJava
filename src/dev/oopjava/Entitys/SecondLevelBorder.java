package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;

public class SecondLevelBorder {
    private int screenWidth,screenHeight;
    private int numberOfRooms, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, scale;
    private int totalX, totalY,levelWidthSize, levelHeightSize,normalRooms, index;
    private int x, y, i, a;
    private int YAssetParts, XAssetParts, maxX, maxY;
    private int xz1, xz2, xz3, xz4, xz5;
    private int yz1, yz2, yz3, yz4, yz5;
    private int width, height;
    private int currentHeightWallLeft, currentHeightWallRight, currentWidthWallTop,heightWallBottom;
    private boolean itemroom;
    private int currentWidthFloor, currentHeightFloor;
    private int YFloorParts, XFloorParts;
    private int currentWidthFloorTB, currentHeightFloorTB;
    Graphics g;
    private WallGenerator wall;


    public SecondLevelBorder(int numberOfRooms, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int scale, boolean itemroom, Graphics g) {
        this.numberOfRooms = numberOfRooms;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
        this.x5 = x5;
        this.y5 = y5;
        this.scale = scale;
        this.itemroom = itemroom;
        this.g = g;

        Variables();
    }


    public int getTotalY() {
        return totalY;
    }

    public void setTotalY(int totalY) {
        this.totalY = totalY;
    }

    public void Variables() {

        Toolkit tk = Toolkit.getDefaultToolkit();
        screenWidth = tk.getScreenSize().width;
        screenHeight = tk.getScreenSize().height;

        totalX = x1 + x2 + x3 + x4 + x5;
        totalY = y1 + y2 + y3 + y4 + y5;

        levelWidthSize = numberOfRooms * screenWidth;
        levelHeightSize = numberOfRooms * screenHeight;

        width = 16;
        height = 16;
        i = 0;

        currentHeightWallLeft = height;
        currentHeightWallRight = height;

        currentWidthWallTop = width;

        //if(itemroom == true) {normalRooms = numberOfRooms - 1;} else normalRooms = numberOfRooms;
        normalRooms = 0;

        CreateBorder();

    }

    public void BorderLeftRight() {

        YAssetParts = (int) Math.ceil(y / (16 * scale)); //- 1; //Number of Tiles y total height except corner tile bottom -1 für ein Raum < als der Bildschirm
        XAssetParts = (int) Math.ceil(x / (16 * scale)) - 2; //Number of Tiles x Corners will be added by left and right wall
        YFloorParts = (int) Math.ceil(y / (16 * scale)) - 3;
        XFloorParts = (int) Math.ceil(x / (16 * scale)) - 4;

        maxX = x / scale;
        maxY = y / scale;

        for(;YAssetParts > 0; YAssetParts--) {

            if(i>1) {i=0;}
            g.drawImage(Assets.wallLeft[i], 0 + ((1920 - x)/10), currentHeightWallLeft - height + a, null);   //create wall left
            g.drawImage(Assets.wallRight[i],  1920/5 - width - ((1920 - x)/10), currentHeightWallLeft - height + a , null); //create wall right
            currentHeightWallLeft += height;
            i++;
        }
        currentHeightWallLeft -= height;
        i = 0;
        StaticBorder(currentHeightWallLeft);
        FloorCorners(currentHeightWallLeft);
        BorderTopBottom(currentHeightWallLeft);
    }

    public void StaticBorder( int currentHeightWallLeft) {
        g.drawImage(Assets.cornerLB, 0 + ((1920 - x)/10), currentHeightWallLeft + a, null); //static corner left bottom
        g.drawImage(Assets.cornerRB, 1920/5 - width - ((1920 - x)/10), currentHeightWallLeft + a, null); //static corner right bottom
    }

    public void FloorCorners( int currentHeightWallLeft) {
        currentWidthFloor = width;
        currentHeightFloor = height;
        currentWidthFloorTB = width;
        currentHeightFloorTB = height;
        g.drawImage(Assets.floorLT, currentWidthFloor + (1920 - x)/10, currentHeightFloor + a, null); //create Floor
        g.drawImage(Assets.floorRT, x / scale - (2 * width) + (1920 - x)/10, currentHeightFloor + a , null); //create Floor
        g.drawImage(Assets.floorLB, currentWidthFloor + (1920 - x)/10, currentHeightWallLeft - height + a, null); //create Floor
        g.drawImage(Assets.floorRB, x / scale - 2 * width + (1920 - x)/10, currentHeightWallLeft - height +a , null); //create Floor

        for(; YFloorParts > 0; YFloorParts--) {
            g.drawImage(Assets.floorLeft, currentWidthFloor + (1920 - x)/10, currentHeightFloor + a + height, null); //create Floor
            g.drawImage(Assets.floorRight, x / scale - (2 * width) + (1920 - x)/10, currentHeightFloor + a + height, null); //create Floor
            currentHeightFloor += height;
        }
        for(; XFloorParts > 0; XFloorParts--) {

            if (i > 1) {i = 0;}

            if(XFloorParts < ((int) Math.ceil(x / (16 * scale)) -4)/2|| XFloorParts > ((int) Math.ceil(x / (16 * scale)) - 4)/2+1) {
                g.drawImage(Assets.floorBottom[i], currentWidthFloorTB + (1920 - x) / 10 + width, currentHeightWallLeft - height + a, null); //create Floor
                g.drawImage(Assets.floorTop[i], currentWidthFloorTB + (1920 - x) / 10 + width, height + a, null); //create Floor
                currentWidthFloorTB += width;
                i++;
            } else {
                g.drawImage(Assets.floorCenter[i], currentWidthFloorTB + ((1920 - x) / 10) + width, currentHeightWallLeft - height + a, null);
                g.drawImage(Assets.floorCenter[i], currentWidthFloorTB + ((1920 - x) / 10) + width, height + a, null);
                currentWidthFloorTB += width; i++;
            }
        }
        XFloorParts = (int) Math.ceil(x / (16 * scale)) - 4;
        YFloorParts = (int) Math.ceil(y / (16 * scale)) - 3;
        currentWidthFloor = width;
        currentHeightFloor = height;
        for (; YFloorParts > 0; YFloorParts--) {

            for (; XFloorParts > 0; XFloorParts--) {
                if (i > 11) {
                    i = 0;
                }
                g.drawImage(Assets.floorCenter[i], currentWidthFloor + width + (1920 - x)/10, currentHeightFloor + height + a, null); //create Floor
                currentWidthFloor += width;
                i++;
            }
            currentWidthFloor = width;
            currentHeightFloor += height;
            XFloorParts = (int) Math.ceil(x / (16 * scale)) - 4;
        }
    }

    public void Floor() {

    }

    public void BorderTopBottom(int heightWallBottom) {
        this.heightWallBottom = heightWallBottom;

        for(;XAssetParts > 0; XAssetParts--) {
            if(i>2){i = 0; }

            if(XAssetParts < ((int) Math.ceil(x / (16 * scale)) - 2)/2 || XAssetParts > ((int) Math.ceil(x / (16 * scale)) - 2)/2 +1) {
                g.drawImage(Assets.wallTop[i], currentWidthWallTop + ((1920 - x) / 10), 0 + a, null); //create wall top
                g.drawImage(Assets.wallBottom[i], currentWidthWallTop + ((1920 - x) / 10), heightWallBottom + a, null); //create wall bottom
            } else {
                g.drawImage(Assets.floorCenter[i], currentWidthWallTop + ((1920 - x) / 10), 0 + a, null);
                g.drawImage(Assets.floorCenter[i], currentWidthWallTop + ((1920 - x) / 10), heightWallBottom + a, null);
                currentWidthFloor += width * 2;
            }
            currentWidthWallTop += width;
            i++;
        }
        currentWidthWallTop = width;
        currentHeightWallLeft = height;
        i = 0;
    }

    public void CreateBorder() {

        if(itemroom == true) {
            x = screenWidth/2;
            y = screenHeight/2;
        }

        for(;normalRooms < numberOfRooms; normalRooms++) {
            index = normalRooms;
            switch(index) {
                case(0):
                    x = x1;
                    y = y1;
                    a = 0;
                    BorderLeftRight();
                    break;
                case(1):
                    x = x2;
                    y = y2;
                    a = heightWallBottom + height;
                    BorderLeftRight();
                    wall = new WallGenerator(16,48,64,48,g);
                    break;
                case(2):
                    x = x3;
                    y = y3;
                    a += heightWallBottom + height;
                    BorderLeftRight();
                    break;
                case(3):
                    x = x4;
                    y = y4;
                    a += heightWallBottom + height;
                    BorderLeftRight();
                    break;
                case(4):
                    x = x5;
                    y = y5;
                    a += heightWallBottom + height;
                    BorderLeftRight();
                    break;
                default:
                    break;
            }
        }

    }
}
