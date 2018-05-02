package xayb.handler;

import java.awt.Graphics;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Handler implements Iterable<GameObject>{

    public LinkedList<GameObject> object = new LinkedList<>();


    public void tick(){
        for (GameObject tempObject : new LinkedList<>(object)) {
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for (GameObject tempObject : object) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);

    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void clearObjects(){
        this.object.clear();
    }

    @Override
    public Iterator<GameObject> iterator() {
        return object.iterator();
    }






}
