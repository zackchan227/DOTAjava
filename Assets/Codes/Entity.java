package Assets.Codes;

import java.awt.Graphics;

public abstract class Entity {
    
    protected float x,y;
    protected short width, height;

    public Entity(float x, float y, short width, short height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public short getWidth() {
        return this.width;
    }

    public short getHeight() {
        return this.height;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setWidth(short w){
        this.width= w;
    }

    public void setHeight(short h){
        this.height = h;
    }

    public abstract void update();
    
    public abstract void paint(Graphics g);
}