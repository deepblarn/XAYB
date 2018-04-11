package xayb.GUI;


import xayb.Game;
import xayb.MusicPlayer;
import xayb.handler.ThreadPool;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window extends Canvas{


    public static ThreadPool pool = new ThreadPool(2);

    public Window(int width, int height, String title, Game game){


        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.requestFocus();

        MusicPlayer player = new MusicPlayer("oniku-loop-2");

        pool.addThread(game);
        pool.addThread(player);

    }

}
