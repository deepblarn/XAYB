package xayb.coins;

import xayb.Game;
import xayb.MusicPlayer;
import xayb.handler.*;

import java.awt.*;
import java.util.Comparator;
import java.util.Iterator;

public class Coin extends GameObject {

    public static ThreadPool pool = new ThreadPool(2);
    private int type;
    public Coin(int x, int y, ID id, int type, int velx, int vely) {
        super(x, y, id);
        this.type=type;
        velX=velx;
        velY=vely;

    }

    @Override
    public void tick() {

        x += velX;
        y += velY;


        if (y > Game.HEIGHT-75){
             Game.handler.removeObject(this);
        }



        if (Game.isClamp(x, 0, Game.WIDTH - 74)) velX *= -1;
        if (Game.isClamp(y, 0, Game.HEIGHT - 74)) velY *= -1;

    }


    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLUE);
        Image img = Game.getImage("coin"+type);
        g.drawImage(img, x, y, null);

    }


}
