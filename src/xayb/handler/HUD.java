package xayb.handler;

import xayb.Game;

import java.awt.*;

public class HUD extends GameObject{

    private static int fails = 0;
    private static int score = 0;
    public HUD(int x, int y, ID id){
        super(x, y, id);
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){

        g.setColor(Color.WHITE);
        g.drawString("Fails: " + fails, 10,10);
        g.drawString("Score: " + score, 10,25);
        g.drawRect(0,Game.HEIGHT - 50, 100, 100);

    }

    public static void addFail(){
        fails++;
    }

    public static void addScore(int added){
        score+=added;
    }
}
