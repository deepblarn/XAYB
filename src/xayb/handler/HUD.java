package xayb.handler;

import xayb.Game;

import java.awt.*;

public class HUD extends GameObject{

    public static int fails = 0;
    public static int score = 0;
    public HUD(int x, int y, ID id){
        super(x, y, id);
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){

        g.setColor(Color.WHITE);
        g.drawString("Fails: " + fails, 10,20);
        g.drawString("Score: " + score, 10,35);

    }

    public static void addFail(){
        fails++;
    }

    public static void addScore(int added){
        score+=added;
    }
}
