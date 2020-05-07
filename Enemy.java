import java.awt.Graphics;

public class Enemy extends Entity {

    private Animation a;

    public Enemy(float x, float y) {
        super(x, y);
        a = new Animation(69, Assets.enemy_move_bot);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        a.update();
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(Assets.background, 0, 0, null);
        g.drawImage(a.getCurrentFrame(), (int)x, (int)y, null);
        

    }
}