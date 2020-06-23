package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;

import java.awt.*;
import java.util.Random;

public class Border {

    private int i;
    Graphics g;
    int width,height, scale, screenWidth, screenHeight, x, y, z,currentWidth, currentHeight;
    private boolean started;

    public Border(Graphics g, int scale) {
        this.g = g;
        this.scale = scale;

        width = 16 * scale;
        height = 16 * scale;

        Random random = new Random();

        if(!started) {

            Toolkit tk = Toolkit.getDefaultToolkit();
            screenWidth = tk.getScreenSize().width;
            screenHeight = tk.getScreenSize().height;

            x = (int)Math.ceil(screenWidth / (16 * scale)) - 2;
            y = (int)Math.ceil(screenHeight / (16 * scale)) - 2;
            z = x;
            currentWidth = width;
            currentHeight = height;

            for(; z > 0; z--) {

                i = random.nextInt(2 - 0 + 1);
                g.drawImage(Assets.wallTop[i],currentWidth,0, null);
                currentWidth += width;
            }
        }
        started = true;
    }
}
