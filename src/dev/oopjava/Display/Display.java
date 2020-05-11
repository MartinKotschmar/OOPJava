package dev.oopjava.Display;
//Import package
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;

public class Display{

    private JFrame frame;
    private Canvas canvas;

    private String title;
      private int width, height;


    public Display(String title, int width, int height){
        this.title = title;
       this.width = width;
       this.height = height;

        creatDisplay();
    }

    private void creatDisplay(){
        frame = new JFrame(title);
        frame.setSize(1920,1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new Canvas();
        Dimension dimension = frame.getSize();
        canvas.setPreferredSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setMaximumSize(dimension);

        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

}