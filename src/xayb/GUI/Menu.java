package xayb.GUI;

import xayb.Game;
import xayb.handler.Handler;
import xayb.handler.ID;
import xayb.handler.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class Menu extends MouseAdapter {


    private Game game;
    private Handler handler;
    private BufferedImage image;

    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        // Settings button: Game.WIDTH/2-(int) (Game.WIDTH*0.12), (int) (Game.HEIGHT*0.466), (int) (Game.WIDTH*0.24), (int) (Game.HEIGHT*0.08)
        // Scores Button : Game.WIDTH/2-(int) (Game.WIDTH*0.12), (int) (Game.HEIGHT*0.602), (int) (Game.WIDTH*0.24), (int) (Game.HEIGHT*0.08)

        if (mouseOver(mx, my, Game.WIDTH/2-(int) (Game.WIDTH*0.12), (int) (Game.HEIGHT*0.33), (int) (Game.WIDTH*0.24), (int) (Game.HEIGHT*0.08))){
            //Change gameState
            Game.gameState = Game.STATE.Game;

            //Add player
            handler.addObject(new Player(50,50, ID.Player));

            // Set blank cursor
            BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                    cursorImg, new Point(0, 0), "blank cursor");
            Window.frame.getContentPane().setCursor(blankCursor);
        }

        if (mouseOver(mx, my,Game.WIDTH/2-(int) (Game.WIDTH*0.12), (int) (Game.HEIGHT*0.738), (int) (Game.WIDTH*0.24), (int) (Game.HEIGHT*0.08))){
            System.exit(1);
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            return my > y && my < y + height;
        }else return false;
    }

    public void tick(){

    }

    public void render(Graphics g){


        g.drawImage(Game.getImage("menu"), 0, 0,Game.WIDTH, Game.HEIGHT,null);



    }


}
