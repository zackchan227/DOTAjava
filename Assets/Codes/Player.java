package Assets.Codes;

import java.awt.Graphics;

public class Player extends Entity {

    private Animation a;
    private Game g;

    public Player(Game g, float x, float y) {
        super(x, y);
        this.g = g;
        Assets.init();
        a = new Animation(69, Assets.player_idle_front);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
       
        if(g.getKeyManager().up){
            a = new Animation(69, Assets.player_idle_back);
        }
        if(g.getKeyManager().down){
            a = new Animation(69, Assets.player_idle_front);
        }
        if(g.getKeyManager().left){
            a = new Animation(69, Assets.player_idle_left);
        }
        if(g.getKeyManager().right){
            a = new Animation(69, Assets.player_idle_right);
        }
        a.update();
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        
        g.drawImage(a.getCurrentFrame(), (int)x, (int)y, null);
        

    }
}