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

        if (mouseOver(mx, my, 210,150,200, 64)){
            Game.gameState = Game.STATE.Game;
            handler.addObject(new Player(50,50, ID.Player));
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


        g.drawImage(Game.getImage("aa"), 0, 0,Game.WIDTH, Game.HEIGHT,null);


        Font font = new Font("MV Boli", 1, 50);
        Font font2 = new Font("Arial", 1, 40);

        g.setFont(font);

        g.setColor(Color.gray);
        g.drawString("Menu", 230, 70);

        g.setFont(font2);

        g.setColor(Color.gray);
        g.drawString("Play", 270, 195);

        g.setColor(Color.gray);
        g.drawString("PIPO", 270, 295);

        g.setColor(Color.gray);
        g.drawString("Pepe", 270, 395);

        g.setColor(Color.white);
        g.drawRect(210,150,200,64);

        g.setColor(Color.white);
        g.drawRect(210,250,200,64);

        g.setColor(Color.white);
        g.drawRect(210,350,200,64);
    }


}
