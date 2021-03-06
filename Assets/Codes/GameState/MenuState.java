package Assets.Codes.GameState;

import Assets.Codes.Manager.Assets;
import Assets.Codes.Audio.Audio;
import Assets.Codes.Entity.Animation;

import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MenuState extends State {

    private int currentChoice = 0;
    private String[] options = { "Start", "Help", "Quit" };

    public Graphics g;

    private Font font;

    private Animation title;

    private Audio au;

    private Icon icon;

    public void setCurrentChoice(int currentChoice) {
        this.currentChoice = currentChoice;
    }

    public MenuState(Game game) {
        super(game);
        Assets.init();
        font = new Font("", Font.BOLD, 30);
        title = new Animation(10, Assets.name);
        au = new Audio();
        icon = new Icon() {

            public int getIconHeight() {
                return 32;
            }

            public int getIconWidth() {
                return 32;
            }

            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.drawImage(new ImageIcon("Assets/Images/BackGround/logo.png").getImage(), x, y, 32, 32, null);
            }
        };
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        if (game.getKeyManager().enter) {
            au.playOneShot("Ping.wav");
            select();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (game.getKeyManager().up) {
            au.playOneShot("select.wav");
            try {
                Thread.sleep(200);
                if (currentChoice == 2) {
                    currentChoice = 1;
                } else if (currentChoice == 1) {
                    currentChoice = 0;
                } else {
                    currentChoice = 2;
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (game.getKeyManager().down) {
            au.playOneShot("select.wav");
            try {
                Thread.sleep(200);
                if (currentChoice == 0) {
                    currentChoice = 1;
                } else if (currentChoice == 1) {
                    currentChoice = 2;
                } else {
                    currentChoice = 0;
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(game.getMouseManager().isPlayPressed()){
            currentChoice = 0;
            au.playOneShot("Ping.wav");
            select();
        }
        if(game.getMouseManager().isHelpPressed()){
            currentChoice = 1;
            au.playOneShot("Ping.wav");
            select();
        }
        if(game.getMouseManager().isQuitPressed()){
            currentChoice = 2;
            au.playOneShot("Ping.wav");
            select();
        }
        title.update();

    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(Assets.background1, 0, 0, null);
        g.drawImage(title.getCurrentFrame(), 120, 30, null);

        // draw menu options
        g.setFont(font);

        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.BLACK);
            }
            g.drawString(options[i], 205, 160 + i * 50);
        }
    }

    private void select() {
        if (currentChoice == 0) {
            State.setState(new GameState(game));
        }
        if (currentChoice == 1) {
            JOptionPane.showMessageDialog(null,
                    "Use arrow key or W A S D to attack the enemy\nESC or P to pause game\nAlt + F4 to exit", "Guide",
                    0, icon);
        }
        if (currentChoice == 2) {
            System.exit(0);
        }
    }

}