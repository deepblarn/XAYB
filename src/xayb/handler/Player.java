package xayb.handler;


import xayb.GUI.GameOver;
import xayb.Game;

import java.awt.Graphics;

import static xayb.Game.gameState;

public class Player extends GameObject {


    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {

        if(HUD.fails == 30){
            gameState = Game.STATE.GameOver;
            GameOver.count = 0;
        }
    }


    @Override
    public void render(Graphics g) {

    }


}
