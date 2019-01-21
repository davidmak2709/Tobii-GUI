import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class BackButtonListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		
		Image image = null;
		try {
			image = ImageIO.read(new File("./res/arrow_back_clicked.png"));
			image = image.getScaledInstance(90, 130, Image.SCALE_SMOOTH);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		btn.setPressedIcon(new ImageIcon(image));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		
		Image image = null;
		try {
			image = ImageIO.read(new File("./res/arrow_back_selected.png"));
			image = image.getScaledInstance(90, 130, Image.SCALE_SMOOTH);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		btn.setRolloverIcon(new ImageIcon(image));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
