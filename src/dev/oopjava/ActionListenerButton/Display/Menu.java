package dev.oopjava.ActionListenerButton.Display;
//Import package
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    private JFrame frame;       //erstellen Fenster
    private Canvas canvas;      //erstellen Canvas

    private String title;       //erstellen Titel
    private Dimension dimension;

    private JPanel panel;

    private JButton button1;
    private JButton button2;
    private JButton button3;


    public Menu(String title, int width, int height){    //Klasse Display zu erstellen einer Bildschirmabbildung
        this.title = title;     //Titel des Fensters
        this.dimension = new Dimension(width, height);

        creatDisplay();     //creat Methode zum eigentlichen erstellen

    }

    private void creatDisplay(){
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

        button1 = new JButton("Spielen");
        button2 = new JButton("Level");
        button3 = new JButton("Beenden");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        // panel.add(Box.create...)



        // Action Listener auf Buttons machen
        button1.addActionListener(e -> {

        });
        button2.addActionListener(e -> {

        });
        button3.addActionListener(e -> { //Lamda
            System.exit(0);
        });


       /* --> in GameWindow verschieben
       canvas = new Canvas();      //erstellen Hintergrund(Leinwand)
       Dimension dimension = frame.getSize();      // Dimension Size getter
       canvas.setPreferredSize(dimension);     //prefSize getSize
       canvas.setMinimumSize(dimension);       //min
       canvas.setMaximumSize(dimension);       //max
       canvas.add
       frame.add(canvas);      // add Canvas für Grafik abbildung */


        frame.add(panel);
        frame.pack();
        frame.setVisible(true);     // Display Fenster abbilden

    }

}
