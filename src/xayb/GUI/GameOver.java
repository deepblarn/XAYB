package xayb.GUI;


import xayb.Game;
import xayb.handler.HUD;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.*;

import static xayb.Game.*;

public class GameOver extends MouseAdapter implements java.io.Serializable {

    public static Map map = new TreeMap<Integer, String>(new MyComparator());
    public static int count;

    public static String text = "";

    private boolean submit = false;



    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mouseOver(mx,my,WIDTH/2-(int)(WIDTH*0.0535), (int) (HEIGHT*0.76), 170, 40) && gameState == STATE.GameOver && submit){
            if (!map.containsValue(text)){
                map.put(HUD.score,text.toUpperCase());
                gameState = STATE.Menu;
            }


        }
    }

    public void tick(){
        if (text.length()>0) submit=true;

    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        return mx > x && mx < x + width && my > y && my < y + height;
    }


    public void render(Graphics g){

        g.setFont(new Font("default", Font.BOLD, 16));

        g.drawImage(Game.gameover, 0, 0, WIDTH, HEIGHT,null);
        g.setColor(Color.WHITE);
        g.drawString(text.toUpperCase(), WIDTH/2-(int)(WIDTH*0.035), (int) (HEIGHT*0.738));
        g.setColor(new Color(97,201,168));
        g.fillRect(WIDTH/2-(int)(WIDTH*0.0535), (int) (HEIGHT*0.76), (int) (WIDTH*0.13), (int) (HEIGHT*0.055));
        g.setColor(Color.WHITE);
        g.drawString("SEND SCORE",WIDTH/2-(int)(WIDTH*0.03), (int) (HEIGHT*0.799));

    }



}

class MyComparator implements Comparator<Integer>, java.io.Serializable {

    @Override
    public int compare(Integer first, Integer second) {

        return second.compareTo(first);
    }
}