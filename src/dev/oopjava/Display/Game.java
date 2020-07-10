package dev.oopjava.Display;

import dev.oopjava.tileset.*;
import dev.oopjava.Level.*;
import dev.oopjava.Entitys.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

public class Game implements Runnable {

    private Randomizer randomizer;
    private GameWindow display;        //Display Klasse erstellen
    private CreateLevel level;  //Level erstellen
    private Skeleton enemy;
    private Player player;

    public int scale, index;       //Breite, Höhe
    public double backscale;
    public String title;            //Fenster Titel
    long Timer;

    private boolean running = false;
    private boolean started = false;
    private Thread thread;      //Thread erstellen

    //private EntityControl entitys;
    private BufferStrategy bs;
    private Graphics g;
    private String character;
    public Handler handler;
    public Processing processing;
    public Camera camera;
    private GateWay gateWay;

    public Game(String title) {     //Game Methode erstellen
        this.title = title;

        scale = 5;
        backscale = 1/scale;
        index = 0;
        Timer = System.currentTimeMillis();

        handler = new Handler(this);
        camera = new Camera(this,0 ,0);
        character = "Priest1";
        level = new CreateLevel(handler, scale, index, processing);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    private void Graphics(){

        display = new GameWindow(title, handler);

        randomizer = new Randomizer();

        Assets.init();

        player = new Player(1920/10,1080/10, 10, scale, ID.Player, handler);
        handler.addObject(player);

        gateWay = new GateWay(175, 1040, 0, null, handler);
        handler.addObject(gateWay);
        handler.addCollidableObject(gateWay);

        enemy = new Skeleton(32,32, 1, scale, ID.Skeleton, handler);
        enemy.setMove(true, 100);
        handler.addObject(enemy);
        handler.addCollidableObject(enemy);

        Boss boss = new Boss(64,64,2,scale,ID.Boss, handler);
        handler.addObject(boss);
        handler.addCollidableObject(boss);
    }

    private void Update(Handler handler){      //Update Fenster Methode

        this.handler = handler;

        for(int i = 0; i < handler.getObject().size(); i++) {
            if(handler.getObject().get(i).getId() == ID.Player) {
                camera.centerOnEntity(handler.getObject().get(i));
            }
        }

        handler.Update();

       //this.getCamera().move(1,1);

    }

    private void Render(Handler handler){      //Render Methode (In weiser Vorraussicht)

        this.handler = handler;

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(-camera.getX(), -camera.getY());

        level.Render(g);
        //g.drawImage(Assets.hara,200,100,null);
        //g2.scale(0.2,0.2);

        handler.Render(g);
        g2.translate(camera.getX(), camera.getY());

        //enemy.Render(g, Timer);
        g.dispose();
        bs.show();

    }

    public void run() {     //run Methode zum Fenster Updaten

        Graphics();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double amountOfTicks2 = 180;
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

    public void setLevel(LEVELS level) {
        //TODO CHECK WHICH LEVEL
        //player.tp(1920/10,1080/10);

        this.level.setLevel(level);
    }
}
