package dev.oopjava.Display;

import dev.oopjava.Display.GameWindow;
import dev.oopjava.tileset.*;

import dev.oopjava.Level.*;

import dev.oopjava.Entitys.*;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Game implements Runnable {

    private GameWindow display;        //Display Klasse erstellen

    private createLevel level;  //Level erstellen


    public int width, height;       //breite, höhe
    public String title;            //Fenster Titel
    private Canvas canvas;


    private boolean running = false;
    private Thread thread;      //Thread erstellen

    private BufferedImage testImage;
    private Tileset tile;
    private BufferStrategy bs;
    private Graphics g;
    private Graphics2D g2;

    public Handler handler;



    public Game(String title) {     //Game Methode erstellen
        this.title = title;

        handler = new Handler();

    }

    private void Graphics(){

        display = new GameWindow(title, handler);

        Assets.init();

        handler.addObject(new Player(0,0, 1, ID.Player, handler));
    }

    private void Update(Handler handler){      //Update Fenster Methode

        this.handler = handler;

    }

    private void Render(Handler handler){      //Render Methode

        this.handler = handler;
        //level = new createLevel(title);

        handler.Update();

        testImage = ImageLoader.loadImage("/textures/Assets-pack/character and tileset/Dungeon_Character.png");

        tile = new Tileset(testImage);

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        Graphics2D g2 = (Graphics2D) g;

        g.setColor(Color.black);
        g.fillRect(0,0,1920,1800);


        g2.scale(5,5);

        g2.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

        g2.scale(0.2,0.2);

        handler.Render(g);

        g.dispose();
        bs.show();

    }

    public void run() {     //run Methode zum Fenster Updaten

        Graphics();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int ticks = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) /ns;
            lastTime = now;
            while(delta >= 1) {
                Update(handler);
                ticks++;
                delta--;
            }
            Render(handler);
            frames++;

            if (System.currentTimeMillis() - timer > 1000) { //optional
                System.out.println(ticks + " fps");
                timer += 1000;
                frames = 0;
                ticks = 0;
            }
        }
        stop();

    }

    public synchronized void start(){       //erstellen GameLoop (start)

        if(running)
            return;

        running =true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){        //GameLoop bedingt (stoppen)

        if(!running)
            return;
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
