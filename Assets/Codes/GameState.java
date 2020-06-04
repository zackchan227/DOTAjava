package Assets.Codes;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameState extends State {

    private Player p;
    private Enemy e_top;
    private Enemy e_bot;
    private Enemy e_left;
    private Enemy e_right;
    private ArrayList<Enemy> enemies;

    public GameState(Game game){
        super(game);
        enemies = new ArrayList<Enemy>();
        p = new Player(game,223,160,(short)32,(short)32);
        e_top = new Enemy(game,215,30,(short)32,(short)32,(short)1);
        e_bot = new Enemy(game,215,210,(short)32,(short)32,(short)2);
        e_left = new Enemy(game,35,130,(short)32,(short)32,(short)3);
        e_right = new Enemy(game,400,130,(short)32,(short)32,(short)4);
        enemies.add(e_right);
        enemies.add(e_left);
        enemies.add(e_top);
        enemies.add(e_bot);
    }

    public void update(){
        p.update();
        p.checkAttack(enemies);
        e_top.update();
        e_bot.update();
        e_left.update();
        e_right.update();
    }

    public void paint(Graphics g){
        g.drawImage(Assets.background, 0, 0, null);
        p.paint(g);
        e_top.paint(g);
        e_bot.paint(g);
        e_left.paint(g);
        e_right.paint(g);
    }
}