package firstSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomButtonPanel extends JPanel implements ActionListener{
	
	
	private static final long serialVersionUID = 7778881L;
	private ColorChanger colorChanger;
	private JButton blue;
	private JButton green;
	private JButton red;
	private static final Dimension buttonDimension = new Dimension(70,30);
	
	public BottomButtonPanel(){
		
		blue = new JButton("blue");
		green = new JButton("green");
		red = new JButton("red");
		
		blue.setPreferredSize(buttonDimension);
		green.setPreferredSize(buttonDimension);
		red.setPreferredSize(buttonDimension);
		
		blue.addActionListener(this);
		green.addActionListener(this);
		red.addActionListener(this);
		
		setLayout(new FlowLayout());
		
		//making panel transparent
		setOpaque(false);
		
		add(blue, FlowLayout.LEFT);
		add(green, FlowLayout.CENTER);
		add(red, FlowLayout.RIGHT);
		
		
		
	}
	
	public void setColorChanger(ColorChanger colorChanger){
		this.colorChanger = colorChanger;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton clicked = (JButton)e.getSource();
		
		if(colorChanger != null){
		
			if(clicked == blue){
				colorChanger.changeColor(Color.blue);
			}
			if(clicked == green){
				colorChanger.changeColor(Color.green);
			}
			if(clicked == red){
				colorChanger.changeColor(Color.red);
			}
		
		}
	}
}
