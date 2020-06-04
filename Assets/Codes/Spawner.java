package Assets.Codes;

import java.awt.Graphics;

public class Spawner extends Entity {
    private Enemy[] ales;
    private Game game;

    public Spawner(Game g, float x, float y) {
        super(x,y);
        this.game = g;
        
    }

    public double getRandomNumber() {
        double x = Math.random();
        return x;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub

    }
}