import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Window {

    private JFrame window;
    private Canvas canvas;
    
    private int width = 480, height = 360;

    public Window(){
        createWindow();
    }

    private void createWindow(){
        window = new JFrame();
        window.setSize(width,height);
        window.setLocationRelativeTo(null);
		window.setTitle("DOTA");
		window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        
        window.add(canvas);
        window.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

	public JFrame getFrame() {
		return window;
    }

}