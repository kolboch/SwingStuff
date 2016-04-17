package firstSwing;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {

	private static final long serialVersionUID = 8887771L;
	private JTextArea textArea;
	
	public TextPanel(){
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		add(textArea);
		
		JScrollPane pane = new JScrollPane(textArea);
		add(pane , BorderLayout.CENTER);
		
	}
	
	public void clearTextArea(){
		textArea.setText("");
	}
	
	public void appendText(String text){
		
		textArea.append(text);
		
	}
	
}
