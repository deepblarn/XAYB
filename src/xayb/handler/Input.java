package xayb.handler;


import xayb.Game;
import xayb.MusicPlayer;
import xayb.coins.Coin;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

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
                if (key == KeyEvent.VK_A) coinPressed(1, 27);
                if (key == KeyEvent.VK_S) coinPressed(2, 48);
                if (key == KeyEvent.VK_D) coinPressed(3, 88);


                if (key == KeyEvent.VK_E){
                    Game.gameState = Game.STATE.Menu;
                    handler.clearObjects();

                }

            }

        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }






    }

    // TODO : coinpressed threading
    public void coinPressed(int type, int punt){
        int posy = 0;
        boolean fail = true;
        ArrayList<Integer> alt = new ArrayList<>();

            try {
                for (int j = 0; j < handler.object.size(); j++) {
                    GameObject tempObj2 = handler.object.get(j);

                    if (tempObj2.getId() == ID.Coin && tempObj2.getTypeCoin() == type){
                        posy = tempObj2.getY();
                    }
                }
                for (int k = 0; k < handler.object.size(); k++) {
                    GameObject tempObj3 = handler.object.get(k);

                    if (tempObj3.getId() == ID.Coin && posy == tempObj3.getY()){
                        handler.removeObject(tempObj3);
                        MusicPlayer player = new MusicPlayer("NFF-feed-2", false);
                        pool.addThread(player);
                        HUD.addScore(punt);
                        fail=false;
                    }
                }
                if (fail){
                    HUD.addFail();
                    MusicPlayer player = new MusicPlayer("NFF-robo-hit", false);
                    pool.addThread(player);
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
