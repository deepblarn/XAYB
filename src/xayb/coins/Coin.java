package xayb.coins;

import xayb.Game;
import xayb.MusicPlayer;
import xayb.handler.*;

import java.awt.*;
import java.util.Comparator;
import java.util.Iterator;

public class Coin extends GameObject {

    public static ThreadPool pool = new ThreadPool(2);
    public static int type;
    private Image img;
    public Coin(int x, int y, ID id, int type, int velx, int vely) {
        super(x, y, id);
        Coin.type =type;
        velX=velx;
        velY=vely;
        setTypeCoin(type);
        if (Coin.type ==1){
            this.img=Game.coin1;
        }else if (Coin.type == 2){
            this.img = Game.coin2;
        }else if (Coin.type ==3){
            this.img=Game.coin3;
        }
    }


    @Override
    public void tick() {

        x += velX;
        y += velY;


        if (y > Game.HEIGHT-75){
            System.out.println(this);
             Game.handler.removeObject(this);
             HUD.addFail();
             MusicPlayer player = new MusicPlayer("NFF-robo-hit", false);
             pool.addThread(player);
        }



        if (Game.isClamp(x, 0, Game.WIDTH - 74)) velX *= -1;
        if (Game.isClamp(y, 0, Game.HEIGHT - 74)) velY *= -1;

    }


    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLUE);

        g.drawImage(img, x, y, null);

    }


}
