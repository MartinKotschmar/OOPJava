package dev.oopjava.Display;
//Import package
import dev.oopjava.Entitys.Handler;
import dev.oopjava.Entitys.ID;
import dev.oopjava.Entitys.KeyInput;
import dev.oopjava.Entitys.Player;
import dev.oopjava.tileset.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Menu {

    private JFrame frame;       //erstellen Fenster
    private Canvas canvas;      //erstellen Canvas

    private String title;       //erstellen Titel
    private Dimension dimension;

    private Dimension scaling;

    private JPanel panel;

    public Handler handler;

    public Menu(String title, int width, int height, int scale){    //Klasse Display zu erstellen einer Bildschirmabbildung
        this.title = title;     //Titel des Fensters
        this.dimension = new Dimension(width, height);
        this.scaling = new Dimension(width * scale, height * scale);

        createDisplay();     //create Methode zum eigentlichen erstellen

    }

    private void createDisplay(){

       // handler = new Handler();

        frame = new JFrame(title);
        frame.setSize(dimension);       //Fenstergröße width, height
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
        frame.setLocationRelativeTo(null);      //Zentrieren
        frame.setUndecorated(false);     //Window Toolbar aus
        frame.setResizable(false);      //Größe ändern aus
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Anwendung bei schließen komplett beenden


        panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.setSize(dimension);
        panel.setMinimumSize(dimension);
        panel.setMaximumSize(dimension);
        panel.setPreferredSize(dimension);
        panel.setFocusable(true);
        panel.requestFocusInWindow();


        panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));



        // in GameWindow verschieben
        canvas = new Canvas();      //erstellen Hintergrund(Leinwand)
        //Dimension dimension = frame.getSize();      // Dimension Size getter
        canvas.setPreferredSize(scaling);     //prefSize getSize
        canvas.setMinimumSize(scaling);       //min
        canvas.setMaximumSize(scaling);       //max
        panel.add(canvas);      // add Canvas für Grafik abbildung */


        frame.add(panel);
        //canvas.addKeyListener(new KeyInput(handler));
        frame.pack();
        frame.setVisible(true);     // Display Fenster abbilden

    }


    public Canvas getCanvas() {
        return canvas;
    }

}
