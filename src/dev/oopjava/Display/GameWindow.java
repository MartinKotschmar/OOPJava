package dev.oopjava.Display;

import dev.oopjava.Entitys.Handler;
import dev.oopjava.Entitys.KeyInput;

import javax.swing.*;
import java.awt.*;

public class GameWindow {

    public int width, height;       //breite, höhe
    public String title;            //Fenster Titel

    private JFrame GameFrame;
    private JPanel gamePanel;
    private Handler handler;
    private Dimension dimensionWindow;

    private Canvas canvas;

    public GameWindow(String title, Handler handler) {
        this.width = 1920;
        this.height = 1080;
        this.dimensionWindow = new Dimension(width, height);
        this.handler = handler;

        createDisplay();
        createCanvas();

    }

    private void createDisplay() {
        GameFrame = new JFrame(title);
        GameFrame.setSize(dimensionWindow);       //Fenstergröße width, height
        GameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
        GameFrame.setUndecorated(false);     //
        GameFrame.setResizable(false);      //Größe ändern aus
        GameFrame.setLocationRelativeTo(null);      //Zentrieren
        GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new JPanel();
        gamePanel.setSize(dimensionWindow);
        gamePanel.setMaximumSize(dimensionWindow);
        gamePanel.setMinimumSize(dimensionWindow);
        gamePanel.setPreferredSize(dimensionWindow);
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
        gamePanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        GameFrame.add(gamePanel);

        GameFrame.pack();
        GameFrame.setVisible(true);

    }



    public void createCanvas() {
        canvas = new Canvas(); //erstellen Hintergrund(Leinwand)

        Dimension dimension = GameFrame.getSize();      // Dimension Size getter
        canvas.addKeyListener(new KeyInput(handler));
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