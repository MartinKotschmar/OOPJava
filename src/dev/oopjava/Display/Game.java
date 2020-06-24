package dev.oopjava.Display;

import dev.oopjava.Display.GameWindow;
import dev.oopjava.tileset.*;

import dev.oopjava.Level.*;

import dev.oopjava.Entitys.*;


import javax.swing.plaf.synth.SynthScrollBarUI;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private GameWindow display;        //Display Klasse erstellen
    private CreateLevel level;  //Level erstellen
    private Border border;

    public int scale, index;       //breite, höhe
    public double backscale;
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
    public Processing processing;

    public Game(String title) {     //Game Methode erstellen
        this.title = title;

        scale = 5;
        backscale = 1/scale;
        index = 0;

        handler = new Handler();
        processing = new Processing();
        character = "Priest1";
    }

    private void Graphics(){

        display = new GameWindow(title, handler);

        Assets.init();

        //entitys = new EntityControl(handler, character, scale);

        handler.addObject(new Player(80,80, 10, scale, ID.Player, handler));

    }

    private void Update(Handler handler){      //Update Fenster Methode

        this.handler = handler;

        handler.Update();
    }

    private void Render(Handler handler){      //Render Methode (In weiser Vorraussicht)

        this.handler = handler;
        handler.Update();

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;

            if(true) {
                g2.scale(scale,scale);
                level = new CreateLevel(g, handler, scale, index, processing);
            }
            g2.scale(0.2,0.2);
            handler.Render(g);

            g.dispose();
        bs.show();
        //index++;
        //System.out.println(processing.getX());
    }

    public void run() {     //run Methode zum Fenster Updaten

        Graphics();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double amountOfTicks2 = 600.0;
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
