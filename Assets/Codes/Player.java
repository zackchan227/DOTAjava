package Assets.Codes;

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class Player extends Entity {

    private Animation a;
    private Game game;
    private boolean isFaceFront, isFaceBack, isFaceRight, isFaceLeft;
    private int score;
    private int attackRange = 60;

    public static final float DEFAULT_X = 223.0f;
    public static final float DEFAULT_Y = 160.0f;

    public Player(Game g, float x, float y, short w, short h) {
        super(x, y, w, h);
        this.game = g;
        Assets.init();
        a = new Animation(69, Assets.player_idle_front);
        isFaceBack = false;
        isFaceFront = true;
        isFaceLeft = false;
        isFaceRight = false;
        score = 0;
    }

    public void resetPosition(){
        this.setX(DEFAULT_X);
        this.setY(DEFAULT_Y);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

        if (game.getKeyManager().up) {
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

        if (game.getKeyManager().down) {
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

        if (game.getKeyManager().left) {
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

        if (game.getKeyManager().right) {
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

    public void checkAttack(ArrayList<Enemy> enemies) {
        for(int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i);
            if(i == 0 ) {
                if (game.getKeyManager().right) {
                    if (
                            e.getX() > x
                                    && e.getX() < x + attackRange
                    ) {
                        score++;
                        e.setX(400);

                    }
                }
                if(e.getX() <= x ){
                    JOptionPane.showMessageDialog(null,score);
                    score = 0;
                    enemies.get(0).setX(400);
                    enemies.get(1).setX(20);
                    enemies.get(2).setY(20);
                    enemies.get(3).setY(230);
                }
            }
            if(i == 1 ) {
                if (game.getKeyManager().left) {
                    if (
                            e.getX() < x
                                    && e.getX() > x - attackRange
                    ) {
                        score++;
                        e.setX(20);
                    }
                }
                if(e.getX() >= x ){
                    JOptionPane.showMessageDialog(null,score);
                    score = 0;
                    enemies.get(0).setX(400);
                    enemies.get(1).setX(20);
                    enemies.get(2).setY(20);
                    enemies.get(3).setY(230);
                }
            }
            if(i == 2 ) {
                if (game.getKeyManager().up) {
                    if (
                            e.getY() < y
                                    && e.getY() > y - attackRange
                    ) {
                        score++;
                        e.setY(20);
                    }
                }
                if(e.getY() >= y ){
                    JOptionPane.showMessageDialog(null,score);
                    score = 0;
                    enemies.get(0).setX(400);
                    enemies.get(1).setX(20);
                    enemies.get(2).setY(20);
                    enemies.get(3).setY(230);

                }
            }
            if(i == 3 ) {
                if (game.getKeyManager().down) {
                    if (
                            e.getY() > y
                                    && e.getY() < y + attackRange
                    ) {
                        score++;
                        e.setY(230);
                    }
                }
                if(e.getY() <= y ){
                    JOptionPane.showMessageDialog(null,score);
                    score = 0;
                    enemies.get(0).setX(400);
                    enemies.get(1).setX(20);
                    enemies.get(2).setY(20);
                    enemies.get(3).setY(230);
                }
            }
        }
    }
}