package xayb.handler;

import xayb.Game;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject{

    public Player(int x, int y, ID id){
        super(x, y, id);
    }

    @Override
    public void tick(){

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH-55);
        y = Game.clamp(y, 0, Game.HEIGHT-75);
    }

    @Override
    public void render(Graphics g){

        g.setColor(Color.blue);
        g.fillRect(x,y,50,50);
    }

}
