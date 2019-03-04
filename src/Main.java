import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	
	public static void main(String[] args) {
		final FileHandler fileHandler = new FileHandler(FileChooser.selectFile());
		final GUI gui = new GUI();
		
		if(fileHandler.getSelectedFile() != null) {
			fileHandler.file();

			gui.setTextAreaText(fileHandler.getText());
		
			gui.getPanel().getBackButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fileHandler.decrementPage();
					gui.setIter();
					gui.setTextAreaText(fileHandler.getText());
				}
				
			});
			
			
			gui.getPanel().getNextButton().addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					fileHandler.incrementPage();
					gui.setIter();
					gui.setTextAreaText(fileHandler.getText());
				}
				
			});
			
			gui.setHighlighter();
		}
		
		//new GUI();
	}

}
