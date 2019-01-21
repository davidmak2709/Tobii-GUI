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
	private JTextArea textPane;
	private JButton backButton;
	private JButton nextButton;
	
	public Background() {
		// TODO Auto-generated constructor stub		
		
		setLayout(new BorderLayout(30,0));
		Image image = null;
		
		/*** PREV BUTTON  ***/
		
		try {
			image = ImageIO.read(new File("./res/arrow_back.png"));
			image = image.getScaledInstance(90, 130, Image.SCALE_FAST);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		backButton = new JButton(new ImageIcon(image));
		backButton.setOpaque(false);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new BackButtonListener());

		
		JPanel backButtonPanel = new JPanel();
		backButtonPanel.setLayout(new BoxLayout(backButtonPanel, BoxLayout.X_AXIS));
		backButtonPanel.setOpaque(false);
		backButtonPanel.add(backButton);
		add(backButtonPanel,BorderLayout.WEST);
		
		/*** NEXT BUTTON  ***/
		
		
		try {
			image = ImageIO.read(new File("./res/arrow_next.png"));
			image = image.getScaledInstance(90, 130, Image.SCALE_FAST);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JButton nextButton = new JButton(new ImageIcon(image));
		nextButton.setOpaque(false);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.addMouseListener(new NextButtonListener());

		JPanel nextButtonPanel = new JPanel();
		nextButtonPanel.setLayout(new BoxLayout(nextButtonPanel, BoxLayout.X_AXIS));
		nextButtonPanel.setOpaque(false);
		nextButtonPanel.add(nextButton);
		
		add(nextButtonPanel,BorderLayout.EAST);
		
		
		/*** TEXT PANE ***/
		
		textPane = new JTextArea();
		
		textPane.setEditable(false);
		textPane.setBackground(new Color(255, 253, 221));
//		textPane.setBackground(Color.YELLOW);
		textPane.setWrapStyleWord(true);
		textPane.setLineWrap(true);
		textPane.setFont(new Font("TimesRoman", Font.BOLD, 16));
		
		scrollPane = new JScrollPane(textPane);
		scrollPane.setMaximumSize(new Dimension(1200,420));
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(35, 35));;
		
		JPanel panelText = new JPanel();
		panelText.setLayout(new BoxLayout(panelText, BoxLayout.X_AXIS));
		panelText.setOpaque(false);
		panelText.add(scrollPane);
		
		add(panelText,BorderLayout.CENTER);
		

	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.getImage();
        setOpaque(false);
        g.drawImage(image, -5, 30, this);
    }
    
    private void getImage() {
    	try {
			this.image = ImageIO.read(new File("./res/book.png"));
			this.image = this.image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }
    
    public JButton getNextButton() {
    	return nextButton;
    }
    
    public JButton getBackButton() {
    	return backButton;
    }
    
    public void setTextAreaText(String newText) {
    	this.textPane.setText(newText);
    	this.textPane.setCaretPosition(0);
    }
}
