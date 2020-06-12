package Assets.Codes.GameState;

import Assets.Codes.Audio.Audio;
import Assets.Codes.Entity.Player;
import Assets.Codes.Manager.Assets;
import Assets.Codes.Window.Level;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;

public class GameState extends State {

    private Player p;
    private Controller c;
    private boolean isPause;
    private Audio au;
    private static boolean isRunning;
    private Level lv;

    public static boolean isRunning() {
        return isRunning;
    }

    private static final String saveDataPath = "./Assets/Save/";
    private static final String fileName = "HighScore.dat";

    public GameState(Game game) {
        super(game);
        p = new Player(game, 223, 160);
        lv = new Level(p);
        c = new Controller(this,lv);
        isPause = false;
        isRunning = true;
        au = new Audio("templeoftime.wav");
        au.getClip().loop(Clip.LOOP_CONTINUOUSLY);     
        loadHighScore();
    }

    public void update() {
        if (p.isDead()) {
            gameOver();
        }
        if (!isPause && getState() == this) {
            p.update();
            c.update(p);
            if (game.getKeyManager().pause || game.getMouseManager().isPausePressed()) {
                isPause = true;
                au.pause();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else {
            if (game.getKeyManager().pause || game.getMouseManager().isPausePressed()) {
                isPause = false;
                au.resume();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void paint(Graphics g) {

        if (lv.changeLevel() == 0) {
            g.drawImage(Assets.background1, 0, 0, null);
        } else if (lv.changeLevel() == 1) {
            g.drawImage(Assets.background2, 0, 0, null);
        } else if (lv.changeLevel() == 2) {
            g.drawImage(Assets.background3, 0, 0, null);
        } else if (lv.changeLevel() == 3) {
            g.drawImage(Assets.background4, 0, 0, null);
        } else if (lv.changeLevel() == 4) {
            g.drawImage(Assets.background5, 0, 0, null);
        }

        p.paint(g);
        c.paint(g);
        Font font = new Font("", Font.BOLD, 30);
        g.setFont(font);
        g.drawString("Score: " + p.getScore(), 20, 300);
        g.drawString("High Score: " + p.getHighScore(), 20, 350);
        if (isPause) {
            font = new Font("", Font.BOLD, 100);
            g.setFont(font);
            g.drawString("PAUSE", 70, 200);
            g.drawImage(Assets.buttonResume, 420, 15, 40, 40, null);
        }
        else g.drawImage(Assets.buttonPause, 420, 15, 40, 40, null);

    }

    public boolean isPause() {
        return isPause;
    }

    public Game getGame() {
        return this.game;
    }

    public Audio getAudio() {
        return this.au;
    }

    public Level getLevel() {
        return this.lv;
    }

    private void createSaveData() {
        try {
            File file = new File(saveDataPath, fileName);
            FileWriter output = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write("" + 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadHighScore() {
        try {
            File f = new File(saveDataPath, fileName);
            if (!f.isFile()) {
                createSaveData();
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            p.setHighScore(Integer.parseInt(reader.readLine()));
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setHighscore() {
        FileWriter output = null;

        try {
            File f = new File(saveDataPath, fileName);
            output = new FileWriter(f);
            BufferedWriter writer = new BufferedWriter(output);

            writer.write("" + p.getHighScore());

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void gameOver() {
        au.stop();
        Icon icon = new Icon() {

            public int getIconHeight() {
                return 32;
            }

            public int getIconWidth() {
                return 32;
            }

            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                // TODO Auto-generated method stub
                g.drawImage(new ImageIcon("Assets/Images/BackGround/logo.png").getImage(), x, y, 32, 32, null);
            }
        };
        int option = JOptionPane.showConfirmDialog(null,
                "Your score: " + p.getScore() + "\nHigh score: " + p.getHighScore()+"\nDo you want to retry ?", "Score", JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE, icon);
        setHighscore();
        p.setScore(0);
        if (option == JOptionPane.NO_OPTION) {
            isRunning = false;
            State.setState(game.getMenuState());
        }
        if (option == JOptionPane.YES_OPTION) {
            State.setState(new GameState(game));
        }
    }

}