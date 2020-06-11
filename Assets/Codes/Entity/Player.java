package Assets.Codes.Entity;

import Assets.Codes.Manager.Assets;
import Assets.Codes.Audio.Audio;
import Assets.Codes.GameState.Game;

import java.awt.Graphics;

public class Player extends Entity {

    private Animation a;
    private Game game;
    private Audio au;
    private boolean isFaceFront, isFaceBack, isFaceRight, isFaceLeft;
    private int score = 0;
    private int highScore = 0;
    private boolean isDead;
    private int tap;
    private int attackRange = 50;

    public static final short fps = 100;

    public static final float DEFAULT_X = 223.0f;
    public static final float DEFAULT_Y = 160.0f;

    public Player(Game g, float x, float y) {
        super(x, y);
        this.game = g;
        Assets.init();
        a = new Animation(fps, Assets.player_idle_front);
        isFaceBack = false;
        isFaceFront = true;
        isFaceLeft = false;
        isFaceRight = false;
        tap = 0;
        isDead = false;
        au = new Audio();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

        if (game.getKeyManager().up) {
            tap++;
            this.resetPosition();
            isFaceBack = true;
            isFaceFront = false;
            isFaceLeft = false;
            isFaceRight = false;
            a = new Animation(fps, Assets.player_attack_back);
        } else if (a.getCurrentFrameIndex() == 3 && isFaceBack) {
            this.setY(125);
        } else if (a.getCurrentFrameIndex() == 8 && isFaceBack) {
            this.resetPosition();
            a = new Animation(fps, Assets.player_idle_back);
        }

        if (game.getKeyManager().down) {
            tap++;
            this.resetPosition();
            isFaceBack = false;
            isFaceFront = true;
            isFaceLeft = false;
            isFaceRight = false;
            a = new Animation(fps, Assets.player_attack_front);
        } else if (a.getCurrentFrameIndex() == 3 && isFaceFront) {
            this.setY(160);
        } else if (a.getCurrentFrameIndex() == 8 && isFaceFront) {
            this.resetPosition();
            a = new Animation(fps, Assets.player_idle_front);
        }

        if (game.getKeyManager().left) {
            tap++;
            this.resetPosition();
            isFaceBack = false;
            isFaceFront = false;
            isFaceLeft = true;
            isFaceRight = false;
            a = new Animation(fps, Assets.player_attack_left);
            this.setX(178);
            this.setY(139);
        } else if (a.getCurrentFrameIndex() == 8 && isFaceLeft) {
            this.resetPosition();
            a = new Animation(fps, Assets.player_idle_left);
        }

        if (game.getKeyManager().right) {
            tap++;
            this.resetPosition();
            isFaceBack = false;
            isFaceFront = false;
            isFaceLeft = false;
            isFaceRight = true;
            a = new Animation(fps, Assets.player_attack_right);
            this.setX(228);
            this.setY(138);
        } else if (a.getCurrentFrameIndex() == 8 && isFaceRight) {
            this.resetPosition();
            a = new Animation(fps, Assets.player_idle_right);
        }

        if (score > highScore) {
            highScore = score;
        }
        a.update();
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub

        g.drawImage(a.getCurrentFrame(), (int) x, (int) y, null);

    }

    public boolean checkAttack(Enemy e) {
        if (e.getDirection() == 4) {
            if (this.game.getKeyManager().right && e.getX() > 223.0F && e.getX() < (float) (223 + this.attackRange)) {
                au.playOneShot("coins.wav");
                ++this.score;
                return true;
            }

            if (e.getX() <= 223.0F) {
                isDead = true;
            }
        }

        if (e.getDirection() == 3) {
            if (this.game.getKeyManager().left && e.getX() < 223.0F && e.getX() > (float) (223 - this.attackRange)) {
                au.playOneShot("coins.wav");
                ++this.score;
                return true;
            }

            if (e.getX() >= 223.0F) {
                isDead = true;
            }
        }

        if (e.getDirection() == 1) {
            if (this.game.getKeyManager().up && e.getY() < 130.0F && e.getY() > (float) (130 - this.attackRange)) {
                au.playOneShot("coins.wav");
                ++this.score;
                return true;
            }

            if (e.getY() >= 130.0F) {
                isDead = true;
            }
        }

        if (e.getDirection() == 2) {
            if (this.game.getKeyManager().down && e.getY() > 130.0F && e.getY() < (float) (130 + this.attackRange)) {
                au.playOneShot("coins.wav");
                ++this.score;
                return true;
            }
            if (e.getY() <= 130.0F) {
                isDead = true;
            }
        }
        return false;
    }

    public void resetPosition() {
        this.setX(DEFAULT_X);
        this.setY(DEFAULT_Y);
    }

    public int getScore() {
        return this.score;
    }

    public int getHighScore() {
        return highScore;
    }

    public int getTap() {
        return this.tap;
    }

    public boolean isDead() {
        return this.isDead;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setHighScore(int hscore) {
        this.highScore = hscore;
    }
}