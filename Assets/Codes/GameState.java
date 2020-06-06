package Assets.Codes;

import java.awt.Graphics;

public class GameState extends State {

    private Player p;
    private Controller c;

    public GameState(Game game){
        super(game);
        p = new Player(game,223,160);
        c = new Controller();
    }

    public void update(){
        p.update();
        c.update(p);
    }

    public void paint(Graphics g){
        g.drawImage(Assets.background, 0, 0, null);
        p.paint(g);
        c.paint(g);
    }
}