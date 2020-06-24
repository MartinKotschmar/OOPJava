package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.function.Function;

public class Border {

    private int i, i2, index, fx, fy;
    private int X, Y, I;
    Graphics g;
    int width,height, scale, screenWidth, screenHeight, x, y, z, currentWidthTop, currentWidthBottom, currentHeightLeft, currentHeightRight, currentHeight,currentWidthFloor, currentHeightFloor;
    private boolean started;
    public BufferedImage image;
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
           // Random random = new Random();
            Toolkit tk = Toolkit.getDefaultToolkit();
            screenWidth = tk.getScreenSize().width;
            screenHeight = tk.getScreenSize().height;

            x = (int) Math.ceil(screenWidth / (16 * scale)) - 2;
            y = (int) Math.ceil(screenHeight / (16 * scale));
            fx = (int) Math.ceil(screenWidth / (16 * scale)) - 2;
            fy = (int) Math.ceil(screenHeight / (16 * scale)) - 2;
            z = x;
            i = 0;
            currentWidthTop = width;
            currentWidthBottom = width;
            currentHeightLeft = height;
            currentHeightRight = height;
            currentHeight = height;
            currentHeightFloor = height;
            currentWidthFloor = width;

            g.drawImage(Assets.cornerLB, 0, (y -1 ) * 16, null);
            g.drawImage(Assets.cornerRB, screenWidth / scale - width, (y -1 ) * 16, null);

            for (; z > 0; z--) {

                if(i > 2) {i = 0;}

                g.drawImage(Assets.wallTop[i], currentWidthTop, 0, null);
               // processing.setImage(Assets.wallTop[i]);
               // processing.setX(currentWidthTop);
               // processing.setY(0);
                currentWidthTop += width;


                g.drawImage(Assets.wallBottom[i], currentWidthBottom, ((int) Math.ceil(screenHeight / (16 * scale)) -1 ) * 16, null);
               // processing.setImage(Assets.wallBottom[i2]);
               // processing.setX(currentWidthBottom);
               // processing.setY((y + 1) * 16);
                currentWidthBottom += width;

                if(y > 1){
                    g.drawImage(Assets.wallLeft[i], 0, currentHeightLeft - height, null);
                    g.drawImage(Assets.wallRight[i], screenWidth / scale - width, currentHeightLeft - height, null);
                    currentHeightLeft += height;
                }
                y--;
                i++;
            }

            for (; fy > 0; fy--) {

                for(; fx > 0; fx--) {
                    if(i > 5){i = 0;}
                    g.drawImage(Assets.floor[i], currentWidthFloor, currentHeightFloor, null);
                    currentWidthFloor += width;
                    i++;
                }
                currentWidthFloor = width;
                currentHeightFloor += height;
                fx = (int) Math.ceil(screenWidth / (16 * scale)) - 2;

            }
        }
}
