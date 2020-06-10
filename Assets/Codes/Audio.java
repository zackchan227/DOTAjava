package Assets.Codes;

import javax.sound.sampled.*;
import java.io.IOException;

public class Audio {

    private Clip clip;
    private boolean isPause;
    private Long currentFrame;
    private AudioInputStream audio;
    private String fileName;

    public Audio() {

    }

    public Audio(String file) {
        try {
            fileName = file;
            audio = AudioSystem.getAudioInputStream(getClass().getResource("../Sounds/" + fileName));
            clip = AudioSystem.getClip();
            clip.open(audio);
            isPause = false;
            currentFrame = 0l;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public Clip getClip() {
        return clip;
    }

    public void play() {
        clip.start();
        isPause = false;
    }

    public void pause() {
        if (isPause == true) {
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        isPause = true;
    }

    // Method to resume the audio
    public void resume() {
        if (isPause == false) {
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public void restart() {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    // Method to stop the audio
    public void stop() {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    // Method to reset audio stream
    public void resetAudioStream() {
        try {
            audio = AudioSystem.getAudioInputStream(getClass().getResource("../Sounds/" + fileName));
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void playOneShot(String fileName) {
        Audio s = new Audio(fileName);
        s.play();
    }

}
