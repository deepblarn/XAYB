package xayb.handler;


import xayb.Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter{

    private Handler handler;

    public Input(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObj = handler.object.get(i);

            if (tempObj.getId() == ID.Player){

                if (key == KeyEvent.VK_W) tempObj.setVelY(-5);
                if (key == KeyEvent.VK_S) tempObj.setVelY(5);
                if (key == KeyEvent.VK_D) tempObj.setVelX(5);
                if (key == KeyEvent.VK_A) tempObj.setVelX(-5);
                if (key == KeyEvent.VK_F) handler.removeObject(tempObj);


            }

        }

        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
        if (key == KeyEvent.VK_E) Game.gameState = Game.STATE.Menu;


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
