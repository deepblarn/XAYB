package xayb;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LoadFile{


    private File file;
    private Map mapf;

    public LoadFile(File f){
        file = f;
    }

    public boolean fileExist(){
        return file.exists();
    }

    public void writeFile(Map map){
        try
        {
            FileOutputStream fos =
                    new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
            fos.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void readFile(){
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapf = (Map) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
        }


    }

    public Map getMapf() {
        return mapf;
    }

}
