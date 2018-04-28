package xayb.handler;

import xayb.Game;

import java.awt.Graphics;
import java.awt.Color;

public class Player extends GameObject{



    public Player(int x, int y, ID id){
        super(x, y, id);
        velX=4;
        velY=3;
    }

    @Override
    public void tick(){

        x+=velX;
        y+=velY;


        if (y<= 0 || y >= Game.HEIGHT-50) velY*=-1;
        if (x<= 0 || x >= Game.WIDTH-50) velX*=-1.35;


    }





    private double coord_x(double x) {
        return x+ Game.WIDTH/2;
    }

    private double coord_y(double y) {
        return (-y+ Game.HEIGHT/2);
    }


    @Override
    public void render(Graphics g){

        g.setColor(Color.blue);
        g.fillRect(x,y,50,50);


    }




}
