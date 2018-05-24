package xayb.GUI;

import xayb.Game;
import xayb.coins.Coin;
import xayb.handler.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Comparator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static xayb.Game.*;

public class Menu extends MouseAdapter {


    private Handler handler;
    private Timer t;
    public static ThreadPool pool = new ThreadPool(2);


    public Menu(Handler handler){
        this.handler = handler;
    }

    private static int getRandomNumberInRange(int max, int min) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();


        if (gameState == STATE.Menu && mouseOver(mx, my, WIDTH / 2 - (int) (WIDTH * 0.12), (int) (HEIGHT * 0.33), (int) (WIDTH * 0.24), (int) (HEIGHT * 0.08))){
            //Change gameState
            gameState = STATE.Game;
            //Clear all objects
            handler.clearObjects();
            //Set score and errors to 0
            HUD.fails = 0;
            HUD.score=0;
            //Add player

            handler.addObject(new Player(1,1, ID.Player));

            handler.addObject(new HUD(0,0,ID.HUD));

            //Ordered by Y


            if (t == null){
                t = new Timer();

                t.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        for (int i = 0; i < getRandomNumberInRange(5,2); i++) {
                            handler.addObject(new Coin(Game.WIDTH/2,500, ID.Coin, getRandomNumberInRange(3,1), getRandomNumberInRange(10,-10),getRandomNumberInRange(-1,-10)));
                        }
                    }
                }, 0, 5000);
            }









        }

        if (mouseOver(mx,my,WIDTH/2-(int) (WIDTH*0.12), (int) (HEIGHT*0.602), (int) (WIDTH*0.24), (int) (HEIGHT*0.08)) && gameState == STATE.Menu){
            gameState = STATE.Ranking;
        }

        if (mouseOver(mx, my, WIDTH/2-(int) (WIDTH*0.12), (int) (HEIGHT*0.738), (int) (WIDTH*0.24), (int) (HEIGHT*0.08)) && gameState == STATE.Menu){
            System.exit(1);
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        return mx > x && mx < x + width && my > y && my < y + height;
    }

    public void tick(){

    }

    public void render(Graphics g){


        g.drawImage(Game.menuimg, 0, 0, WIDTH, HEIGHT,null);


    }


}
