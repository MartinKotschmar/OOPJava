package dev.oopjava.Level;

import dev.oopjava.Entitys.*;

import java.awt.*;

public class CreateLevel {

    Handler handler;
    Processing processing;
    int scale, index, e;
    LEVELS activeLevel;

    public CreateLevel(Handler handler, int scale, int index, Processing processing) {
        this.handler = handler;
        this.scale = scale;
        this.index = index;
        this.processing = processing;
        activeLevel = LEVELS.LEVEL1;
        initiateLevelObjects(activeLevel);
    }

    public void Render(Graphics g) {
        Color gameColor = Color.decode("#25131A");
        g.setColor(gameColor);
        g.fillRect(-1920 * 5, -1080 * 5, 1920 * 10, 1080 * 10);
        g.setColor(Color.blue);
        g.fillRect(-1920, 0, 1920 * 2, 1080 * 5);
        Graphics2D g2 = (Graphics2D) g;
        g2.scale(5, 5);
        switch (activeLevel) {
            case LEVEL1 -> new FirstLevel(5, 1920, 1080, 1440, 1080, 480, 756, scale, true, g);
            case LEVEL2 -> new SecondLevelBorder(4, 480, 756, 1440, 1080, 1440, 1080, 480, 756, 0, 0, scale, true, g);
            case LEVEL3 -> new ThirdLevel(5, 1920, 1080, 480, 752, 1920, 1080, 480, 752, 1920, 1320, scale, true, g);
        }
    }

    public void setLevel(LEVELS level) {
        this.activeLevel = level;
        initiateLevelObjects(level);
    }

    private void initiateLevelObjects(LEVELS activeLevel) {
        handler.resetObjects();

        switch (activeLevel) {
            case LEVEL1 -> level1Objects();
            case LEVEL2 -> level2Objects();
            case LEVEL3 -> level3Objects();
        }
    }

    private void level1Objects() {
        GateWay gateWay = new GateWay(180, 0, 0, null, handler);
        gateWay.setDestination(LEVELS.LEVEL1);
        handler.addObject(gateWay);
        handler.addCollidableObject(gateWay);

        GateWay gateWay2 = new GateWay(180, 589, 0, null, handler);
        gateWay2.setDestination(LEVELS.LEVEL2);
        handler.addObject(gateWay2);
        handler.addCollidableObject(gateWay2);

        Skeleton skeleton1 = new Skeleton(143, 169, 1, scale, ID.Skeleton, handler);
        skeleton1.setMove(true, 80);
        handler.addObject(skeleton1);
        handler.addCollidableObject(skeleton1);

        Skeleton skeleton2 = new Skeleton(93, 259, 1, scale, ID.Skeleton, handler);
        skeleton2.setMove(true, 180);
        handler.addObject(skeleton2);
        handler.addCollidableObject(skeleton2);

        Skeleton skeleton3 = new Skeleton(123, 389, 1, scale, ID.Skeleton, handler);
        skeleton3.setMove(true, 180);
        handler.addObject(skeleton3);
        handler.addCollidableObject(skeleton3);

        Skeleton skeleton4 = new Skeleton(183, 479, 1, scale, ID.Skeleton, handler);
        skeleton4.setMove(false, 80);
        handler.addObject(skeleton4);
        handler.addCollidableObject(skeleton4);

    }

    private void level2Objects() {
        GateWay gateWay = new GateWay(182, 0, 0, null, handler);
        gateWay.setDestination(LEVELS.LEVEL1);
        handler.addObject(gateWay);
        handler.addCollidableObject(gateWay);

        GateWay gateWay2 = new GateWay(180, 749, 0, null, handler);
        gateWay2.setDestination(LEVELS.LEVEL3);
        handler.addObject(gateWay2);
        handler.addCollidableObject(gateWay2);

        Skeleton skeleton1 = new Skeleton(123, 189, 1, scale, ID.Skeleton, handler);
        skeleton1.setMove(true, 130);
        handler.addObject(skeleton1);
        handler.addCollidableObject(skeleton1);

        Skeleton skeleton2 = new Skeleton(103, 309, 1, scale, ID.Skeleton, handler);
        skeleton2.setMove(true, 150);
        handler.addObject(skeleton2);
        handler.addCollidableObject(skeleton2);

        Skeleton skeleton3 = new Skeleton(113, 419, 1, scale, ID.Skeleton, handler);
        skeleton3.setMove(true, 150);
        handler.addObject(skeleton3);
        handler.addCollidableObject(skeleton3);

        Skeleton skeleton4 = new Skeleton(83, 529, 1, scale, ID.Skeleton, handler);
        skeleton4.setMove(true, 180);
        handler.addObject(skeleton4);
        handler.addCollidableObject(skeleton4);

        Skeleton skeleton5 = new Skeleton(183, 629, 1, scale, ID.Skeleton, handler);
        skeleton5.setMove(false, 100);
        handler.addObject(skeleton5);
        handler.addCollidableObject(skeleton5);
    }

    private void level3Objects() {
        GateWay gateWay = new GateWay(180, 0, 0, null, handler);
        gateWay.setDestination(LEVELS.LEVEL2);
        handler.addObject(gateWay);
        handler.addCollidableObject(gateWay);

        GateWay gateWay2 = new GateWay(183, 1022, 0, null, handler);
        gateWay2.setDestination(LEVELS.LEVEL3);
        handler.addObject(gateWay2);
        handler.addCollidableObject(gateWay2);

        Skeleton skeleton1 = new Skeleton(140, 170, 1, scale, ID.Skeleton, handler);
        skeleton1.setMove(true, 120);
        handler.addObject(skeleton1);
        handler.addCollidableObject(skeleton1);

        Skeleton skeleton2 = new Skeleton(183, 249, 1, scale, ID.Skeleton, handler);
        skeleton2.setMove(false, 100);
        handler.addObject(skeleton2);
        handler.addCollidableObject(skeleton2);

        Skeleton skeleton3 = new Skeleton(123, 409, 1, scale, ID.Skeleton, handler);
        skeleton3.setMove(true, 140);
        handler.addObject(skeleton3);
        handler.addCollidableObject(skeleton3);

        Skeleton Skeleton4 = new Skeleton(123, 549, 1, scale, ID.Skeleton, handler);
        Skeleton4.setMove(true, 140);
        handler.addObject(Skeleton4);
        handler.addCollidableObject(Skeleton4);

        Skeleton skeleton5 = new Skeleton(183, 629, 1, scale, ID.Skeleton, handler);
        skeleton5.setMove(false, 90);
        handler.addObject(skeleton5);
        handler.addCollidableObject(skeleton5);

        Skeleton Skeleton6 = new Skeleton(143, 809, 1, scale, ID.Skeleton, handler);
        Skeleton6.setMove(true, 80);
        handler.addObject(Skeleton6);
        handler.addCollidableObject(Skeleton6);

        Skeleton Skeleton7 = new Skeleton(43, 879, 1, scale, ID.Skeleton, handler);
        Skeleton7.setMove(true, 180);
        handler.addObject(Skeleton7);
        handler.addCollidableObject(Skeleton7);


        Boss boss = new Boss(123, 929, 2, scale, ID.Boss, handler);
        handler.addObject(boss);
        handler.addCollidableObject(boss);
    }
}
