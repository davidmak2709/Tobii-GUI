import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class UserInterface {
	private JFrame mainFrame;
	
	public UserInterface() {
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//cijeli prozor
		this.mainFrame = new JFrame("Reader");
		this.mainFrame.setContentPane(new BackgroundMain());;
		this.mainFrame.setSize(new Dimension(width,height));
		this.mainFrame.setLayout(new GridBagLayout());
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(70, 10, 20, 10);
		c.fill = GridBagConstraints.BOTH;
		
		// mainPane je onaj Panel gdje je slika knjige
		Background mainPane = new Background();
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 10;
		c.gridwidth = 10;
		c.fill = GridBagConstraints.BOTH;
		c.weightx=1;
		c.weighty=1;
		this.mainFrame.add(mainPane,c);
		
		
		
		
		JLabel label = new JLabel("Započni s čitanjem");
		label.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		
		JTextPane subtitlePane = new JTextPane();
		subtitlePane.setLayout(new GridBagLayout());
		subtitlePane.setEditable(false);
		subtitlePane.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		subtitlePane.add(label);
		
		
		
		
		c.gridx = 0;
		c.gridy = 10;
		c.gridheight = 3;
		c.fill = GridBagConstraints.VERTICAL;
		c.weightx=0;
		c.weighty=0;
		c.ipadx = 600;
		this.mainFrame.add(subtitlePane,c);
		
		
		this.mainFrame.setVisible(true);
	}
}
