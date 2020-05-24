package Assets.Codes;

import java.awt.Graphics; 

public class GameState extends State {

    private Player p;
    private Enemy e;
    private Animation a_top;
    private Animation a_bot;
    private Animation a_left;
    private Animation a_right;

    public GameState(Game game){
       super(game);
       p = new Player(game,223,160);
       a_top = new Animation(69, Assets.enemy_move_bot);
       a_bot = new Animation(69, Assets.enemy_move_top);
       a_right = new Animation(69, Assets.enemy_move_left);
       a_left = new Animation(69, Assets.enemy_move_right);
       //e = new Enemy(215,50);
    }

    public void update(){
       p.update();
       a_top.update();
       a_bot.update();
       a_left.update();
       a_right.update();
       //e.update();
    }

    public void paint(Graphics g){
      g.drawImage(Assets.background, 0, 0, null);
      g.drawImage(a_top.getCurrentFrame(),215,30,null);
      g.drawImage(a_bot.getCurrentFrame(),215,210,null);
      g.drawImage(a_left.getCurrentFrame(),35,130,null);
      g.drawImage(a_right.getCurrentFrame(),400,130,null);
      p.paint(g);
      //e.paint(g);
    }
}