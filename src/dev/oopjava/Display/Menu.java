package dev.oopjava.Display;
//Import package
import dev.oopjava.Display.GameWindow;
import dev.oopjava.Level.LEVELS;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Menu {

    private JFrame frame;       //erstellen Fenster

    private String title;       //erstellen Titel
    private Dimension dimensionWindow;
    private Dimension dimensionButtonRigidArea;
    private Dimension dimensionButtonSize;

    private JLabel panel;

    private JButton button1;
    private JButton button2;
    private JButton button3;


    public Menu(String title, int width, int height){    //Klasse Display zu erstellen einer Bildschirmabbildung
        this.title = title;     //Titel des Fensters
        this.dimensionWindow = new Dimension(width, height);
        this.dimensionButtonRigidArea = new Dimension(0,165);
        this.dimensionButtonSize = new Dimension(450,150);

        createDisplay();     //create Methode zum eigentlichen erstellen

    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(dimensionWindow);       //Fenstergröße width, height
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);      //Vollbild
        frame.setUndecorated(true);     //Window Toolbar aus
        frame.setResizable(false);      //Größe ändern aus
        frame.setLocationRelativeTo(null);      //Zentrieren
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Anwendung bei schließen komplett beenden

        JLabel label = null;
        try {
            URL url = new URL("https://i.pinimg.com/originals/e3/eb/31/e3eb311af2c90bd23b9b44d4c8353aa9.gif");
            label = new JLabel(new ImageIcon(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //panel = new JPanel();
        panel = label;
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.setSize(dimensionWindow);
        panel.setMinimumSize(dimensionWindow);
        panel.setMaximumSize(dimensionWindow);
        panel.setPreferredSize(dimensionWindow);

        button1 = new JButton("Spielen");
        button2 = new JButton("Level");
        button3 = new JButton("Beenden");

        button1.setFocusPainted(false);

        button1.setFont(new Font(button1.getFont().getName(), Font.PLAIN, 50));
        button2.setFont(new Font(button2.getFont().getName(), Font.PLAIN, 50));
        button3.setFont(new Font(button3.getFont().getName(), Font.PLAIN, 50));

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

        button1.setForeground(Color.decode("#09FF00"));
        button2.setForeground(Color.decode("#09FF00"));
        button3.setForeground(Color.decode("#09FF00"));

        button1.setBackground(Color.decode("000000"));
        button2.setBackground(Color.decode("000000"));
        button3.setBackground(Color.decode("000000"));

        // Action Listener auf Buttons machen
        button1.addActionListener(e -> {
            frame.dispose();
            //new GameWindow();
            Game game = new Game("Dungeons and Mi´s");
            game.start();
        });
        button2.addActionListener(e -> {
            createLevelSelection();
        });
        button3.addActionListener(e -> { //Lambda
            System.exit(0);
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);     // Display Fenster abbilden


    }

    private void createLevelSelection() {
        frame.remove(panel);
        //frame.setVisible(false);


        JLabel panel = null;
        try {
            URL url = new URL("https://i.pinimg.com/originals/e3/eb/31/e3eb311af2c90bd23b9b44d4c8353aa9.gif");
            panel = new JLabel(new ImageIcon(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);

        panel.setSize(dimensionWindow);
        panel.setMinimumSize(dimensionWindow);
        panel.setMaximumSize(dimensionWindow);
        panel.setPreferredSize(dimensionWindow);

        button1 = new JButton("Level1");
        button2 = new JButton("Level2");
        button3 = new JButton("Level3");

        button1.setFont(new Font(button1.getFont().getName(), Font.PLAIN, 50));
        button2.setFont(new Font(button2.getFont().getName(), Font.PLAIN, 50));
        button3.setFont(new Font(button3.getFont().getName(), Font.PLAIN, 50));

        button1.setForeground(Color.decode("#09FF00"));
        button2.setForeground(Color.decode("#09FF00"));
        button3.setForeground(Color.decode("#09FF00"));

        button1.setBackground(Color.decode("000000"));
        button2.setBackground(Color.decode("000000"));
        button3.setBackground(Color.decode("000000"));

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

        frame.add(panel);
        frame.revalidate();
        frame.repaint();

        button1.addActionListener(e -> {
            frame.dispose();
            Game game = new Game("Dungeons and Mi´s");
            game.start();
        });
        button2.addActionListener(e -> {
            frame.dispose();
            Game game = new Game("Dungeons and Mi´s");
            game.setLevel(LEVELS.LEVEL2);
            game.start();

        });
        button3.addActionListener(e -> {
            frame.dispose();
            Game game = new Game("Dungeons and Mi´s");
            game.setLevel(LEVELS.LEVEL3);
            game.start();
        });
    }

}
