package firstSwing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopButtonPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8887771L;
	
	private JButton how;
	private JButton fine;
	private JButton clear;
	private StringListener stringListener;
	private static final Dimension buttonDimension = new Dimension(90,30);
	
	public TopButtonPanel(){
		
		how = new JButton("How?");
		fine = new JButton("Fine ;)");
		clear = new JButton("Clear?");
		
		clear.setPreferredSize(buttonDimension);
		how.setPreferredSize(buttonDimension);
		fine.setPreferredSize(buttonDimension);
		
		clear.addActionListener(this);
		how.addActionListener(this);
		fine.addActionListener(this);
		
		setLayout(new FlowLayout());
		setOpaque(false);
		add(how);
		add(fine);
		add(clear);
	}
	
	public void setTextListener(StringListener listener){
		this.stringListener = listener;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(stringListener != null){
			
			JButton clicked = (JButton)e.getSource();
			
			if(clicked == how){
				stringListener.printText("How do you do?\n");
			}
			if(clicked == fine){
				stringListener.printText("Fine, thanks bro!!\n");
			}
			if(clicked == clear){
				stringListener.clear();
			}
			
		}
	}
	
	
	
}
