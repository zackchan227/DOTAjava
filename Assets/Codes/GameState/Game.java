package Assets.Codes.GameState;

import Assets.Codes.Manager.KeyManager;
import Assets.Codes.Manager.MouseManager;
import Assets.Codes.Window.Window;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class Game implements Runnable {

    private Window window;

    private Thread thread;

    private boolean isRunning = false;

    private BufferStrategy bs;
    private Graphics g;

    private State menuState;

    private MouseManager mm;
    private KeyManager km;

    public Game() {
        mm = new MouseManager();
        km = new KeyManager();
    }

    private void init() {
        window = new Window();
        menuState = new MenuState(this);
        window.getFrame().addKeyListener(km);
        window.getFrame().addMouseListener(mm);
        window.getFrame().addMouseMotionListener(mm);
        window.getCanvas().addMouseListener(mm);
        window.getCanvas().addMouseMotionListener(mm);
        State.setState(menuState);
    }

    private void update() {
        km.update();
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
        init();

        while (isRunning) {
            update();
            paint();
        }
    }

    public synchronized void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public KeyManager getKeyManager() {
        return km;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public MouseManager getMouseManager() {
        return mm;
    }

    public State getMenuState() {
        return menuState;
    }

}