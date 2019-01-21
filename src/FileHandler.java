import java.io.File;
import java.io.IOException;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;



public class FileHandler {
	private File selectedFile;
	private String text;
	private int page=1;
	private int totalPage=0;
	
	public FileHandler(File selectedFile) {
		this.selectedFile = selectedFile;
	}
	

	public void file() {
		PDDocument document;
		PDFTextStripper stripper;
		try {
			document = PDDocument.load(selectedFile);
			this.totalPage = document.getNumberOfPages();
			stripper = new PDFTextStripper();
			stripper.setStartPage(page);
			stripper.setEndPage(page);
			this.text = stripper.getText(document);
			document.close();
		} catch (IOException e) {
			e.printStackTrace();
			
		}	
	}

	public String getText() {
		return text;
	}
	
	public void incrementPage() {
		if(this.page +1 <= this.totalPage ) {
			this.page++;
			this.file();
		}
	}
	
	public void decrementPage() {
		if(this.page - 1 > 0 ) {
			this.page--;
			this.file();
		}
	}
	public File getSelectedFile() {
		return selectedFile;
	}
	
	
}