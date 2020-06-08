package Assets.Codes;

import javax.sound.sampled.*;
import java.io.IOException;

public class Audio{

    private Clip clip;

    public Audio(String sound){
        try{
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(sound));
            clip = AudioSystem.getClip();
            clip.open(audio);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public Clip getClip() {return clip;}

    public void play() {clip.start();}

    public void stop() {clip.stop();}

    public static void playSound(String sound){
        Audio s = new Audio(sound);
        s.play();
    }

}

