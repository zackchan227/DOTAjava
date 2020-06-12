package Assets.Codes.Manager;

import Assets.Codes.GameState.GameState;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener{

    private boolean playPressed, helpPressed, quitPressed, pausePressed;

    public MouseManager(){
    }

    public boolean isPlayPressed() {
        return playPressed;
    }

    public boolean isHelpPressed() {
        return helpPressed;
    }

    public boolean isQuitPressed() {
        return quitPressed;
    }

    public boolean isPausePressed() {
        return pausePressed;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getX() >= 420 && e.getX() <= 460) {
            if (e.getY() >= 15 && e.getY() <= 50) {
                pausePressed = true;
            }
        }
        if(!GameState.isRunning()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
            if (e.getX() >= 200 && e.getX() <= 280) {
                if (e.getY() >= 130 && e.getY() <= 170) {
                    playPressed = true;
                } else if (e.getY() >= 180 && e.getY() <= 220) {
                    helpPressed = true;
                } else if (e.getY() >= 230 && e.getY() <= 270) {
                    quitPressed = true;
                }
            }
        }





    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getX() >= 420 && e.getX() <= 460) {
            if (e.getY() >= 15 && e.getY() <= 50) {
                pausePressed = false;
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        if(!GameState.isRunning()) {
            if (e.getX() > 200 && e.getX() <= 280) {
                if (e.getY() >= 130 && e.getY() <= 170) {
                    playPressed = false;
                }
                else if (e.getY() >= 180 && e.getY() <= 220) {
                    helpPressed = false;
                }
                else if (e.getY() >= 230 && e.getY() <= 270) {
                    quitPressed = false;
                }
            }
        }




    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }



    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}