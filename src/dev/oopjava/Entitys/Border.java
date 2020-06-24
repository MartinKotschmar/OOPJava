package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.function.Function;

public class Border {

    private int i, i2, index;
    private int X, Y, I;
    Graphics g;
    int width,height, scale, screenWidth, screenHeight, x, y, z, currentWidthTop, currentWidthBottom, currentHeightLeft, currentHeightRight, currentHeight;
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
            if(index < 10) {
                createBorder();
            }
        }

        public void createBorder() {
            Random random = new Random();
            Toolkit tk = Toolkit.getDefaultToolkit();
            screenWidth = tk.getScreenSize().width;
            screenHeight = tk.getScreenSize().height;

            x = (int) Math.ceil(screenWidth / (16 * scale)) - 2;
            y = (int) Math.ceil(screenHeight / (16 * scale)) - 2;
            z = x;
            currentWidthTop = width;
            currentWidthBottom = width;
            currentHeightLeft = height;
            currentHeightRight = height;
            currentHeight = height;

            for (; z > 0; z--) {

                i = random.nextInt(2 + 1);
                g.drawImage(Assets.wallTop[i], currentWidthTop, 0, null);
                processing.setImage(Assets.wallTop[i]);
                processing.setX(currentWidthTop);
                processing.setY(0);
                currentWidthTop += width;
                i2 = random.nextInt(1 + 1);
                g.drawImage(Assets.wallBottom[i2], currentWidthBottom, (y + 1) * 16, null);
                processing.setImage(Assets.wallBottom[i2]);
                processing.setX(currentWidthBottom);
                processing.setY((y + 1) * 16);

                currentWidthBottom += width;

                if(z > y){
                    i = random.nextInt(2 + 1);
                    g.drawImage(Assets.wallLeft[i], 0, currentHeightLeft, null);
                    g.drawImage(Assets.wallRight[i], screenWidth / scale - width, currentHeightLeft, null);
                    currentHeightLeft += height;}
            }
        }

}
