package xayb.handler;

import xayb.Game;
import xayb.coins.Coin;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static xayb.Game.gameState;

public class HUD extends GameObject{

    public static int fails = 0;
    public static int score = 0;
    private Timer t;
    public HUD(int x, int y, ID id){
        super(x, y, id);
    }

    @Override
    public void tick(){

        if (fails == 30){
            gameState = Game.STATE.GameOver;
        }

    }

    @Override
    public void render(Graphics g){
        g.setFont(new Font("default", Font.BOLD, 16));
        g.setColor(Color.WHITE);
        g.drawString("Fails: " + fails, 10,20);
        g.drawString("Score: " + score, 10,35);
        g.drawString("FPS: " + Game.FPS, 10,50);

    }

    public static void addFail(){
        fails++;
    }

    public static void addScore(int added){
        score+=added;
    }
}
