package dev.oopjava.Display;

import dev.oopjava.tileset.*;
import dev.oopjava.Entitys.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Game implements Runnable {

    private Menu display;        //Display Klasse erstellen
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

        display = new Menu(title, handler);

        Assets.init();

        handler.addObject(new Player(0,0, 1, ID.Player, handler));
         /*handler = new Handler();

        handler.addObject(new Player(0,0, ID.Player, handler)); */
    }

    private void Update(Handler handler){      //Update Fenster Methode

        this.handler = handler;

        handler.Update();
    }

    private void Render(Handler handler){      //Render Methode (In weiser Vorraussicht)

        this.handler = handler;

        testImage = ImageLoader.loadImage("/textures/Assets-pack/character and tileset/Dungeon_Character.png");

        tile = new Tileset(testImage);

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        Graphics2D g2 = (Graphics2D) g;


        if( 1 == 1 ) {
            g2.scale(5,5);

            g2.setRenderingHint(
                    RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

            //Linke Grenzen
            g2.drawImage(Assets.cornerLT, 0, 0, null);
            g2.drawImage(Assets.cornerLT, 0, 16, null);
            g2.drawImage(Assets.cornerLT, 0, 32, null);
            g2.drawImage(Assets.cornerLT, 0, 48, null);
            g2.drawImage(Assets.cornerLT, 0, 64, null);
            g2.drawImage(Assets.cornerLT, 0, 80, null);
            g2.drawImage(Assets.cornerLT, 0, 96, null);
            g2.drawImage(Assets.cornerLT, 0, 112, null);
            g2.drawImage(Assets.cornerLT, 0, 128, null);
            g2.drawImage(Assets.cornerLB, 0, 144, null);
            //Rechte Grenzen
            g2.drawImage(Assets.cornerRT, 272, 0, null);
            g2.drawImage(Assets.cornerRT, 272, 16, null);
            g2.drawImage(Assets.cornerRT, 272, 32, null);
            g2.drawImage(Assets.cornerRT, 272, 48, null);
            g2.drawImage(Assets.cornerRT, 272, 64, null);
            g2.drawImage(Assets.cornerRT, 272, 80, null);
            g2.drawImage(Assets.cornerRT, 272, 96, null);
            g2.drawImage(Assets.cornerRT, 272, 112, null);
            g2.drawImage(Assets.cornerRT, 272, 128, null);
            g2.drawImage(Assets.cornerRB, 272, 144, null);
            //Obere Grenze
            g2.drawImage(Assets.wallTop1, 16, 0, null);
            g2.drawImage(Assets.wallTop3, 32, 0, null);
            g2.drawImage(Assets.wallTop2, 48, 0, null);
            g2.drawImage(Assets.wallTop1, 64, 0, null);
            g2.drawImage(Assets.wallTop3, 80, 0, null);
            g2.drawImage(Assets.wallTop2, 96, 0, null);
            g2.drawImage(Assets.wallTop1, 112, 0, null);
            g2.drawImage(Assets.wallTop3, 128, 0, null);
            g2.drawImage(Assets.wallTop2, 144, 0, null);
            g2.drawImage(Assets.wallTop1, 160, 0, null);
            g2.drawImage(Assets.wallTop1, 176, 0, null);
            g2.drawImage(Assets.wallTop2, 192, 0, null);
            g2.drawImage(Assets.wallTop3, 208, 0, null);
            g2.drawImage(Assets.wallTop3, 224, 0, null);
            g2.drawImage(Assets.wallTop2, 240, 0, null);
            g2.drawImage(Assets.wallTop2, 256, 0, null);
            //Untere Grenze
            g2.drawImage(Assets.wallDown1, 16, 144, null);
            g2.drawImage(Assets.wallDown2, 32, 144, null);
            g2.drawImage(Assets.wallDown2, 48, 144, null);
            g2.drawImage(Assets.wallDown1, 64, 144, null);
            g2.drawImage(Assets.wallDown1, 80, 144, null);
            g2.drawImage(Assets.wallDown2, 96, 144, null);
            g2.drawImage(Assets.wallDown1, 112, 144, null);
            g2.drawImage(Assets.wallDown2, 128, 144, null);
            g2.drawImage(Assets.wallDown2, 144, 144, null);
            g2.drawImage(Assets.wallDown1, 160, 144, null);
            g2.drawImage(Assets.wallDown1, 176, 144, null);
            g2.drawImage(Assets.wallDown2, 192, 144, null);
            g2.drawImage(Assets.wallDown1, 208, 144, null);
            g2.drawImage(Assets.wallDown1, 224, 144, null);
            g2.drawImage(Assets.wallDown2, 240, 144, null);
            g2.drawImage(Assets.wallDown1, 256, 144, null);
            //Boden
            g2.drawImage(Assets.floor4x3, 16, 16, null);
            g2.drawImage(Assets.floor4x3, 80, 16, null);
            g2.drawImage(Assets.floor4x3, 144, 16, null);
            g2.drawImage(Assets.floor4x3, 208, 16, null);

            g2.drawImage(Assets.floor3x3, 16, 64, null);
            g2.drawImage(Assets.floor3x3, 80, 64, null);
            g2.drawImage(Assets.floor3x3, 144, 64, null);
            g2.drawImage(Assets.floor3x3, 208, 64, null);


            g2.drawImage(Assets.floor4x3, 16, 96, null);
            g2.drawImage(Assets.floor4x3, 80, 96, null);
            g2.drawImage(Assets.floor4x3, 144, 96, null);
            g2.drawImage(Assets.floor4x3, 208, 96, null);




            //Charakter
            //g2.drawImage(Assets.char1, 16, 16, null); --> wurde in Player.java ausgelagert

        }

        g2.scale(0.2,0.2);

        handler.Render(g);

        g.dispose();
        bs.show();


    }

    public void run() {     //run Methode zum Fenster Updaten

   /*     Graphics();
        while(running){
            Update();
            Render();
        }

        stop(); */

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

            if (System.currentTimeMillis() - timer > 1000) {
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
