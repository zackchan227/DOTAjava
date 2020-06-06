package Assets.Codes;

import java.awt.Graphics;

public class Enemy extends Entity {

    private Animation a;
    private short direction;
    private float movementSpeed = 0.05f;

    public static final short fps = 20;

    public short getDirection() {
        return direction;
    }

    public Enemy(float x, float y, short direct) {
        super(x, y);
        Assets.init();
        this.direction = direct;
        switch (direction) {
            case 1:
                a = new Animation(fps, Assets.enemy_move_bot);
                break;
            case 2:
                a = new Animation(fps, Assets.enemy_move_top);
                break;
            case 3:
                a = new Animation(fps, Assets.enemy_move_right);
                break;
            case 4:
                a = new Animation(fps, Assets.enemy_move_left);
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
                this.setY(this.getY() + movementSpeed);
                break;
            case 2:
                this.setY(this.getY() - movementSpeed);
                break;
            case 3:
                this.setX(this.getX() + movementSpeed*2);
                break;
            case 4:
                this.setX(this.getX() - movementSpeed*2);
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