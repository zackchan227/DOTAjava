package Assets.Codes;

import java.awt.*;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Enemy tempEnemy;
    private GameState gameState;
    private Level level;

    public Controller(GameState gs,Level lv) {
        AddEnemiesThread add = new AddEnemiesThread();
        add.start();
        gameState = gs;
        level = lv;
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
            if (p.checkAttack(tempEnemy)) {
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

    public class AddEnemiesThread extends Thread {
        @Override
        public void run() {
            while (gameState.game.isRunning()) {
                if (!gameState.isPause()) {
                    int a = random(0, 3);

                    if (a == 0) {
                        addEnemy(new Enemy(215f, 30f, (short) 1,level.changeLevel()));
                    } else if (a == 1) {
                        addEnemy(new Enemy(215f, 230f, (short) 2, level.changeLevel()));
                    } else if (a == 2) {
                        addEnemy(new Enemy(35f, 130f, (short) 3, level.changeLevel()));
                    } else if (a == 3) {
                        addEnemy(new Enemy(400f, 130f, (short) 4, level.changeLevel()));
                    }
                }

                try {
                    int timeDelay;
                    switch (level.changeLevel()) {
                        case 1:
                            timeDelay = random(100, 500);
                            // System.out.println(timeDelay);
                            break;
                        case 2:
                            timeDelay = random(100, 200);
                            break;
                        case 3:
                            timeDelay = random(50, 100);
                            break;
                        case 4:
                            timeDelay = random(1, 1);
                            break;
                        default:
                            timeDelay = random(500, 1000);
                            // System.out.println(timeDelay);
                            break;
                    }
                    Thread.sleep(timeDelay);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public int random(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

}
