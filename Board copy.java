import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
  

public class Board extends JPanel implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Image bg;
    //private Image player, enemy;
    private Image player_idle_front[], player_idle_back[], player_idle_left[], player_idle_right[];
    private Image player_attack_front[], player_attack_back[], player_attack_left[], player_attack_right[];
    private Image enemy_left[], enemy_right[], enemy_front[], enemy_back[];
    private final int DELAY = 50;
    private Timer timer;
    private int i = 0, j = 0, k = 0;
    private int x,y;
    private int x1 = 223, y1 = 160;
    private int x2 = 208, y2 = 160;
    private int x3 = 208, y3 = 130;
    private int x4 = 230, y4 = 140;
    private int x5 = 223, y5 = 160;
    private int x6 = 225, y6 = 160;
    private int x7 = 175, y7 = 140;
    private int xx = 370, yy = 120;
    private int xx1 = 40, yy1 = 145;

    private boolean left = false;
	private boolean right = false;
	private boolean up = false;
    private boolean down = false;

    private boolean facingLeft = false;
	private boolean facingRight = false;
	private boolean facingUp = false;
    private boolean facingDown = false;

    private boolean isGameOver = false;
    private boolean isPause = false;

    private JFrame window = new JFrame();

    private Player player;
    private List<Enemy> enemies;
    
    public Board() {

        initBoard();
    }
    
    private void initBoard() {
        
        this.setFocusable(true);
		this.addKeyListener(new CustomKeyListener());
		this.setFocusTraversalKeysEnabled(false);
		window.add(this);
		window.setSize(480,360);
		window.setLocationRelativeTo(null);
		window.setTitle("DOTA");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadImage();
        
        int w = bg.getWidth(this);
        int h =  bg.getHeight(this);
        setPreferredSize(new Dimension(w, h));  
        
        player = new Player(x,y);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initEnemies() {
        
        enemies = new ArrayList<>();
        enemies.add(new Enemy(xx1, yy1));
    }
    
    private void loadImage() {
        
        ImageIcon bg1 = new ImageIcon("Images/BackGround/bg_level_1.png");
        ImageIcon idlef1 = new ImageIcon("Images/Player/Zeus/zeus_idle_front_1.png");
        ImageIcon idlef2 = new ImageIcon("Images/Player/Zeus/zeus_idle_front_2.png");
        ImageIcon idlef3 = new ImageIcon("Images/Player/Zeus/zeus_idle_front_3.png");

        ImageIcon idleb1 = new ImageIcon("Images/Player/Zeus/zeus_idle_back_1.png");
        ImageIcon idleb2 = new ImageIcon("Images/Player/Zeus/zeus_idle_back_2.png");
        ImageIcon idleb3 = new ImageIcon("Images/Player/Zeus/zeus_idle_back_3.png");

        ImageIcon idlel1 = new ImageIcon("Images/Player/Zeus/zeus_idle_left_1.png");
        ImageIcon idlel2 = new ImageIcon("Images/Player/Zeus/zeus_idle_left_2.png");
        ImageIcon idlel3 = new ImageIcon("Images/Player/Zeus/zeus_idle_left_3.png");

        ImageIcon idler1 = new ImageIcon("Images/Player/Zeus/zeus_idle_right_1.png");
        ImageIcon idler2 = new ImageIcon("Images/Player/Zeus/zeus_idle_right_2.png");
        ImageIcon idler3 = new ImageIcon("Images/Player/Zeus/zeus_idle_right_3.png");

        ImageIcon attackf1 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_1.png");
        ImageIcon attackf2 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_2.png");
        ImageIcon attackf3 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_3.png");
        ImageIcon attackf4 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_4.png");
        ImageIcon attackf5 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_5.png");
        ImageIcon attackf6 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_6.png");
        ImageIcon attackf7 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_7.png");
        ImageIcon attackf8 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_8.png");
        ImageIcon attackf9 = new ImageIcon("Images/Player/Zeus/zeus_attack_front_9.png");

        ImageIcon attackb1 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_1.png");
        ImageIcon attackb2 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_2.png");
        ImageIcon attackb3 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_3.png");
        ImageIcon attackb4 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_4.png");
        ImageIcon attackb5 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_5.png");
        ImageIcon attackb6 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_6.png");
        ImageIcon attackb7 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_7.png");
        ImageIcon attackb8 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_8.png");
        ImageIcon attackb9 = new ImageIcon("Images/Player/Zeus/zeus_attack_back_9.png");

        ImageIcon attackl1 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_1.png");
        ImageIcon attackl2 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_2.png");
        ImageIcon attackl3 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_3.png");
        ImageIcon attackl4 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_4.png");
        ImageIcon attackl5 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_5.png");
        ImageIcon attackl6 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_6.png");
        ImageIcon attackl7 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_7.png");
        ImageIcon attackl8 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_8.png");
        ImageIcon attackl9 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_9.png");
        ImageIcon attackl10 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_10.png");
        ImageIcon attackl11 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_11.png");
        ImageIcon attackl12 = new ImageIcon("Images/Player/Zeus/zeus_attack_left_12.png");

        ImageIcon attackr1 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_1.png");
        ImageIcon attackr2 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_2.png");
        ImageIcon attackr3 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_3.png");
        ImageIcon attackr4 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_4.png");
        ImageIcon attackr5 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_5.png");
        ImageIcon attackr6 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_6.png");
        ImageIcon attackr7 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_7.png");
        ImageIcon attackr8 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_8.png");
        ImageIcon attackr9 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_9.png");
        ImageIcon attackr10 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_10.png");
        ImageIcon attackr11 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_11.png");
        ImageIcon attackr12 = new ImageIcon("Images/Player/Zeus/zeus_attack_right_12.png");

        ImageIcon enemyl1 = new ImageIcon("Images/Creep/tile000.png");
        ImageIcon enemyl2 = new ImageIcon("Images/Creep/tile003.png");
        ImageIcon enemyl3 = new ImageIcon("Images/Creep/tile006.png");
        ImageIcon enemyl4 = new ImageIcon("Images/Creep/tile009.png");
        ImageIcon enemyl5 = new ImageIcon("Images/Creep/tile012.png");
        ImageIcon enemyl6 = new ImageIcon("Images/Creep/tile015.png");
        ImageIcon enemyl7 = new ImageIcon("Images/Creep/tile018.png");
        ImageIcon enemyl8 = new ImageIcon("Images/Creep/tile021.png");
        ImageIcon enemyl9 = new ImageIcon("Images/Creep/tile024.png");

        ImageIcon enemyr1 = new ImageIcon("Images/Creep/mushroom_right_1.png");
        ImageIcon enemyr2 = new ImageIcon("Images/Creep/mushroom_right_2.png");
        ImageIcon enemyr3 = new ImageIcon("Images/Creep/mushroom_right_3.png");
        ImageIcon enemyr4 = new ImageIcon("Images/Creep/mushroom_right_4.png");
        ImageIcon enemyr5 = new ImageIcon("Images/Creep/mushroom_right_5.png");
        ImageIcon enemyr6 = new ImageIcon("Images/Creep/mushroom_right_6.png");
        ImageIcon enemyr7 = new ImageIcon("Images/Creep/mushroom_right_7.png");
        ImageIcon enemyr8 = new ImageIcon("Images/Creep/mushroom_right_8.png");
        ImageIcon enemyr9 = new ImageIcon("Images/Creep/mushroom_right_9.png");


        bg = bg1.getImage();       
        player_idle_front = new Image[]{idlef1.getImage(), idlef2.getImage(), idlef3.getImage()};
        player_idle_back = new Image[]{idleb1.getImage(), idleb2.getImage(), idleb3.getImage()};
        player_idle_left = new Image[]{idlel1.getImage(), idlel2.getImage(), idlel3.getImage()};
        player_idle_right = new Image[]{idler1.getImage(), idler2.getImage(), idler3.getImage()};
        player_attack_front = new Image[]{attackf1.getImage(), attackf2.getImage(), attackf3.getImage(),
                                    attackf4.getImage(), attackf5.getImage(), attackf6.getImage(),
                                    attackf7.getImage(), attackf8.getImage(), attackf9.getImage()};
        player_attack_back = new Image[]{attackb1.getImage(), attackb2.getImage(), attackb3.getImage(),
                                    attackb4.getImage(), attackb5.getImage(), attackb6.getImage(),
                                    attackb7.getImage(), attackb8.getImage(), attackb9.getImage()};
        player_attack_left = new Image[]{attackl1.getImage(), attackl2.getImage(), attackl3.getImage(),
                                    attackl4.getImage(), attackl5.getImage(), attackl6.getImage(),
                                    attackl7.getImage(), attackl8.getImage(), attackl9.getImage(),
                                    attackl10.getImage(), attackl11.getImage(), attackl12.getImage()};
        player_attack_right = new Image[]{attackr1.getImage(), attackr2.getImage(), attackr3.getImage(),
                                    attackr4.getImage(), attackr5.getImage(), attackr6.getImage(),
                                    attackr7.getImage(), attackr8.getImage(), attackr9.getImage(),
                                    attackr10.getImage(), attackr11.getImage(), attackr12.getImage()}; 

        enemy_left = new Image[]{enemyl1.getImage(), enemyl2.getImage(), enemyl3.getImage(),
                                enemyl4.getImage(), enemyl5.getImage(), enemyl6.getImage(),
                                enemyl7.getImage(), enemyl8.getImage(), enemyl9.getImage()};
                                    
        enemy_right = new Image[]{enemyr1.getImage(), enemyr2.getImage(), enemyr3.getImage(),
                                enemyr4.getImage(), enemyr5.getImage(), enemyr6.getImage(),
                                enemyr7.getImage(), enemyr8.getImage(), enemyr9.getImage()};
        
    }

    public void paintComponent(Graphics g) {
       
        g.drawImage(bg, 0, 0, null);
        //g.drawImage(player, x, y, null);
        g.drawImage(enemy_left[j],xx,yy,null);
        g.drawImage(enemy_right[j],xx1,yy1,null);
    }

    public void actionPerformed(ActionEvent e) {
        
        // if(up){
        //     player = player_attack_back[i];    
        //     x = x3;
        //     y = y3;
        //     repaint();
        //     i++;
        //     if(i > 8){
        //         i = 0;
        //         up = false;
        //     } 
        // }

        // else if(!up && facingUp){
        //     player = player_idle_back[i];
        //     x = x1;
        //     y = y1;
        //     repaint();
        //     i++;
        //     if(i > 2) i = 0;   
        // }

        // else if(right){
        //     player = player_attack_right[k];    
        //     x = x4;
        //     y = y4;
        //     repaint();
        //     k++;
        //     if(k > 11){
        //         k = 0;
        //         right = false;
        //     } 
        // }   

        // else if(!right && facingRight){
        //     player = player_idle_right[i];    
        //     x = x5;
        //     y = y5;
        //     repaint();
        //     i++;
        //     if(i > 2) i = 0; 
        // }   

        // else if(left){
        //     player = player_attack_left[k];    
        //     x = x7;
        //     y = y7;
        //     repaint();
        //     k++;
        //     if(k > 11){
        //         k = 0;
        //         left = false;
        //     } 
        // }   

        // else if(!left && facingLeft){
        //     player = player_idle_left[i];    
        //     x = x6;
        //     y = y6;
        //     repaint();
        //     i++;
        //     if(i > 2) i = 0; 
        // }   
       
        // else if(down){
        //     player = player_attack_front[i];    
        //     x = x2;
        //     y = y2;
        //     repaint();
        //     i++;
        //     if(i > 8){
        //         i = 0;
        //         down = false;
        //     } 
        // }   

        // else if(!down && facingDown){
        //     player = player_idle_front[i];
        //     x = x1;
        //     y = y1;
        //     repaint();
        //     i++;
        //     if(i > 2) i = 0;   
        // }

        // else{
        //     player = player_idle_front[i];
        //     x = x1;
        //     y = y1;
        //     repaint();
        //     i++;
        //     if(i > 2) i = 0;  
        // }

        // xx1++;
        // xx--;
        // repaint();
        // j++;
        // if(j > 8) j = 0;
    }
    class CustomKeyListener implements KeyListener{
        public void keyTyped(KeyEvent e) {
        }
  
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                down = true;
                up = false;
                right = false;
                left = false;
                facingDown = true;
                facingLeft = false;
                facingRight = false;
                facingUp = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_UP){
                up = true;
                right = false;
                left = false;
                down = false;
                facingUp = true;
                facingDown = false;
                facingLeft = false;
                facingRight = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                right = true;
                left = false;
                down = false;
                up = false;
                facingDown = false;
                facingLeft = false;
                facingRight = true;
                facingUp = false;
            }
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                left = true;
                down = false;
                up = false;
                right = false;
                facingDown = false;
                facingLeft = true;
                facingRight = false;
                facingUp = false;
            }
        }
  
        public void keyReleased(KeyEvent e) {
            // if(e.getKeyCode() == KeyEvent.VK_DOWN){
            //     down = false;
            // }
            // if(e.getKeyCode() == KeyEvent.VK_UP){
            //     up = false;
            // }
            // if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            //     right = false;
            // }
            // if(e.getKeyCode() == KeyEvent.VK_LEFT){
            //     left = false;
            // }
        }   

        
     }
    
}