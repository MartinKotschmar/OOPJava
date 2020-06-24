package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Border {

    private int i, index, fx, staticfx, fy, fbx, fby;

    Graphics g;
    int width,height, scale, screenWidth, screenHeight, x, y, z, currentWidthTop, currentWidthBottom, currentHeightLeft,
            maxfloorheight,
            currentHeightRight, currentHeight,currentWidthFloorLR, currentWidthFloorTB, currentWidthFloor, currentHeightFloor, currentHeightFloorBorderLR, currentHeightFloorBorderTB;
    Processing processing;

    public Border(Graphics g, int scale, int index, Processing processing) {
        this.g = g;
        this.scale = scale;
        this.index = index;
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

            x = (int) Math.ceil(screenWidth / (16 * scale)) - 2; //gesamtbreite - Wände rechts und links
            y = (int) Math.ceil(screenHeight / (16 * scale)); //gesamthöhe
            fx = (int) Math.ceil(screenWidth / (16 * scale)) - 4; //breite für Boden
            staticfx = (int) Math.ceil(screenWidth / (16 * scale)) - 4;
            fy = (int) Math.ceil(screenHeight / (16 * scale)) - 4; //höhe für Boden
            fbx = (int) Math.ceil(screenWidth / (16 * scale)) - 4;
            fby = (int) Math.ceil(screenHeight / (16 * scale)) - 4;
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
            maxfloorheight = (y - 2) * 16;


            g.drawImage(Assets.cornerLB, 0, (y -1 ) * 16, null); //static corner left bottom
            g.drawImage(Assets.cornerRB, screenWidth / scale - width, (y - 1 ) * 16, null); //static corner right bottom
            g.drawImage(Assets.floorLT, currentWidthFloor, currentHeightFloor, null); //create Floor
            g.drawImage(Assets.floorRT, screenWidth / scale - (2 * width), currentHeightFloor, null); //create Floor
            g.drawImage(Assets.floorLB, currentWidthFloor, (y - 2) * 16, null); //create Floor
            g.drawImage(Assets.floorRB, screenWidth / scale - 2 * width, (y - 2) * 16, null); //create Floor

            for (; z > 0; z--) { //iteriere durch alle tiles bis screen zu Ende

                if(i > 2) {i = 0;}

                g.drawImage(Assets.wallTop[i], currentWidthTop, 0, null); //create wall top
                currentWidthTop += width;

                g.drawImage(Assets.wallBottom[i], currentWidthBottom, ((int) Math.ceil(screenHeight / (16 * scale)) -1 ) * 16, null); //create wall bottom
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

            for(; fbx > 0; fbx--) {
                if(i > 1) {i = 0;}
                g.drawImage(Assets.floorTop[i], currentWidthFloorTB + width, currentHeightFloorBorderTB, null); //create Floor
                g.drawImage(Assets.floorBottom[i], currentWidthFloorTB + width, maxfloorheight, null); //create Floor
                currentWidthFloorTB += height;
                i++;
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
        }
}
