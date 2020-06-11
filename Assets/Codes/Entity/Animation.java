package Assets.Codes.Entity;

import java.awt.image.BufferedImage;

public class Animation {

    private int fps, index;
    private BufferedImage frames[];
    private long lastTime, timer;

    public Animation(int fps, BufferedImage frames[]) {
        this.fps = 1000/fps;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > fps) {
            index++;
            timer = 0;
            if (index >= frames.length)
                index = 0;
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }

    public int getCurrentFrameIndex(){
        return this.index;
    }
}