package xayb.GUI;


import java.util.concurrent.*;
import xayb.Game;
import xayb.MusicPlayer;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window extends Canvas{

    public Window(int width, int height, String title, Game game){
        ExecutorService executor = Executors.newFixedThreadPool(2);

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

        executor.submit(player);
        executor.submit(game);

    }

}
