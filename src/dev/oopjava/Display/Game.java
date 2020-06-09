package dev.oopjava.Display;

import dev.oopjava.tileset.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Menu display;        //Display Klasse erstellen
    public int width, height;       //breite, höhe
    public String title;            //Fenster Titel


    private boolean running = false;
    private Thread thread;      //Thread erstellen


    private BufferedImage testImage;


    public Game(String title) {     //Game Methode erstellen
        this.width = width;
        this.height = height;
        this.title =title;

    }

    private void Graphics(){

        display = new Menu(title, 1980,1080);


    }

    private void Update(){      //Update Fenster Methode

    }

    private void Render(){      //Render Methode (In weiser Vorraussicht)

        testImage = ImageLoader.loadImage("/textures/Assets-pack/Dungeon_Tileset_at.png");

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.drawImage(testImage, 500, 500, null);

        g.dispose();
        bs.show();

    }

    public void run() {     //run Methode zum Fenster Updaten

        Graphics();
        while(running){
            Update();
            Render();
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
