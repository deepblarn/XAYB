package xayb;

import xayb.GUI.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    private static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    public Game(){
        new Window(WIDTH, HEIGHT, "game", this);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running=true;
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

    private void tick(){

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs ==null){
            this.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH, HEIGHT);
        g.setColor(Color.blue);
        g.fillRect(0,0,100,100);

        g.dispose();
        bs.show();
    }

    public static void main(String args[]){
        new Game();
    }
}
