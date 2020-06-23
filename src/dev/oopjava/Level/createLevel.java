package dev.oopjava.Level;

import dev.oopjava.tileset.*;
import dev.oopjava.Display.*;
import dev.oopjava.Display.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class createLevel extends Game{

    private GameWindow display;
    private BufferStrategy bs;

    //private BufferStrategy bs;
    //private BufferedImage testImage;
    //private Graphics g;

    public createLevel(String title) {
        super(title);


        render();
    }


    private void render(){

    bs = display.getCanvas().getBufferStrategy();

    if(bs == null){

        display.getCanvas().createBufferStrategy(3);
        return;
    }

    Graphics g = bs.getDrawGraphics();


    Graphics2D g2 = (Graphics2D) g;



    g.setColor(Color.black);
    g.fillRect(0,0,1920,1800);

    g.dispose();
    bs.show();

    }

}
