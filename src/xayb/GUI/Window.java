package xayb.GUI;


import xayb.Game;
import xayb.MusicPlayer;
import xayb.handler.ThreadPool;

import javax.swing.*;
import java.awt.*;


public class Window extends Canvas{



    public static ThreadPool pool = new ThreadPool(2);

    public Window(int width, int height, String title, Game game){


        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));



        frame.setUndecorated(true);
        frame.setAlwaysOnTop(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.requestFocus();

        frame.setIconImage(Game.getImage("icon"));
        MusicPlayer player = new MusicPlayer("oniku-loop-2", true);

        pool.addThread(game);
        pool.addThread(player);

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("POS Me tanco");
            }
        }));


    }

}
