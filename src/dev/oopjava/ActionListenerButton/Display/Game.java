package dev.oopjava.ActionListenerButton.Display;
import java.awt.Button;
import java.awt.event.ActionListener;

public class Game implements Runnable {

    private dev.oopjava.ActionListenerButton.Display.Display display;        //Display Klasse erstellen
    public dev.oopjava.ActionListenerButton.Display.Button button;
    public int width, height;       //breite, höhe
    public String title;            //Fenster Titel

    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;

    private boolean running = false;
    private Thread thread;      //Thread erstellen

    public Game(String title) {     //Game Methode erstellen
        this.width = width;
        this.height = height;
        this.title =title;

    }

    private void Graphics(){

        display = new dev.oopjava.ActionListenerButton.Display.Display(title, 1980,1080);
        button1 = new java.awt.Button((ActionListener) this,"Spielen",300,100,100,40);
        button2 = new java.awt.Button((ActionListener) this,"Level auswählen du Arsch",300,100,100,40);
        button3 = new java.awt.Button((ActionListener) this,"Beenden",300,100,100,40);
    }

    private void Update(){      //Update Fenster Methode

    }

    private void Render(){      //Render Methode (In weiser Vorraussicht)

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
        running =false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        public void MenuRender(Graphics2D g){
            button1.button.ButtonRender(g);button2.ButtonRender(g);
            button3.ButtonRender(g);
        }

   /* public Game(){
        button1 = new Button((ActionListener) this,"Spielen",300,100,100,40);
        button2 = new Button((ActionListener) this,"Level auswählen du Arsch",300,100,100,40);
        button3 = new Button((ActionListener) this,"Beenden",300,100,100,40);
    } */

        public void Click(MouseEvent e){
            button1.Click(e);
            button2.Click(e);
            button3.Click(e);
        }

        public void mouseReleased(MouseEvent e){
            button1.mouseReleased(e);
            button2.mouseReleased(e);
            button3.mouseReleased(e);
        }
    }
