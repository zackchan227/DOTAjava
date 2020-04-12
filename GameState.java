import java.awt.Graphics;
import javax.swing.*;   

public class GameState extends State {

    Animation a;

    public GameState(){
        Assets.init();
        a = new Animation(69, Assets.player_idle_front);
    }

    public void update(){
        a.update();
    }

    public void paint(Graphics g){
        g.drawImage(Assets.background, 0, 0, null);
        g.drawImage(a.getCurrentFrame(), 223, 160, null);
        
        
    }
}