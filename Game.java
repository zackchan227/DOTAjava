import java.awt.image.BufferStrategy;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Window window;

    private Thread thread;

    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private BufferedImage bi;
    private SpriteSheet idle_front;

    public Game() {
        //init();

    }

    private void init(){
        window = new Window();
        Assets.init();
        //bi = ImageLoader.loadImage("Images/Player/Zeus/zeus_idle_front.png");
        //idle_front = new SpriteSheet(bi); 
    }

    private void update(){

    }

    private void draw(){
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, 480, 360);

        g.drawImage(Assets.background,0,0,null);
        g.drawImage(Assets.player_idle_front[0],223,160,null);
       

        bs.show();
        g.dispose();
    }

    public void run() {
        // TODO Auto-generated method stub
        init();

        while(running){
            update();
            draw();
        }
    }

    public synchronized void start() {
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if(!running){
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (final InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}