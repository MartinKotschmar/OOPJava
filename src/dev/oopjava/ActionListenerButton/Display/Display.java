package dev.oopjava.ActionListenerButton.Display;
//Import package
import javax.swing.JFrame;
import java.awt.*;

public class Display{

    private JFrame frame;       //erstellen Fenster
    private Canvas canvas;      //erstellen Canvas

    private String title;       //erstellen Titel
    private int width, height;


    public Display(String title, int width, int height){    //Klasse Display zu erstellen einer Bildschirmabbildung
        this.title = title;     //Titel des Fensters
        this.width = width;      //Breite
        this.height = height;    //Höhe

        creatDisplay();     //creat Methode zum eigentlichen erstellen

    }

    private void creatDisplay(){
        frame = new JFrame(title);
        frame.setSize(1920,1080);       //Fenstergröße width, height
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
        frame.setUndecorated(true);     //
        frame.setResizable(false);      //Größe ändern aus
        frame.setLocationRelativeTo(null);      //Zentrieren
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Anwendung bei schließen komplett beenden

        canvas = new Canvas();      //erstellen Hintergrund(Leinwand)
        Dimension dimension = frame.getSize();      // Dimension Size getter
        canvas.setPreferredSize(dimension);     //prefSize getSize
        canvas.setMinimumSize(dimension);       //min
        canvas.setMaximumSize(dimension);       //max

        frame.add(canvas);      // add Canvas für Grafik abbildung
        frame.pack();
        frame.setVisible(true);     // Display Fenster abbilden
    }

}
