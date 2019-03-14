import java.awt.Color;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceDirectory;
import com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory;

class Reader implements Runnable{
	private Queue<String> buffer;
	private JTextPane subtitle;
	private JTextArea text;
	private String w;
	private int current = 0;
	private Highlighter highlighter = null;
		
	public Reader(Queue<String> queue, JTextPane sub, JTextArea text) {
		// TODO Auto-generated constructor stub
		this.buffer = queue;
		this.subtitle = sub;
		this.text = text;
	}
	
    private boolean doStop = true;
    
    public synchronized void doStart() {
        this.doStop = false;
    }
    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }
    public void emptyQueue() {
    	
    	for(w = this.buffer.poll();	w != null; w=this.buffer.poll()) {	
    	}
    	if(highlighter != null) {
    		highlighter.removeAllHighlights();
    	}
		this.current = 0;
    	//System.out.println(this.buffer);
    }
    private void highlight() {
    	highlighter = this.text.getHighlighter();
        HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
        try {
			highlighter.addHighlight(0,this.current, painter);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String words="";		
		int size_of_buffer = 6;
		
		VoiceDirectory vd = new KevinVoiceDirectory();
		Voice[] voices = vd.getVoices();
		
		Voice voice = voices[0];
		voice.allocate();
//		VoiceManager voiceManager = VoiceManager.getInstance();
//		Voice voice = voiceManager.getVoice("kevin");
//		voice.allocate();
////		voice.setRate(120);

		while(true) {
			while(keepRunning()) {
				try {
					TimeUnit.MILLISECONDS.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(this.buffer.isEmpty() ==  false) {
					words= "";
					//System.out.println(this.buffer);

					for(int i = 0; i < size_of_buffer; i++) {
						w = this.buffer.poll();	
						words += " " + w;						
						this.current += w.length() + 1;		
					}
					this.highlight();
					this.subtitle.setText("<html><center><b><font size=28>" + words.replace('\n', ' ') + "</font></b></center></html>");			
				}
				else {
					this.doStop();
				}
				//System.out.println(words);
				voice.speak(words);
			}
		}
	}
	
}