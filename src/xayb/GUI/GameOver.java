package xayb.GUI;


import xayb.Game;
import xayb.handler.Handler;
import xayb.handler.ThreadPool;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import static xayb.Game.*;

public class GameOver{


    private Timer t;
    public static int count;


    public void tick(){
        if (t == null){
            t = new Timer();

            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    count ++;
                    if (count == 2){
                        gameState = STATE.Menu;
                    }
                }
            }, 0, 3000);
        }
    }

    public void render(Graphics g){


        g.drawImage(Game.gameover, 0, 0, WIDTH, HEIGHT,null);



    }


}
