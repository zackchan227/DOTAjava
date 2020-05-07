import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class Game implements Runnable {

    private Window window;

    private Thread thread;

    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    // private Animation a;

    private State menuState;
    private State gameState;

    private MouseManager mm;

    public Game(){
        //init();
        mm = new MouseManager();
    }

    private void init() {
        window = new Window();
        menuState = new MenuState();
        gameState = new GameState();
        window.getFrame().addMouseListener(mm);
        window.getFrame().addMouseMotionListener(mm);
        window.getCanvas().addMouseListener(mm);
        window.getCanvas().addMouseMotionListener(mm);
       
        State.setState(gameState);
    }

    private void update() {
        if (State.getState() != null) {
            State.getState().update();

        }

    }

    private void paint() {
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, 480, 360);

        if (State.getState() != null)
            State.getState().paint(g);

        bs.show();
        g.dispose();
    }

    public void run() {
        // TODO Auto-generated method stub
        init();

        while (running) {
            update();
            paint();
        }
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
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

    public MouseManager getMouseManager(){
        return mm;
    }
}