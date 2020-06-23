package dev.oopjava.Entitys;

public class EntityControl {

    private String character;
    Handler handler;
    int scale;

    public EntityControl(Handler handler, String character, int scale){
        this.character = character;
        this.handler = handler;
        this.scale = scale;

        handler.addObject(new Player(0,0, 1, scale, ID.Player, handler));
    }

    public void Player() {

        if(character == "Priest1") {

            if(handler.isRight()) {

            }
        }else if(character == "Priest2") {

        }else if(character == "Priest3") {

        }
    }

}
