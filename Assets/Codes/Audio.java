package Assets.Codes;

import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Audio {

    // current status of clip
    private boolean isPause;

    private String fileName;

    // constructor to initialize streams and clip
    public Audio(String file) {
        fileName = file;
    }

    // Method to play the audio
    public void play() {
        // start the clip
        AudioStream as;

        InputStream in;
        try {
            in = getClass().getResourceAsStream("../Sounds/" + fileName);
            as = new AudioStream(in);
            AudioPlayer.player.start(as);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        isPause = false;
    }

    public void loop(){
        AudioStream as;
        InputStream in;
        try {
            in = getClass().getResourceAsStream("../Sounds/" + fileName);
            as = new AudioStream(in);
            AudioData ad = as.getData();

            AudioPlayer.player.start(new ContinuousAudioDataStream(ad));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Method to pause the audio
    public void pause() {
        if (isPause) {
            return;
        }
        AudioStream as;

        InputStream in;
        try {
            in = getClass().getResourceAsStream("../Sounds/" + fileName);
            as = new AudioStream(in);
            AudioPlayer.player.stop(as);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        isPause = true;
    }

    // Method to resume the audio
    public void resume() {
        if (!isPause) {
            return;
        }
        this.play();
    }

    // Method to restart the audio
    public void restart() {
        this.play();
    }

}
