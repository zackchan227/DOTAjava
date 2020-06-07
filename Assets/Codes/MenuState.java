package Assets.Codes;

import java.awt.*;
// import java.io.File;
// import java.io.IOException;

import javax.swing.JOptionPane;

public class MenuState extends State {

    private int currentChoice = 0;
    private String[] options = { "Start", "Help", "Quit" };
    // private Color titleColor;
    // private Font titleFont;

    private Font font;

    private Animation title;

    private Audio au1, au2, au;

    public MenuState(Game game) {
        super(game);
        Assets.init();

        // try {
        // GraphicsEnvironment ge =
        // GraphicsEnvironment.getLocalGraphicsEnvironment();
        // ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new
        // File("../Font/CuteFont.TTF")));
        // } catch (IOException|FontFormatException e) {
        // //Handle exception
        // }

        // titleColor = new Color(128, 0, 0);
        // titleFont = new Font("Century Gothic", Font.PLAIN, 35);
        font = new Font("", Font.BOLD, 30);

        title = new Animation(10, Assets.name);
        au1 = new Audio("Ping.wav");
        au2 = new Audio("select.wav");
        au = new Audio("templeoftime.wav");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        if (game.getKeyManager().enter) {
            au1.play();
            select();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (game.getKeyManager().up) {
            au2.play();
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
            au2.play();
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
        title.update();

    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(Assets.background, 0, 0, null);
        // g.drawImage(Assets.buttonPlay, 165, 150, null);
        // g.setColor(titleColor);
        // g.setFont(titleFont);
        // g.drawString("DOTA", 195, 60);
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
            State.setState(game.getGameState());
            au.play();

        }
        if (currentChoice == 1) {
            JOptionPane.showMessageDialog(null, "Use arrow key to attack the enemy", "Guide", 1);
        }
        if (currentChoice == 2) {
            System.exit(0);
        }
    }
}