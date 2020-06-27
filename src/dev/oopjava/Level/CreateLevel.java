package dev.oopjava.Level;

import dev.oopjava.Entitys.Border;
import dev.oopjava.Entitys.Handler;
import dev.oopjava.Entitys.MainBorder;
import dev.oopjava.Entitys.Processing;
import dev.oopjava.tileset.*;
import dev.oopjava.Display.*;
import dev.oopjava.Display.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class CreateLevel {

    private MainBorder border;
    Graphics g;
    Handler handler;
    Processing processing;
    Game game;
    int scale, index, e;

    public CreateLevel(Graphics g, Handler handler, int scale, int index, Processing processing) {
        this.g = g;
        this.handler = handler;
        this.scale = scale;
        this.index = index;
        this.processing = processing;

        Render();
    }

    private void Render(){
        Color gameColor = Color.decode("#25131A");
        g.setColor(gameColor);
        g.fillRect(0 ,0,1920 * 5, 1080 * 5);
        //border = new Border(g, scale, index, 0, processing);
        //border = new Border(g, scale, index, 1, processing);
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(5,5);
        border = new MainBorder(2,1920,1080,1920,1080,0,0,0,0,0,0,scale,true,g);
        g2.scale(0.2,0.2);
    }
}