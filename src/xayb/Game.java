package xayb;

import xayb.GUI.GameOver;
import xayb.GUI.Menu;
import xayb.GUI.Ranking;
import xayb.GUI.Window;
import xayb.handler.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable{


    public static int WIDTH = 1280, HEIGHT = 720;
    private static boolean running = false;
    public static Handler handler;
    private Menu menu;
    private Ranking ranking;
    public static int FPS = 0;
    private static BufferedImage image;
    private Graphics g;
    public static ThreadPool pool = new ThreadPool(2);
    public static Image coin1,coin2,coin3, menuimg, gameover,gold,silver,bronze;
    private GameOver over;


    // TODO : RANKING AND OPTIONS

    public enum STATE {
        Menu,
        Game,
        GameOver,
        Ranking
    }

    public static STATE gameState = STATE.Menu;

    private Game() {

        coin1 = getImage("coin1");
        coin2 = getImage("coin2");
        coin3 = getImage("coin3");
        menuimg = getImage("menu");
        gameover = getImage("over");
        gold = getImage("gold-medal");
        silver = getImage("silver-medal");
        bronze = getImage("bronze-medal");


        OS.optimize();

        handler = new Handler();
        menu = new Menu(handler);
        over = new GameOver();
        ranking = new Ranking();

        this.addKeyListener(new Input(handler));
        this.addMouseListener(menu);
        this.addMouseListener(over);

        new Window(WIDTH, HEIGHT, "XAYB", this);
        System.out.println(HEIGHT);
    }

    public static BufferedImage getImage(String img) {
        try {
            image = ImageIO.read(Game.class.getResource("img/" + img + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.flush();
        return image;

    }

    private static synchronized void stop(){
        try {
            Window.pool.dispose();
            running=false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void run(){
        try{
            running=true;
            long lastTime = System.nanoTime();
            double amountTicks = 144.0;
            double ns = 1000000000 / amountTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int frames = 0;
            while (running){
                long now = System.nanoTime();
                delta += (now-lastTime)/ns;
                lastTime=now;
                while (delta>=1){
                    tick();
                    delta--;
                }
                if (running)
                    render();
                frames++;
                if (System.currentTimeMillis() - timer > 1000){
                    timer +=1000;
                    FPS=frames;
                    frames = 0;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        stop();
    }

    private void tick() {
        if (gameState == STATE.Menu) {
            menu.tick();
        } else if (gameState == STATE.Game){
            handler.tick();
        }else if (gameState == STATE.GameOver){
            over.tick();
        }else if (gameState == STATE.Ranking){
            ranking.tick();
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs ==null){
            this.createBufferStrategy(3);
            return;
        }

        this.g = bs.getDrawGraphics();
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (gameState == STATE.Game){
            g.setColor(Color.black);
            g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
            handler.render(g);
        }else if (gameState == STATE.Menu){
            menu.render(g);
        }else if (gameState == STATE.GameOver){
            over.render(g);
        }else if (gameState == STATE.Ranking){
            g.setColor(Color.black);
            g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
            ranking.render(g);
        }

        g.dispose();
        bs.show();
    }
    public static int clamp(int var, int min, int max){

        if (var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;

    }

    public static boolean isClamp(int var, int min, int max) {

        return var >= max || var <= min;

    }

    public static void main(String args[]){
        new Game();
    }
}
