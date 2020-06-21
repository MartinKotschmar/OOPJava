package dev.oopjava.Level;

import dev.oopjava.*;
import dev.oopjava.Display.*;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class createLevel(Graphics g) {

    private Menu display;
    //private BufferStrategy bs;
    private BufferedImage testImage;
    private Graphics g;

        Graphics g = bs.getDrawGraphics();


        g.setColor(Color.black);
        g.fillRect(0,0,1920,1800);

        g.dispose();
        bs.show();
}
