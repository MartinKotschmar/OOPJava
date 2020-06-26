package dev.oopjava.Entitys;

import dev.oopjava.Display.GameWindow;
import dev.oopjava.tileset.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Border {

    private int i, index, fx, staticfx, fy, fbx, fby, a, b, e,minCenterDoor,maxCenterDoor ;

    Graphics g;
    int width,height, scale, screenWidth, screenHeight, x, y, z, currentWidthTop, currentWidthBottom, currentHeightLeft,
            maxfloorheight,
            currentHeightRight, currentHeight,currentWidthFloorLR, currentWidthFloorTB, currentWidthFloor, currentHeightFloor, currentHeightFloorBorderLR, currentHeightFloorBorderTB;
    Processing processing;
    GameWindow display;

    public Border(Graphics g, int scale, int index, int e, Processing processing) {
        this.g = g;
        this.scale = scale;
        this.index = index;
        this.e = e;
        this.processing = processing;

        width = 16;
        height = 16;

        check();
    }

    private void check() {
            if(true) {
                createBorder();
            }
        }

        public void createBorder() {
            Toolkit tk = Toolkit.getDefaultToolkit();
            screenWidth = tk.getScreenSize().width;
            screenHeight = tk.getScreenSize().height;
            //screenWidth = display.getWidth();
            //screenHeight = display.getHeight();


            a = 1;
            b = 0;
            if(e == 1) { a = 1; b = 1;}
            if(e == 2) { a = 3; b = 2;}
            x = (int) Math.ceil(screenWidth / (16 * scale)) - 2; //gesamtbreite - Wände rechts und links
            y = (int) Math.ceil(screenHeight * a / (16 * scale)); //gesamthöhe
            fx = (int) Math.ceil(screenWidth / (16 * scale)) - 4; //breite für Boden
            staticfx = (int) Math.ceil(screenWidth / (16 * scale)) - 4;
            fy = (int) Math.ceil(screenHeight * a / (16 * scale)) - 4; //höhe für Boden
            fbx = (int) Math.ceil(screenWidth / (16 * scale)) - 4;
            fby = (int) Math.ceil(screenHeight * a / (16 * scale)) - 4;
            z = x;
            i = 0;
            currentWidthTop = width;
            currentWidthBottom = width;
            currentHeightLeft = height;
            currentHeightRight = height;
            currentHeight = height;
            currentHeightFloor = height;
            currentHeightFloorBorderLR = height;
            currentHeightFloorBorderTB = height;
            currentWidthFloorLR = width;
            currentWidthFloorTB = width;
            currentWidthFloor = width;
            maxfloorheight = (y * a - 2) * 16;
            minCenterDoor = screenWidth / (scale * 2) - 2 * width;
            maxCenterDoor = screenWidth / (scale * 2) + width;


            g.drawImage(Assets.cornerLB, 0, (y - 1 ) * 16, null); //static corner left bottom
            g.drawImage(Assets.cornerRB, screenWidth / scale - width, (y - 1 ) * 16, null); //static corner right bottom
            g.drawImage(Assets.floorLT, currentWidthFloor, currentHeightFloor, null); //create Floor
            g.drawImage(Assets.floorRT, screenWidth / scale - (2 * width), currentHeightFloor, null); //create Floor
            g.drawImage(Assets.floorLB, currentWidthFloor, (y - 2) * 16, null); //create Floor
            g.drawImage(Assets.floorRB, screenWidth / scale - 2 * width, (y - 2) * 16, null); //create Floor

            for (; z > 0; z--) { //iteriere durch alle tiles bis screen zu Ende

                if(i > 2) {i = 0;}

                g.drawImage(Assets.wallTop[i], currentWidthTop, 0, null); //create wall top
                currentWidthTop += width;

                g.drawImage(Assets.wallBottom[i], currentWidthBottom, ((int) Math.ceil(screenHeight * a / (16 * scale)) -1 ) * 16, null); //create wall bottom
                currentWidthBottom += width;

                if(y > 1){
                    g.drawImage(Assets.wallLeft[i], 0, currentHeightLeft - height, null);   //create wall left
                    g.drawImage(Assets.wallRight[i], screenWidth / scale - width, currentHeightLeft - height, null); //create wall right
                    currentHeightLeft += height;
                }
                y--;
                i++;
            }

            for(; fby > 0; fby--) {
                g.drawImage(Assets.floorLeft, currentWidthFloor, currentHeightFloorBorderLR + height, null); //create Floor
                g.drawImage(Assets.floorRight, screenWidth / scale - 2 * width, currentHeightFloorBorderLR + height, null); //create Floor
                currentHeightFloorBorderLR += height;
            }

            g.drawImage(Assets.floorLeft, minCenterDoor, 0, null);
            g.drawImage(Assets.floorCenter[5], minCenterDoor + width, 0, null);
            g.drawImage(Assets.floorCenter[5], minCenterDoor + 2 * width, 0, null);
            g.drawImage(Assets.floorRight, maxCenterDoor, 0, null);

            for(; fbx > 0; fbx--) {

                if (i > 1) {
                    i = 0;
                }
                g.drawImage(Assets.floorBottom[i], currentWidthFloorTB + width, maxfloorheight, null); //create Floor

                if(fbx < minCenterDoor / 16 - 1 || fbx >= maxCenterDoor / 16) {

                    g.drawImage(Assets.floorTop[i], currentWidthFloorTB + width, currentHeightFloorBorderTB, null); //create Floor
                    currentWidthFloorTB += width;
                    i++;
                } else {
                    g.drawImage(Assets.floorCenter[4], currentWidthFloorTB + width, currentHeightFloorBorderTB,null);
                    currentWidthFloorTB += width;
                }
            }

            for (; fy > 0; fy--) {

                for(; fx > 0; fx--) {
                    if(i > 11){i = 0;}
                    g.drawImage(Assets.floorCenter[i], currentWidthFloor + width, currentHeightFloor + height, null); //create Floor
                    currentWidthFloor += width;
                    i++;
                }
                currentWidthFloor = width;
                currentHeightFloor += height;
                fx = staticfx;

            }
           /* g.drawImage(Assets.wallleft, width, 10 * height, null);
            g.drawImage(Assets.walls, 2 * width, 10 * height, null);
            g.drawImage(Assets.walls, 3 * width, 10 * height, null);
            g.drawImage(Assets.walls, 4 * width, 10 * height, null);
            g.drawImage(Assets.walls, 5 * width, 10 * height, null);
            g.drawImage(Assets.walls, 6 * width, 10 * height, null);
            g.drawImage(Assets.walls, 7 * width, 10 * height, null);
            g.drawImage(Assets.walls, 8 * width, 10 * height, null);
            g.drawImage(Assets.walls, 9 * width, 10 * height, null);
            g.drawImage(Assets.walls, 10 * width, 10 * height, null);
            g.drawImage(Assets.walls, 11* width, 10 * height, null);
            g.drawImage(Assets.walls, 12* width, 10 * height, null);
            g.drawImage(Assets.walls, 13* width, 10 * height, null);
            g.drawImage(Assets.walls, 14* width, 10 * height, null);
            g.drawImage(Assets.walls, 15* width, 10 * height, null);
            g.drawImage(Assets.walls, 16* width, 10 * height, null);
            g.drawImage(Assets.walls, 17* width, 10 * height, null);
            g.drawImage(Assets.walls, 18* width, 10 * height, null);
            g.drawImage(Assets.walls, 19* width, 10 * height, null);
            g.drawImage(Assets.walls, 20* width, 10 * height, null);
            g.drawImage(Assets.walls, 21* width, 10 * height, null);
            g.drawImage(Assets.wallright, 22* width, 10 * height, null);
            g.drawImage(Assets.walltop, 3 * width, 0, null);
            g.drawImage(Assets.walldown, 3 * width, height, null);
            g.drawImage(Assets.walldown, 3 * width, 2 *height, null);
            g.drawImage(Assets.walldown, 3 * width, 3 *height, null);
            g.drawImage(Assets.walldown, 3 * width,4 * height, null);
            g.drawImage(Assets.walldown, 3 * width, 5 *height, null);
            g.drawImage(Assets.walldown, 3 * width, 6 *height, null);
            g.drawImage(Assets.walldown, 3 * width, 7 * height, null);
            g.drawImage(Assets.walldown, 3 * width, 8 * height, null);
            g.drawImage(Assets.walldown, 3 * width, 9 * height, null);
            g.drawImage(Assets.walldown, 3 * width, 10 * height, null);
            g.drawImage(Assets.wallbot, 3 * width, 11 * height, null); */


        }
}
