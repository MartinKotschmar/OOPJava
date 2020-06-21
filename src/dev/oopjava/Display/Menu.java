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
    public Dimension dimension;

    private JPanel panel;

    private Handler handler;


    public Menu(String title, Handler handler){    //Klasse Display zu erstellen einer Bildschirmabbildung
        this.title = title;     //Titel des Fensters
        this.handler = handler;
        createDisplay();     //create Methode zum eigentlichen erstellen

    }

    private void createDisplay(){

        Toolkit tk = Toolkit.getDefaultToolkit();
        int screenWidth = tk.getScreenSize().width;
        int screenHeight = tk.getScreenSize().height;

        dimension = new Dimension(screenWidth, screenHeight);

        frame = new JFrame(title);
        frame.setSize(dimension);       //Fenstergröße width, height
        frame.setLocationRelativeTo(null);      //Zentrieren
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
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
        canvas.addKeyListener(new KeyInput(handler));
        //Dimension dimension = frame.getSize();      // Dimension Size getter
        canvas.setPreferredSize(dimension);     //prefSize getSize
        canvas.setMinimumSize(dimension);       //min
        canvas.setMaximumSize(dimension);       //max
        panel.add(canvas);      // add Canvas für Grafik abbildung */


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);     // Display Fenster abbilden

    }


    public Canvas getCanvas() {
        return canvas;
    }

}
