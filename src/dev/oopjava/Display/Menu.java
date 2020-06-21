package dev.oopjava.Display;
//Import package
import javax.swing.*;
import java.awt.*;

public class Menu {

    private JFrame frame;       //erstellen Fenster
    private Canvas canvas;      //erstellen Canvas

    private String title;       //erstellen Titel
    private Dimension dimension;

    public Canvas getCanvas() {
        return canvas;
    }

    private JPanel panel;


    public Menu(String title, int width, int height){    //Klasse Display zu erstellen einer Bildschirmabbildung
        this.title = title;     //Titel des Fensters
        this.dimension = new Dimension(width, height);

        createDisplay();     //create Methode zum eigentlichen erstellen

    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(dimension);       //Fenstergröße width, height
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
        frame.setUndecorated(true);     //
        frame.setResizable(false);      //Größe ändern aus
        frame.setLocationRelativeTo(null);      //Zentrieren
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Anwendung bei schließen komplett beenden


        panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.setSize(dimension);
        panel.setMinimumSize(dimension);
        panel.setMaximumSize(dimension);
        panel.setPreferredSize(dimension);


        panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));


        // panel.add(Box.create...)


       //--> in GameWindow verschieben
       canvas = new Canvas();      //erstellen Hintergrund(Leinwand)
       Dimension dimension = frame.getSize();      // Dimension Size getter
       canvas.setPreferredSize(dimension);     //prefSize getSize
       canvas.setMinimumSize(dimension);       //min
       canvas.setMaximumSize(dimension);       //max
       //canvas.add();
       frame.add(canvas);      // add Canvas für Grafik abbildung


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);     // Display Fenster abbilden

    }

}
