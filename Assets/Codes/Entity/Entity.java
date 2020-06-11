package Assets.Codes.Entity;

import java.awt.Graphics;

public abstract class Entity {
    
    protected float x,y;

    public Entity(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public abstract void update();
    
    public abstract void paint(Graphics g);
}