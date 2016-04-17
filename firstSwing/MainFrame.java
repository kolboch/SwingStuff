package firstSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private BottomButtonPanel bottomPanel;
	private TopButtonPanel topPanel; 
	private TextPanel textPanel;
	
	private static final long serialVersionUID = 8887771L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
	
	
	public MainFrame(String title){
		
		super(title);
		
		setLayout(new BorderLayout());
		
		bottomPanel = new BottomButtonPanel();
		
		bottomPanel.setColorChanger(new ColorChanger(){
			
			public void changeColor(Color color){
				
				getContentPane().setBackground(color);
				
			}
			
		});
		add(bottomPanel, BorderLayout.SOUTH);
		
		textPanel = new TextPanel();
		add(textPanel, BorderLayout.CENTER);
		
		topPanel = new TopButtonPanel();
		topPanel.setTextListener(new StringListener(){

			@Override
			public void printText(String text) {
				textPanel.appendText(text);
			}
			
			public void clear(){
				textPanel.clearTextArea();
			}
		});
		add(topPanel, BorderLayout.NORTH);
		
		pack();
	}
	
	public Dimension getPreferredSize(){
		
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
	}
}
