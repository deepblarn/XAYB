package xayb.coins;



import xayb.Game;
import xayb.MusicPlayer;
import xayb.handler.*;

import java.awt.*;

public class BlackCoin extends GameObject {

    public static ThreadPool pool = new ThreadPool(2);

    public BlackCoin(int x, int y, ID id) {
        super(x, y, id);
        velY = -2;
        velX = -2;

    }

    @Override
    public void tick() {

        x += velX;
        y += velY;


        for (int j = 0; j < Game.handler.object.size(); j++) {
            GameObject tempObj2 = Game.handler.object.get(j);

            if (tempObj2.getId() == ID.BlackCoin && tempObj2.getY() > Game.HEIGHT-105){
                Game.handler.object.remove(tempObj2);
                MusicPlayer player = new MusicPlayer("NFF-robo-hit", false);
                pool.addThread(player);
                HUD.addFail();
            }
        }

        if (Game.isClamp(x, 10, Game.WIDTH - 75)) velX *= -1;
        if (Game.isClamp(y, 10, Game.HEIGHT - 75)) velY *= -1;

    }


    @Override
    public void render(Graphics g) {

        g.setColor(Color.BLUE);
        Image img = Game.getImage("coin1");
        g.drawImage(img, x, y, null);

    }


}
