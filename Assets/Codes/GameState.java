package Assets.Codes;

import java.awt.Graphics;
import java.awt.Font;

public class GameState extends State {

    private Player p;
    private Controller c;
    private boolean isPause;
    private Audio au;

    public GameState(Game game) {
        super(game);
        p = new Player(game, 223, 160);
        c = new Controller(this);
        isPause = false;
        au = new Audio("templeoftime.wav");
    }

    public void update() {
        if (!isPause) {
            p.update();
            c.update(p);
            if (game.getKeyManager().pause) {
                isPause = true;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else {
            if (game.getKeyManager().pause) {
                isPause = false;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void paint(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        p.paint(g);
        c.paint(g);
        Font font = new Font("", Font.BOLD, 30);
        g.setFont(font);
        // g.drawString("Tap: "+p.getTap(),20,350);
        g.drawString("Score: " + p.getScore(), 20, 300);
        if(isPause){
            font = new Font("", Font.BOLD, 100);
            g.setFont(font);
            g.drawString("PAUSE",70,200);
        }
    }

    public boolean isPause() {
        return isPause;
    }

    public Game getGame() {
        return this.game;
    }

}