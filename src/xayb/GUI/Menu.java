package xayb.GUI;

import xayb.Game;
import xayb.coins.BlueCoin;
import xayb.handler.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Random;

import static xayb.Game.*;

public class Menu extends MouseAdapter {


    private Game game;
    private Handler handler;
    private BufferedImage image;
    public static ThreadPool pool = new ThreadPool(2);

    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        // Settings button: Game.WIDTH/2-(int) (Game.WIDTH*0.12), (int) (Game.HEIGHT*0.466), (int) (Game.WIDTH*0.24), (int) (Game.HEIGHT*0.08)
        // Scores Button : Game.WIDTH/2-(int) (Game.WIDTH*0.12), (int) (Game.HEIGHT*0.602), (int) (Game.WIDTH*0.24), (int) (Game.HEIGHT*0.08)

        if (gameState == STATE.Menu && mouseOver(mx, my, WIDTH / 2 - (int) (WIDTH * 0.12), (int) (HEIGHT * 0.33), (int) (WIDTH * 0.24), (int) (HEIGHT * 0.08))){
            //Change gameState
            gameState = STATE.Game;
            handler.clearObjects();
            //Add player
            handler.addObject(new HUD(10,10, ID.HUD));


            int max = 10;
            int min = 5;
            int diff = max - min;
            Random rn = new Random();
            int in = rn.nextInt(diff + 1);
            in += min;

            handler.addObject(new Player(10000,10000, ID.Player));



            handler.addObject(new BlueCoin(500,500, ID.BlueCoin));
            handler.addObject(new BlueCoin(500,300, ID.BlueCoin));
            handler.addObject(new BlueCoin(500,100, ID.BlueCoin));








        }

        if (mouseOver(mx, my, WIDTH/2-(int) (WIDTH*0.12), (int) (HEIGHT*0.738), (int) (WIDTH*0.24), (int) (HEIGHT*0.08))){
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


        g.drawImage(getImage("menu"), 0, 0, WIDTH, HEIGHT,null);



    }


}
