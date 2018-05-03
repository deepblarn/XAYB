package xayb.handler;


import java.awt.Graphics;

public abstract class GameObject {

    protected int x,y;
    protected static int ys;
    protected ID id;
    protected int velX, velY;
    protected int typeCoin;

    public void setTypeCoin(int type){
        this.typeCoin = type;
    }

    public int getTypeCoin(){
        return this.typeCoin;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY(){
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public abstract void tick();
    public abstract void render(Graphics g);




}
