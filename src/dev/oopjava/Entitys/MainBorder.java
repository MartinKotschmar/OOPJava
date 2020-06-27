package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;

public class MainBorder {
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
    Graphics g;


    public MainBorder(int numberOfRooms, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int scale, boolean itemroom, Graphics g) {
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

        currentHeightWallLeft = height;
        currentHeightWallRight = height;

        currentWidthWallTop = width;

        width = 16;
        height = 16;
        i = 0;

        //if(itemroom == true) {normalRooms = numberOfRooms - 1;} else normalRooms = numberOfRooms;
        normalRooms = numberOfRooms;

        CreateBorder();

    }

    public void BorderLeftRight() {

        YAssetParts = (int) Math.ceil(y / (16 * scale)) - 1; //Number of Tiles y total height except corner tile bottom
        XAssetParts = (int) Math.ceil(x / (16 * scale)) - 2; //Number of Tiles x Corners will be added by left and right wall

        maxX = x / scale;
        maxY = y / scale;

        for(;YAssetParts > 0; YAssetParts--) {

            if(i>1) {i=0;}
            g.drawImage(Assets.wallLeft[i], 0, currentHeightWallLeft - height + a, null);   //create wall left
            g.drawImage(Assets.wallRight[i], maxX - width, currentHeightWallLeft - height + a , null); //create wall right
            currentHeightWallLeft += height;
            i++;
        }
        currentHeightWallLeft -= height;
        i = 0;
        StaticBorder(currentHeightWallLeft);
    }

    public void StaticBorder(int heightWallBottom) {
        this.heightWallBottom = heightWallBottom;

        for(;XAssetParts > 0; XAssetParts--) {
            if(i>2){i = 0; }

            g.drawImage(Assets.wallTop[i], currentWidthWallTop, 0 + a, null); //create wall top
            g.drawImage(Assets.wallBottom[i], currentWidthWallTop, heightWallBottom + a, null); //create wall bottom
            currentWidthWallTop += width;
            i++;
        }
        i = 0;
    }

    public void CreateBorder() {

        for(;normalRooms > 0; normalRooms--) {
            index = normalRooms;
            switch(index) {
                case(1):
                    x = x1;
                    y = y1;
                    a = 0;
                    BorderLeftRight();
                    break;
                case(2):
                    x = x2;
                    y = y2;
                    a = y1;
                    BorderLeftRight();
                    break;
                case(3):
                    x = x3;
                    y = y3;
                    a = y1 + y2;
                    BorderLeftRight();
                    break;
                case(4):
                    x = x4;
                    y = y4;
                    a = y1 + y2 + y3;
                    BorderLeftRight();
                    break;
                case(5):
                    x = x5;
                    y = y5;
                    a = y1 + y2 + y3 + y4;
                    BorderLeftRight();
                    break;
                default:
                    break;
            }
        }

    }
}
