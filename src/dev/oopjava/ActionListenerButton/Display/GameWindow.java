package dev.oopjava.ActionListenerButton.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameWindow implements Runnable {

    public int width, height;       //breite, höhe
    public String title;            //Fenster Titel

    private boolean running = false;
    private Thread thread;      //Thread erstellen

    private JFrame GameFrame;
    private JPanel gamePanel;
    private Dimension dimensionWindow;

    private BufferStrategy  bs;
    private Graphics g;
    private Canvas canvas;

    public GameWindow() {
        this.width = 1920;
        this.height = 1080;
        this.dimensionWindow = new Dimension(width, height);

        creatDisplay();
        creatCanvas();
        start();
    }

    private void creatDisplay() {
        GameFrame = new JFrame(title);
        GameFrame.setSize(dimensionWindow);       //Fenstergröße width, height
        GameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
        GameFrame.setUndecorated(true);     //
        GameFrame.setResizable(false);      //Größe ändern aus
        GameFrame.setLocationRelativeTo(null);      //Zentrieren
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new JPanel();
        gamePanel.setSize(dimensionWindow);
        gamePanel.setMaximumSize(dimensionWindow);
        gamePanel.setMinimumSize(dimensionWindow);
        gamePanel.setPreferredSize(dimensionWindow);
        GameFrame.add(gamePanel);

        GameFrame.pack();
        GameFrame.setVisible(true);

    }

    private void Graphics(){

    }

    private void Update(){      //Update Fenster Methode

    }

    private void Render(){      //Render Methode
        bs = getCanvas().getBufferStrategy();
        if(bs == null){
            getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Assets hier
        g.clearRect(0,0,width,height);
        
        //Test
        g.fillRect(0,0,width,height);


        //Assets ende
        bs.show();
        g.dispose();
    }

    public void run(){     //run Methode zum Fenster Updaten

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
        thread = new Thread( this);
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
    }

    public void creatCanvas() {
        canvas = new Canvas(); //erstellen Hintergrund(Leinwand)

        Dimension dimension = GameFrame.getSize();      // Dimension Size getter
        canvas.setPreferredSize(dimension);     //prefSize getSize
        canvas.setMinimumSize(dimension);       //min
        canvas.setMaximumSize(dimension);       //max
            //canvas.add();
        gamePanel.add(canvas);      // add Canvas für Grafik abbildung
    }

    public Canvas getCanvas() {
        return canvas;
    }
}