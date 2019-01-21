import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	/**
	 *  Glavni Frame
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Background panel;


	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setSize(new Dimension(1000, 700));
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0,1));
		setContentPane(contentPane);
		
		BackgroundMain splitPane = new BackgroundMain();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerSize(0);
		splitPane.setResizeWeight(1.0);
		contentPane.add(splitPane);
		
		panel = new Background();
		panel.setMinimumSize(new Dimension(getWidth(), (int) (getHeight() * 0.8)));
		splitPane.setTopComponent(panel);

		
		JLabel label = new JLabel("Započni s čitanjem");
		label.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		
		JTextPane subtitlePane = new JTextPane();
		subtitlePane.setLayout(new GridBagLayout());
		subtitlePane.setMinimumSize(new Dimension((int) (getWidth()*0.7), (int) (getHeight()*0.1)));
		subtitlePane.setMaximumSize(new Dimension((int) (getWidth()*0.7), (int) (getHeight()*0.1)));
		subtitlePane.setEditable(false);
		subtitlePane.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		subtitlePane.add(label);
		
		JPanel panel_tit = new JPanel();
		panel_tit.setLayout(new BoxLayout(panel_tit,BoxLayout.Y_AXIS));
		panel_tit.setOpaque(false);
		panel_tit.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_tit.add(subtitlePane);
		splitPane.setBottomComponent(panel_tit);
		
		pack();

	}
	
	public Background getPanel() {
		return panel;
	}
	
	public void setTextAreaText(String newText) {
		panel.setTextAreaText(newText);
	}

}
