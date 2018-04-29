package xayb.handler;


import xayb.Game;
import xayb.MusicPlayer;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter{

    private Handler handler;
    public static ThreadPool pool = new ThreadPool(2);

    public Input(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for (int i = 0; i < Game.handler.object.size(); i++) {
            GameObject tempObj = handler.object.get(i);

            if (tempObj.getId() == ID.Player){

                if (key == KeyEvent.VK_S) coinPressed(ID.BlackCoin);
                else if (key == KeyEvent.VK_D) coinPressed(ID.GreenCoin);
                else if (key == KeyEvent.VK_A) coinPressed(ID.RedCoin);
                else if (key == KeyEvent.VK_F) coinPressed(ID.BlueCoin);


                if (key == KeyEvent.VK_E){
                    Game.gameState = Game.STATE.Menu;
                }

            }

        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
            Game.stop();
        }






    }

    public void coinPressed(ID id){
        int posy = 0;
        boolean fail = true;
        try {
            for (int j = 0; j < handler.object.size(); j++) {
                GameObject tempObj2 = handler.object.get(j);

                if (tempObj2.getId() == id && tempObj2.getY() >= posy){
                    posy=tempObj2.getY();

                }
            }
            for (int k = 0; k < handler.object.size(); k++) {
                GameObject tempObj3 = handler.object.get(k);

                if (tempObj3.id == id && tempObj3.getY() == posy) {
                    handler.object.remove(tempObj3);
                    MusicPlayer player = new MusicPlayer("NFF-feed-2", false);
                    pool.addThread(player);
                    HUD.addScore(50);
                    fail=false;
                }
            }

            if (fail){
                MusicPlayer player = new MusicPlayer("NFF-robo-hit", false);
                pool.addThread(player);
                HUD.addFail();
            }
        }catch (Exception a){
            a.printStackTrace();
        }

    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObj = handler.object.get(i);

            if (tempObj.getId() == ID.Player){

                if (key == KeyEvent.VK_W) tempObj.setVelY(0);
                if (key == KeyEvent.VK_S) tempObj.setVelY(0);
                if (key == KeyEvent.VK_D) tempObj.setVelX(0);
                if (key == KeyEvent.VK_A) tempObj.setVelX(0);
            }

        }
    }



}
