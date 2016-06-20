package clock;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ClockDemo {
	public static void main(String[]args){
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				ClockMainFrame frame = new ClockMainFrame();
				frame.setTitle("Tic Tac");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
		});
	}
}
