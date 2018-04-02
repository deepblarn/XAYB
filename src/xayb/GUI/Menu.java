package xayb.GUI;

import xayb.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter{

    public void mousePressed(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

    public void tick(){

    }

    public void render(Graphics g){

        Font font = new Font("MV Boli", 1, 50);
        Font font2 = new Font("Arial", 1, 40);

        g.setFont(font);

        g.setColor(Color.gray);
        g.drawString("Menu", 270, 70);

        g.setFont(font2);

        g.setColor(Color.gray);
        g.drawString("Play", 270, 195);

        g.setColor(Color.white);
        g.drawRect(210,150,200,64);

        g.setColor(Color.white);
        g.drawRect(210,250,200,64);

        g.setColor(Color.white);
        g.drawRect(210,350,200,64);
    }

}
