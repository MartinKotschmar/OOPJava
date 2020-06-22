package dev.oopjava.Entitys;

import dev.oopjava.tileset.Assets;
import dev.oopjava.tileset.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends ObjectSettings{

    private CharacterAnimation animation;

    Handler handler;
    private Image img;
    String image;

    public Player(int x, int y, double speed, ID id, Handler handler){
        super(x, y, speed, id);
        this.handler = handler;

        animation = new CharacterAnimation(500, Assets.priest1v1);
        /*image = "C:/Users/marti/Documents/BA/2. Semester/OOP/Java/TopDown/OOPJava/res/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest_v1_1.png";

        try {
            img = ImageIO.read(new File(image));
        } catch (IOException e) {
            e.printStackTrace();

        }

            do {
            image = "C:/Users/marti/Documents/BA/2. Semester/OOP/Java/TopDown/OOPJava/res/textures/Assets-pack/Character_animation/priests_idle/priest1/v1/priest_v1_1.png";
        }    while(!handler.isRight());

         */
    }

    public void Update() {
        x += velX;
        y += velY;

        animation.tick();

        if (handler.isUp()) velY = -speed;
        else if (!handler.isDown()) velY = 0;

        if (handler.isDown()) velY = speed;
        else if (!handler.isUp()) velY = 0;

        if (handler.isLeft()) velX = -speed;
        else if (!handler.isRight()) velX = 0;

        if (handler.isRight()) velX = speed;
        else if (!handler.isLeft()) velX = 0;
    }

    public void Render(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.scale(5,5);

        g.drawImage(animation.getTiles(),x,y, null);

    }

    public Rectangle getBounds() {
        return null;
    }
}
