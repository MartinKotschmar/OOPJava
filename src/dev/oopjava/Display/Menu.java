package dev.oopjava.Display;
//Import package
import dev.oopjava.Display.GameWindow;

import javax.swing.*;
import java.awt.*;

public class Menu {

    private JFrame frame;       //erstellen Fenster

    private String title;       //erstellen Titel
    private Dimension dimensionWindow;
    private Dimension dimensionButtonRigidArea;
    private Dimension dimensionButtonSize;

    private JPanel panel;

    private JButton button1;
    private JButton button2;
    private JButton button3;


    public Menu(String title, int width, int height){    //Klasse Display zu erstellen einer Bildschirmabbildung
        this.title = title;     //Titel des Fensters
        this.dimensionWindow = new Dimension(width, height);
        this.dimensionButtonRigidArea = new Dimension(0,65);
        this.dimensionButtonSize = new Dimension(900,250);

        createDisplay();     //create Methode zum eigentlichen erstellen

    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(dimensionWindow);       //Fenstergröße width, height
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
        frame.setUndecorated(true);     //
        frame.setResizable(false);      //Größe ändern aus
        frame.setLocationRelativeTo(null);      //Zentrieren
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Anwendung bei schließen komplett beenden


        panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.setSize(dimensionWindow);
        panel.setMinimumSize(dimensionWindow);
        panel.setMaximumSize(dimensionWindow);
        panel.setPreferredSize(dimensionWindow);

        button1 = new JButton("Spielen");
        button2 = new JButton("Level");
        button3 = new JButton("Beenden");

        panel.add(Box.createVerticalGlue()); //Platz nach unten

        button1.setMinimumSize(dimensionButtonSize);
        button1.setMaximumSize(dimensionButtonSize);
        panel.add(button1);
        panel.add(Box.createRigidArea(dimensionButtonRigidArea)); //Rigid Area Platzhalter
        button2.setMinimumSize(dimensionButtonSize);
        button2.setMaximumSize(dimensionButtonSize);
        panel.add(button2);
        panel.add(Box.createRigidArea(dimensionButtonRigidArea)); // Rigid Area Platzhalter
        button3.setMinimumSize(dimensionButtonSize);
        button3.setMaximumSize(dimensionButtonSize);
        panel.add(button3);

        panel.add(Box.createVerticalGlue()); //Platz nach oben

        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Action Listener auf Buttons machen
        button1.addActionListener(e -> {
            frame.dispose();
            //new GameWindow();
            Game game = new Game("Dungeons and Mi´s");
            game.start();
        });
        button2.addActionListener(e -> {

        });
        button3.addActionListener(e -> { //Lamda
            System.exit(0);
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);     // Display Fenster abbilden

    }

}
