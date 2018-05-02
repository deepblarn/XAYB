package xayb.GUI;

import xayb.Game;
import xayb.coins.Coin;
import xayb.handler.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Comparator;

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
            //Clear all objects

            //Set score and errors to 0
            HUD.fails = 0;
            HUD.score=0;
            //Add player
            handler.addObject(new HUD(10,10, ID.HUD));

            handler.addObject(new Player(1,1, ID.Player));


            //Ordered by Y


            handler.addObject(new Coin(Game.WIDTH/2,500, ID.Coin, 1, 10,-1));
            handler.addObject(new Coin(Game.WIDTH/2,500, ID.Coin, 3, 9, -2));
            handler.addObject(new Coin(Game.WIDTH/2,500, ID.Coin, 3, 11, -2));
            handler.addObject(new Coin(Game.WIDTH/2,1000, ID.Coin, 3, 4,-12));









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
