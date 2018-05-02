package xayb;

import xayb.GUI.Menu;
import xayb.GUI.Window;
import xayb.handler.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 1920, HEIGHT = 1080;
    private static boolean running = false;
    public static Handler handler;
    private Menu menu;
    private static BufferedImage image;
    public static Graphics g;
    public static ThreadPool pool = new ThreadPool(2);



    // TODO : Add resume and new game features

    public enum STATE {
        Menu,
        Game
    }

    public static STATE gameState = STATE.Menu;

    public Game() {

        System.setProperty("sun.java2d.opengl", "true");

        handler = new Handler();
        menu = new Menu(this, handler);

        this.addKeyListener(new Input(handler));
        this.addMouseListener(menu);

        new Window(WIDTH, HEIGHT, "XAYB", this);
        System.out.println(HEIGHT);
    }

    public static BufferedImage getImage(String img) {
        try {
            image = ImageIO.read(Game.class.getResource("./img/" + img + ".png"));
        } catch (IOException e) {

        }
        image.flush();
        return image;

    }

    public static synchronized void stop(){
        try {
            Window.pool.dispose();
            running=false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void run(){
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
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        if (gameState == STATE.Menu) {
            menu.tick();
        } else if (gameState == STATE.Game){
            handler.tick();
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
