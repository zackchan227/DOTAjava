package Assets.Codes;

import java.awt.*;
import java.util.ArrayList;

public class Controller {

    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    Enemy tempEnemy;

    public Controller(){
        AddEnemiesThread add = new AddEnemiesThread();
        add.start();
    }

    public void paint(Graphics g) {
        for (int i = 0; i < enemies.size(); i++) {
            tempEnemy = enemies.get(i);
            tempEnemy.paint(g);
        }
    }


    public void update(Player p) {
        for (int i = 0; i < enemies.size(); i++) {
            tempEnemy = enemies.get(i);
            if(p.checkAttack(tempEnemy)){
                removeEnemy(tempEnemy);
            }
            tempEnemy.update();
        }
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public class AddEnemiesThread extends Thread{
        @Override
        public void run() {
            for(int i = 0; i < 50; i ++){
                int a = randomAdd();
                System.out.println(a);
                if(a == 0) {
                    addEnemy(new Enemy(215, 30, (short) 1));
                }else if(a==1){
                    addEnemy(new Enemy(215, 230,  (short) 2));
                }else if(a==2){
                    addEnemy( new Enemy( 35, 130,  (short) 3));
                }else{
                    addEnemy( new Enemy( 400, 130,  (short) 4));
                }
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public int randomAdd() {
        int max = 4;
        int min = 1;
        int range = (max - min) + 1;
        int randomNumber = (int) (Math.random() * range);
        return randomNumber;
    }

}
