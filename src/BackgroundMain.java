import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JSplitPane;

public class BackgroundMain extends JSplitPane {
	/**
	 * Ona slika iza s nebom....
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.getImage();
        g.drawImage(image, 0, 0, this);
    }
    
    private void getImage() {
    	try {
			this.image = ImageIO.read(new File("./res//background.jpg"));
			this.image = this.image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

