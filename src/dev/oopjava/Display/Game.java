package dev.oopjava.Display;
import dev.oopjava.Display.Display;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    public Game(String title) {
        this.width = width;
        this.height = height;
        this.title =title;

    }

    private void Graphics(){
        display = new Display(title, 1980,1080);
    }

    private void Update(){

    }

    private void Render(){

    }

    public void run() {

        Graphics();
        while(running){
            Update();
            Render();
        }

        stop();

    }

    public synchronized void start(){

        if(running)
            return;

        running =true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){

        if(!running)
            return;
        running =false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
