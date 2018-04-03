package xayb;

import xayb.GUI.Menu;
import xayb.GUI.Window;
import xayb.handler.Handler;
import xayb.handler.ID;
import xayb.handler.Input;
import xayb.handler.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private boolean running = false;
    private Thread thread;
    private Handler handler;
    private Menu menu;

    public enum STATE {
        Menu,
        Game
    }

    public static STATE gameState = STATE.Game;

    public Game(){

        handler = new Handler();
        menu = new Menu(this, handler);

        this.addKeyListener(new Input(handler));
        this.addMouseListener(menu);

        new Window(WIDTH, HEIGHT, "XAYB", this);


        handler.addObject(new Player(50,50, ID.Player));
    }


    public synchronized void stop(){
        try {
            thread.join();
            running=false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        running=true;
        long lastTime = System.nanoTime();
        double amountTicks = 60.0;
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
                System.out.println("FPS: " + frames);
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
            this.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (gameState == STATE.Game){

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

    public static void main(String args[]){
        new Game();
    }
}
