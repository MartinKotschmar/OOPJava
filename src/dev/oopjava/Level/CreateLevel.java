package dev.oopjava.Level;

import dev.oopjava.Entitys.Border;
import dev.oopjava.Entitys.Handler;
import dev.oopjava.Entitys.Processing;
import dev.oopjava.tileset.*;
import dev.oopjava.Display.*;
import dev.oopjava.Display.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class CreateLevel {

    private Menu display;
    private BufferStrategy buffer;
    private Border border;
    private boolean started;
    Graphics g;
    Handler handler;
    Processing processing;
    int scale, index;

    public CreateLevel(Graphics g, Handler handler, int scale, int index, Processing processing) {
        this.g = g;
        this.handler = handler;
        this.scale = scale;
        this.index = index;
        this.processing = processing;

        Render();
    }

    private void Render(){
        g.setColor(Color.black);
        g.fillRect(0,0,1920,1080);
        border = new Border(g, scale, index, processing);
    }
}