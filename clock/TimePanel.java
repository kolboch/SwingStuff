package clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TimePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private final Dimension preferredSize = new Dimension(100,128);
	private int dataTime;
	
	public TimePanel(int dataTime){
		this.setPreferredSize(preferredSize);
		this.dataTime = dataTime;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(this.getParent().getBackground());
		g.setColor(Color.WHITE);
		Font f = new Font("Arial", Font.PLAIN, 80);
		g.setFont(f);
		String time = String.format("%02d", dataTime);
		g.drawString(time, 5, (this.getHeight() + f.getSize()) /2 - 10);
	}
	
	public void actualizeTime(int dataTime){
		this.dataTime = dataTime;
		this.repaint();
	}
}
