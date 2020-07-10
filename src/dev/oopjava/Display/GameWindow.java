package dev.oopjava.Display;

import dev.oopjava.Entitys.Handler;
import dev.oopjava.Entitys.KeyInput;

import javax.swing.*;
import java.awt.*;

public class GameWindow {

    public int width, height;       //breite, höhe
    public String title;            //Fenster Titel

    private JFrame gameFrame;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private void createDisplay() {
        gameFrame = new JFrame(title);
        gameFrame.setSize(dimensionWindow);       //Fenstergröße width, height
        gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
        gameFrame.setUndecorated(false);     //
        gameFrame.setResizable(false);      //Größe ändern aus
        gameFrame.setLocationRelativeTo(null);      //Zentrieren
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new JPanel();
        gamePanel.setSize(dimensionWindow);
        gamePanel.setMaximumSize(dimensionWindow);
        gamePanel.setMinimumSize(dimensionWindow);
        gamePanel.setPreferredSize(dimensionWindow);
        gamePanel.setFocusable(true);
        gamePanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        gameFrame.add(gamePanel);

        gameFrame.pack();
        gameFrame.setVisible(true);
        gameFrame.requestFocus();
        gamePanel.requestFocus();
    }

    public void createCanvas() {
        canvas = new Canvas(); //erstellen Hintergrund(Leinwand)

        Dimension dimension = gameFrame.getSize();      // Dimension Size getter
        canvas.addKeyListener(new KeyInput(handler));
        canvas.setPreferredSize(dimension);     //prefSize getSize
        canvas.setMinimumSize(dimension);       //min
        canvas.setMaximumSize(dimension);       //max
        gamePanel.add(canvas);      // add Canvas für Grafik abbildung
    }

    public Canvas getCanvas() {
        return canvas;
    }

}