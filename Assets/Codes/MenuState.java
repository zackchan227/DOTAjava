package Assets.Codes;

import java.awt.Graphics;


public class MenuState extends State {


    public MenuState(Game game){
        super(game);
        Assets.init();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub


    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(Assets.background, 0, 0, null);
        //g.drawImage(Assets.buttonPlay, 165, 150, null);
          

    }

}