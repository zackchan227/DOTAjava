import java.awt.Graphics;

public class Player extends Entity {

    private Animation a;

    public Player(float x, float y) {
        super(x, y);
        Assets.init();
        a = new Animation(69, Assets.player_idle_front);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        a.update();
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        
        g.drawImage(a.getCurrentFrame(), (int)x, (int)y, null);
        

    }
}