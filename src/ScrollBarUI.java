import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ScrollBarUI extends BasicScrollBarUI {
	
	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		g.setColor(new Color(222,137,73));
		g.fillRect((int) (thumbBounds.width*0.375), thumbBounds.y, (int) (thumbBounds.width*0.25), thumbBounds.height);
	}
	
	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor(new Color(255, 253, 221));
		g.fillRect(trackBounds.x, trackBounds.y,trackBounds.width, trackBounds.height);
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		JButton button = new JButton(getAppropriateIcon(orientation));
		button.setBackground(new Color(202,138,100));
		button.setBorder(new LineBorder(new Color(88,46,22)));
		
		return button;
	}
	
	@Override
	protected JButton createIncreaseButton(int orientation) {
		JButton button = new JButton(getAppropriateIcon(orientation));
		button.setBackground(new Color(202,138,100));
		button.setBorder(new LineBorder(new Color(88,46,22)));
		
		return button;
	}
	
	private ImageIcon getAppropriateIcon(int orientation){
 	  Image  image = null; 
	  switch(orientation){
          case SwingConstants.SOUTH: 
		  	try {
		  		image = ImageIO.read(new File("./res/arrow_down.png"));
      			image = image.getScaledInstance(25, 20, Image.SCALE_FAST);
  		  } catch (IOException e) {
      			e.printStackTrace();
  		  		}
		  	return new ImageIcon(image);
              
          case SwingConstants.NORTH: 
		  	try {
		  		image = ImageIO.read(new File("./res/arrow_up.png"));
    			image = image.getScaledInstance(25, 20, Image.SCALE_FAST);
		  } catch (IOException e) {
			  	e.printStackTrace();
    			}
		  	return new ImageIcon(image);
              
          default:
        	  return null;
          }
      }
}
