package dev.oopjava.Level;

import dev.oopjava.Entitys.*;
import dev.oopjava.Display.*;

import java.awt.*;

public class CreateLevel {

    private SecondLevelBorder border2;
    private ThirdLevel border3;
    private FirstLevel border;
    Graphics g;
    Handler handler;
    Processing processing;
    Game game;
    WallGenerator wall;
    int scale, index, e;
    LEVELS activeLevel;

    public CreateLevel(Handler handler, int scale, int index, Processing processing) {
        this.handler = handler;
        this.scale = scale;
        this.index = index;
        this.processing = processing;
        activeLevel = LEVELS.LEVEL1;
    }

    public void Render(Graphics g){
        Color gameColor = Color.decode("#25131A");
        g.setColor(gameColor);
        g.fillRect(-1920 * 5,-1080 * 5,1920 * 10, 1080 * 10);
        g.setColor(Color.blue);
        g.fillRect(-1920,0,1920 *2,1080 * 5);
        //border = new Border(g, scale, index, 0, processing);
        //border = new Border(g, scale, index, 1, processing);
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(5,5);
        //g.drawImage(Assets.hara,150,160,null);
        //border = new MainBorder(5,1920,1080,1440,1080,480,756,960,1080, 1920,1080,scale,true,g);
        border2 = new SecondLevelBorder(4,480, 756,1440,1080,1440,1080,480,756,0,0, scale, true,g);
        //border3 = new Thirdlevel(5,1920,1080,480,752,1920,1080,480,752,1920,1320,scale,true,g);
        switch (activeLevel){
            case LEVEL1 -> new FirstLevel(5,1920,1080,1440,1080,480,756,scale,true,g);
            case LEVEL2 -> new SecondLevelBorder(4,480, 756,1440,1080,1440,1080,480,756,0,0, scale, true,g);
            case LEVEL3 -> new ThirdLevel(5,1920,1080,480,752,1920,1080,480,752,1920,1320,scale,true,g);
        }

        //
        //g2.drawImage(Assets.bones,0,0, null);
        //wall = new WallGenerator();480, 756,1440,1080
        //border = new FirstLevel(3,1920,1080,1440,1080,480,756,scale,true,g);
        //border2 = new SecondLevelBorder(4,480, 756,1440,1080,1440,1080,480,756, scale, true,g);
        //border3 = new ThirdLevel(5,1920,1080,480,752,1920,1080,480,752,1920,1320,scale,true,g);
        //g2.drawImage(Assets.bones,0,0, null);480, 756,1440,1080
        //wall = new WallGenerator();

        //1920, 1080, 1440, 1080, 480, 756
        //g2.scale(0.2,0.2);
    }

    public void setLevel(LEVELS level) {
        this.activeLevel = level;
    }
}