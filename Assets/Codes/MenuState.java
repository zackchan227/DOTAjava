package Assets.Codes;

import java.awt.*;
import java.awt.event.KeyEvent;


public class MenuState extends State {


    private int currentChoice = 0;
    private String[] options = {
            "Start",
            "Help",
            "Quit"
    };

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public MenuState(Game game) {
        super(game);
        Assets.init();

        titleColor = new Color(128, 0, 0);
        titleFont = new Font("Century Gothic", Font.PLAIN, 35);
        font = new Font("Arial", Font.PLAIN, 15);

    }


    @Override
    public void update() {
        // TODO Auto-generated method stub
        if (game.getKeyManager().enter) {
            select();
        }
        if (game.getKeyManager().up) {
            currentChoice--;
            if (currentChoice == -1) {
                currentChoice = options.length - 1;
            }
        }
        if (game.getKeyManager().down) {
            currentChoice++;
            if (currentChoice == options.length) {
                currentChoice = 0;
            }
        }


    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(Assets.background, 0, 0, null);
        //g.drawImage(Assets.buttonPlay, 165, 150, null);
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("DOTA GAME", 145, 60);

        //draw menu options
        g.setFont(font);
        for (int i = 0; i < options.length; i++) {
            if (i == currentChoice) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.yellow);
            }
            g.drawString(options[i], 225, 142 + i * 25);
        }
    }

    private void select() {
        if (currentChoice == 0) {
            State.setState(game.getGameState());
        }
        if (currentChoice == 1) {

        }
        if (currentChoice == 2) {
            System.exit(0);
        }
    }
}