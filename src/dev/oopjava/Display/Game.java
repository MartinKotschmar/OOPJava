package dev.oopjava.Display;

import dev.oopjava.tileset.*;
import dev.oopjava.Level.*;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Menu display;        //Display Klasse erstellen

    private createLevel level;  //Level erstellen


    public int width, height;       //breite, höhe
    public String title;            //Fenster Titel


    private boolean running = false;
    private Thread thread;      //Thread erstellen


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

    private void Render() {      //Render Methode (In weiser Vorraussicht)

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;

        }
        level = new createLevel();
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
