package xayb.GUI;




import xayb.Game;

import java.awt.*;
import java.util.Map;

import static xayb.Game.HEIGHT;
import static xayb.Game.WIDTH;


public class Ranking{

    public void tick(){

    }

    public void render(Graphics g){

        g.setFont(new Font("default", Font.BOLD, 50));
        g.setColor(new Color(186,59,70));
        g.fillRect(WIDTH / 2 - (int) (WIDTH * 0.2), (int) (HEIGHT * 0.05), (int) (WIDTH*0.43),(int) (HEIGHT*0.833));
        g.setColor(Color.WHITE);
        g.drawString("SCOREBOARD",WIDTH / 2 - (int) (WIDTH * 0.12), (int) (HEIGHT * 0.15));
        g.drawImage(Game.gold, WIDTH / 2 - (int) (WIDTH * 0.14), (int) (HEIGHT*0.25625), 64, 64,null);
        g.drawImage(Game.silver, WIDTH / 2 - (int) (WIDTH * 0.14), (int) (HEIGHT*0.434375), 64, 64,null);
        g.drawImage(Game.bronze, WIDTH / 2 - (int) (WIDTH * 0.14), (int) (HEIGHT*0.6125), 64, 64,null);
        g.setFont(new Font("default", Font.BOLD, 25));
        g.setColor(Color.WHITE);


        if (GameOver.map.size()==0){
            g.drawString("Nothing", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.30625));
            g.drawString("Nothing", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.49625));
            g.drawString("Nothing", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.66625));

        }
        if (GameOver.map.size()==1){
            g.drawString((String) GameOver.map.values().toArray()[0], WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.30625));
            g.drawString(String.valueOf(getKeyFromValue(GameOver.map, GameOver.map.values().toArray()[0])), WIDTH / 2 + (int) (WIDTH * 0.08), (int) (HEIGHT*0.30625));
            g.drawString("Nothing", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.49625));
            g.drawString("Nothing", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.66625));
        }
        if (GameOver.map.size()==2){
            g.drawString((String) GameOver.map.values().toArray()[0], WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.30625));
            g.drawString(String.valueOf(getKeyFromValue(GameOver.map, GameOver.map.values().toArray()[0])), WIDTH / 2 + (int) (WIDTH * 0.08), (int) (HEIGHT*0.30625));

            g.drawString((String) GameOver.map.values().toArray()[1], WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.49625));
            g.drawString(String.valueOf(getKeyFromValue(GameOver.map, GameOver.map.values().toArray()[1])), WIDTH / 2 + (int) (WIDTH * 0.08), (int) (HEIGHT*0.49625));

            g.drawString("Nothing", WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.66625));
        }

        if (GameOver.map.size()>=3){

            g.drawString((String) GameOver.map.values().toArray()[0], WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.30625));
            g.drawString(String.valueOf(getKeyFromValue(GameOver.map, GameOver.map.values().toArray()[0])), WIDTH / 2 + (int) (WIDTH * 0.08), (int) (HEIGHT*0.30625));

            g.drawString((String) GameOver.map.values().toArray()[1], WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.49625));
            g.drawString(String.valueOf(getKeyFromValue(GameOver.map, GameOver.map.values().toArray()[1])), WIDTH / 2 + (int) (WIDTH * 0.08), (int) (HEIGHT*0.49625));

            g.drawString((String) GameOver.map.values().toArray()[2], WIDTH / 2 - (int) (WIDTH * 0.07), (int) (HEIGHT*0.66625));
            g.drawString(String.valueOf(getKeyFromValue(GameOver.map, GameOver.map.values().toArray()[2])), WIDTH / 2 + (int) (WIDTH * 0.08), (int) (HEIGHT*0.66625));

        }




    }
    private static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }


}
