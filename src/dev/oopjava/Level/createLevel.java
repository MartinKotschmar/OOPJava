package dev.oopjava.Level;

import dev.oopjava.*;
import dev.oopjava.Display.*;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class createLevel() {

    private Menu display;
    //private BufferStrategy bs;
    private BufferedImage testImage;
    private Graphics g;

    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null){
        this.createBufferStrategy(3);
        return;
    }
        Graphics g = bs.getDrawGraphics();


        g.setColor(Color.black);
        g.fillRect(0,0,1920,1800);

        g.dispose();
        bs.show();
}
