package dev.oopjava.Display;

import dev.oopjava.Display.GameWindow;
import dev.oopjava.tileset.*;

import dev.oopjava.Level.*;

import dev.oopjava.Entitys.*;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private GameWindow display;        //Display Klasse erstellen
    private CreateLevel level;  //Level erstellen

    public int scale;       //breite, höhe
    public String title;            //Fenster Titel
    //private Canvas canvas;

    private boolean running = false;
    private boolean started = false;
    private Thread thread;      //Thread erstellen

    private BufferedImage testImage;
    private EntityControl entitys;
    private Tileset tile;
    private BufferStrategy bs;
    private Graphics g;
    private Graphics2D g2;
    private String character;
    public Handler handler;

    public Game(String title) {     //Game Methode erstellen
        this.title = title;

        scale = 5;

        handler = new Handler();
        character = "Priest1";
    }

    private void Graphics(){

        display = new GameWindow(title, handler);

        Assets.init();

        //entitys = new EntityControl(handler, character, scale);

        handler.addObject(new Player(0,0, 10, scale, ID.Player, handler));

    }

    private void Update(Handler handler){      //Update Fenster Methode

        this.handler = handler;

        handler.Update();

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        try {
            g = bs.getDrawGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.scale(scale,scale);
            level = new CreateLevel(g, handler, scale, started);
            started = true;
            g2.scale(1/scale,1/scale);
            handler.Render(g);
        } finally {
            g.dispose();
        }
        bs.show();
    }

    private void Render(Handler handler){      //Render Methode (In weiser Vorraussicht)

        this.handler = handler;
    }

    public void run() {     //run Methode zum Fenster Updaten

        Graphics();
        long lastTime = System.nanoTime();
        double amountOfTicks = 120.0;
        double amountOfTicks2 = 2400.0;
        double ns = 1000000000 / amountOfTicks;
        double ns2 = 1000000000 / amountOfTicks2;
        double delta = 0;
        double delta2 = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int ticks = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) /ns;
            delta2 += (now - lastTime) /ns2;
            lastTime = now;
            if(delta >= 1) {
                Update(handler);
                ticks++;
                delta--;
            }
            if(delta2 >= 1) {
                Render(handler);
                frames++;
                delta2--;
            }

            if (System.currentTimeMillis() - timer > 1000) { //optional
                System.out.println(ticks + " Update()");
                System.out.println(frames + " Render()");
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

        running = true;
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
