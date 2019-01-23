import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {

	public FileChooser() {
		
	}
	
	public static File selectFile(){
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF docs only", "pdf");
		JFileChooser chooser = new JFileChooser();
		
		
		chooser.addChoosableFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setMultiSelectionEnabled(false);
		
		int retVal = chooser.showOpenDialog(new JFrame());
		
		if(retVal == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		} else if(retVal == JFileChooser.CANCEL_OPTION) {
			return null;
		} else {
			return null;
		}
		
	}
}