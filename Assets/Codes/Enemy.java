package Assets.Codes;

import java.awt.Graphics;

public class Enemy extends Entity {

    private Animation a;
    private Game game;
    private short direction;
    private float movement;

    public Enemy(Game g, float x, float y, short w, short h, short direct) {
        super(x, y, w, h);
        this.game = g;
        Assets.init();
        this.direction = direct;
        switch (direction) {
            case 1:
                a = new Animation(69, Assets.enemy_move_bot);
                break;
            case 2:
                a = new Animation(69, Assets.enemy_move_top);
                break;
            case 3:
                a = new Animation(69, Assets.enemy_move_right);
                break;
            case 4:
                a = new Animation(69, Assets.enemy_move_left);
                break;
            default:
                break;
        }
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        a.update();
        switch (direction) {
            case 1:
                this.setY(this.getY() + 0.05f);
                break;
            case 2:
                this.setY(this.getY() - 0.05f);
                break;
            case 3:
                this.setX(this.getX() + 0.1f);
                break;
            case 4:
                this.setX(this.getX() - 0.1f);
                break;
            default:
                break;

        }
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        g.drawImage(a.getCurrentFrame(), (int) x, (int) y, null);
    }
}