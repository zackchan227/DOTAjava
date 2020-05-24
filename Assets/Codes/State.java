package Assets.Codes;

import java.awt.Graphics;

public abstract class State {

    private static State currentState = null;

    public static void setState(State s){
        currentState = s;
    }

    public static State getState(){
        return currentState;
    }

    protected Game game;

    public State(Game game){
        this.game = game;
    }

    public abstract void update();
    public abstract void paint(Graphics g);
}