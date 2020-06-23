package dev.oopjava.Level;

import dev.oopjava.Entitys.Border;
import dev.oopjava.Entitys.Handler;
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
    int scale;

    public CreateLevel(Graphics g, Handler handler, int scale, boolean started) {
        this.g = g;
        this.handler = handler;
        this.scale = scale;
        this.started = started;

        Render();
    }

    private void Render(){
        g.setColor(Color.black);
        g.fillRect(0,0,1920,1080);
        border = new Border(g, scale, started);
    }
}
