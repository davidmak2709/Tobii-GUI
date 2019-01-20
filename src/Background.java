import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Background extends JPanel {
	/**
	 * 
	 * Onaj glavni block knjiga i buttoni su ovdje
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	
	public Background() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout(30,0));
		Image image = null;
		try {
			image = ImageIO.read(new File("./res/arrow_back.png"));
			image = image.getScaledInstance(90, 130, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton backButton = new JButton(new ImageIcon(image));
		backButton.setOpaque(false);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);

		
		add(backButton,BorderLayout.WEST);
		
		
		
		JTextArea textPane = new JTextArea();
		
		textPane.setEditable(false);
		textPane.setBackground(new Color(255, 253, 221));
//		textPane.setBackground(Color.YELLOW);
		textPane.setWrapStyleWord(true);
		textPane.setLineWrap(true);
		textPane.setFont(new Font("TimesRoman", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane(textPane); 
		scrollPane.setMaximumSize(new Dimension(1200,450));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		JPanel panelText = new JPanel();
		panelText.setLayout(new BoxLayout(panelText, BoxLayout.LINE_AXIS));
		panelText.setOpaque(false);
		panelText.add(scrollPane);
		
		add(panelText,BorderLayout.CENTER);
		
		try {
			image = ImageIO.read(new File("./res/arrow_next.png"));
			image = image.getScaledInstance(90, 130, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JButton nextButton = new JButton(new ImageIcon(image));
		nextButton.setOpaque(false);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);

		add(nextButton,BorderLayout.EAST);
	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.getImage();
        setOpaque(false);
        g.drawImage(image, 0, 30, this);
    }
    
    private void getImage() {
    	try {
			this.image = ImageIO.read(new File("./res/book.png"));
			this.image = this.image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
