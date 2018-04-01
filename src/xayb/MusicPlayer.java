package xayb;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;

public class MusicPlayer implements Runnable{

    private ArrayList<String> musicFiles;
    private int curentsongindex;
    public MusicPlayer(String... files){
        musicFiles = new ArrayList<String>();
        for (String file : files)
            musicFiles.add("./resources/audio/" + file + ".wav");
    }

    private void playSound(String fileName){


        try {
            File soundFile = new File(fileName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run(){
        playSound(musicFiles.get(curentsongindex));
    }


}
