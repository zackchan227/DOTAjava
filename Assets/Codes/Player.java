package Assets.Codes;

import java.awt.Graphics;

public class Player extends Entity {

    private Animation a;
    private Game g;
    private boolean isFaceFront, isFaceBack, isFaceRight, isFaceLeft;

    public static final float DEFAULT_X = 223.0f;
    public static final float DEFAULT_Y = 160.0f;

    public Player(Game g, float x, float y, short w, short h) {
        super(x, y, w, h);
        this.g = g;
        Assets.init();
        a = new Animation(69, Assets.player_idle_front);
        isFaceBack = false;
        isFaceFront = true;
        isFaceLeft = false;
        isFaceRight = false;
    }

    public void resetPosition(){
        this.setX(DEFAULT_X);
        this.setY(DEFAULT_Y);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

        if (g.getKeyManager().up) {
            isFaceBack = true;
            isFaceFront = false;
            isFaceLeft = false;
            isFaceRight = false;
            a = new Animation(69, Assets.player_attack_back);
        } else if (a.getCurrentFrameIndex() == 3 && isFaceBack) {
            this.setY(125);
        } else if (a.getCurrentFrameIndex() == 8 && isFaceBack) {
            this.resetPosition();
            a = new Animation(69, Assets.player_idle_back);
        }

        if (g.getKeyManager().down) {
            isFaceBack = false;
            isFaceFront = true;
            isFaceLeft = false;
            isFaceRight = false;
            a = new Animation(69, Assets.player_attack_front);
        } else if (a.getCurrentFrameIndex() == 3 && isFaceFront) {
            this.setY(160);
        } else if (a.getCurrentFrameIndex() == 8 && isFaceFront) {
            this.resetPosition();
            a = new Animation(69, Assets.player_idle_front);
        }

        if (g.getKeyManager().left) {
            isFaceBack = false;
            isFaceFront = false;
            isFaceLeft = true;
            isFaceRight = false;
            a = new Animation(69, Assets.player_attack_left);
            this.setX(178);
            this.setY(139);
        } else if (a.getCurrentFrameIndex() == 8 && isFaceLeft) {
            this.resetPosition();
            a = new Animation(69, Assets.player_idle_left);
        }

        if (g.getKeyManager().right) {
            isFaceBack = false;
            isFaceFront = false;
            isFaceLeft = false;
            isFaceRight = true;
            a = new Animation(69, Assets.player_attack_right);
            this.setX(228);
            this.setY(138);
        } else if (a.getCurrentFrameIndex() == 8 && isFaceRight) {
            this.resetPosition();
            a = new Animation(69, Assets.player_idle_right);
        }

        a.update();
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub

        g.drawImage(a.getCurrentFrame(), (int) x, (int) y, null);

    }
}