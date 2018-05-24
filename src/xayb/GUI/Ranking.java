package xayb.GUI;




import xayb.Game;

import java.awt.*;

import static xayb.Game.HEIGHT;
import static xayb.Game.WIDTH;


public class Ranking{

    public void tick(){

    }

    public void render(Graphics g){

        g.setFont(new Font("default", Font.BOLD, 50));
        g.setColor(new Color(186,59,70));
        g.fillRect(WIDTH / 2 - (int) (WIDTH * 0.2), (int) (HEIGHT * 0.05), (int) (WIDTH*0.43),600);
        g.setColor(Color.WHITE);
        g.drawString("SCOREBOARD",WIDTH / 2 - (int) (WIDTH * 0.12), (int) (HEIGHT * 0.15));
        g.drawImage(Game.gold, WIDTH / 2 - (int) (WIDTH * 0.14), (int) (HEIGHT*0.25625), 64, 64,null);
        g.drawImage(Game.silver, WIDTH / 2 - (int) (WIDTH * 0.14), (int) (HEIGHT*0.434375), 64, 64,null);
        g.drawImage(Game.bronze, WIDTH / 2 - (int) (WIDTH * 0.14), (int) (HEIGHT*0.6125), 64, 64,null);
        g.setFont(new Font("default", Font.BOLD, 25));
        g.setColor(Color.WHITE);
        g.drawString("E", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.30625));
        g.drawString("PIPOPIPOPIPOPIPOPIPO", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.49625));
        g.drawString("PIPOPIPOPIPOPIPOPIPO", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.66625));


    }


}
