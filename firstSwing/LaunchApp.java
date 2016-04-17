package firstSwing;

import javax.swing.SwingUtilities;

public class LaunchApp {
	
	public static void main(String[]args){
		
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run(){
				
				MainFrame frame = new MainFrame("Hello App!");
				frame.setPreferredSize(frame.getPreferredSize());
				frame.setVisible(true);
			}
			
		});
		
	}
	
}
