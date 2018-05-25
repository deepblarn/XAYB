package xayb;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;

public class  MusicPlayer implements Runnable{

    private ArrayList<String> musicFiles;
    private int curentsongindex;
    private boolean loop;
    public MusicPlayer(String file, boolean loop){
        musicFiles = new ArrayList<String>();
        musicFiles.add("src/resources/audio/" + file + ".wav");
        this.loop = loop;
    }

    private void playSound(String fileName){


        try {
            File soundFile = new File(fileName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = ais.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(ais);
            // Adjust the volume on the output line.
            if( clip.isControlSupported( FloatControl.Type.MASTER_GAIN)) {
                // If inside this if, the Master_Gain must be supported. Yes?
                FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                // This line throws an exception. "Master_Gain not supported"
                volume.setValue( -20 );
            }
            if (loop){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }else{
                clip.start();
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        playSound(musicFiles.get(curentsongindex));
    }


}
