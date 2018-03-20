package xayb.handler;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject{

    public Player(int x, int y, ID id){
        super(x, y, id);
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(0,0,100,100);
    }

}
