package xayb.handler;


import xayb.Game;
import xayb.MusicPlayer;

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

                if (key == KeyEvent.VK_S){
                    new Thread(() -> coinPressed(ID.Coin)).start();
                }
                if (key == KeyEvent.VK_D) coinPressed(ID.Coin);
                if (key == KeyEvent.VK_A) coinPressed(ID.Coin);
                if (key == KeyEvent.VK_F) coinPressed(ID.Coin);


                if (key == KeyEvent.VK_E){
                    Game.gameState = Game.STATE.Menu;            handler.clearObjects();


                }

            }

        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }






    }

    // TODO : coinpressed threading
    public void coinPressed(ID id){
        int posy = 0;
        boolean fail = true;
        ArrayList<Integer> alt = new ArrayList<>();
        new Thread(() -> {
            try {
                for (int j = 0; j < handler.object.size(); j++) {
                    GameObject tempObj2 = handler.object.get(j);

                    if (tempObj2.getId() == ID.Coin){
                        alt.add(tempObj2.getY());
                    }
                }
                int limit = alt.size();
                int max = Integer.MIN_VALUE;
                int maxPos = -1;
                for (int i = 0; i < limit; i++) {
                    int value = alt.get(i);
                    if (value > max) {
                        max = value;
                        maxPos = i;
                    }
                }
                for (int i = 0; i < limit; i++) {
                    int value = alt.get(i);
                    if (value > max) {
                        max = value;
                        maxPos = i;
                    }
                }
                if (handler.object.size() > 2) handler.object.remove(maxPos+2);

                System.out.println(handler.object);

                if (fail){
                    MusicPlayer player = new MusicPlayer("NFF-robo-hit", false);
                    pool.addThread(player);
                    HUD.addFail();
                }
            }catch (Exception a){
                a.printStackTrace();
            }
        }).run();


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
