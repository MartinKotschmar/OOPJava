package dev.oopjava.ActionListenerButton.Display;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Button implements ActionListenerButton {       //Button Klasse erstellen u. implement ALB

    //Felder mit standart Werten
    private int x;
    private int y;
    private int width;
    private int height;

    private boolean enabled;        //Button aktivieren
    private boolean pressed;        //Button drücken

    private String text;        //Format festlegen
    private Font font = new Font("8 Bit Operator", Font.PLAIN,14);      //Schriftart und Größe
    private ActionListenerButton listenerButton;

    //Constructor
    public Button(ActionListener listener, String text, int x, int y, int width, int height){
        this.listenerButton = (ActionListenerButton) listener;
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        enabled = true;
    }

    public void ButtonRender(Graphics2D g){
        if(pressed){
            g.setColor(Color.BLACK);        //Farbe wenn gedrückt(vorläufig)
        } else{
            g.setColor(Color.BLUE);         //Farbe wenn gedrückt (vorläufig)
        }

        if(enabled){
            g.fillRect(x, y, width, height);        //Parameter Schrift
            g.setFont(font);        //Schriftfarbe
            g.setColor(Color.CYAN);         //festlegung Farbe
            int stringwidth = g.getFontMetrics().stringWidth(text);         //Button bedingung mit Schrift
            g.drawString(text, x +width / 2 -stringwidth / 2, y +height / 2);       //Button bedingung mit Schrift
        }
    }

    private boolean isPressed(int x, int y){        //Bedingung was wenn Button gedrückt
        return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
    }
    public void Click(MouseEvent e){        //if Case was wenn geclickt und true
        if(isPressed(e.getX(),e.getY())){
            pressed = true;
        }
    }
    public void mouseReleased(MouseEvent e){
        if(pressed && enabled) {
            listenerButton.actionPerformed((new ActionEventButton(this)));
            pressed = false;
        }
    }


    @Override
    public void actionPerformed(ActionEventButton e) {

    }
}
