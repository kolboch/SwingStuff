package clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockMainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel separator1;
	private JLabel separator2;
	private Clock clock;
	private TimePanel hoursPanel;
	private TimePanel minutesPanel;
	private TimePanel secondsPanel;
	private BufferedImage dotImage;
	
	public ClockMainFrame(){
		setFrameSizeSettings();
		setFrameStyle();
		clock = new Clock(55,59,15);
		clock.start();
		dotImage = null;
		try {
			dotImage = ImageIO.read(new File("./src/clock/images/DotSeparator.jpg"));
		}
		catch (IOException e) {
			System.out.println("Error occured while trying to load image.");
		}
		addClockDemoComponents();
	}
	private void addClockDemoComponents(){
		separator1 = new JLabel(new ImageIcon(dotImage));
		separator2 = new JLabel(new ImageIcon(dotImage));
		GridBagConstraints gbc = new GridBagConstraints();
		hoursPanel = new TimePanel(clock.getHours());
		minutesPanel = new TimePanel(clock.getMinutes());
		secondsPanel = new TimePanel(clock.getSeconds());
		clock.setTimePanels(hoursPanel, minutesPanel, secondsPanel);
		
		hoursPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, Color.BLACK));
		minutesPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, Color.BLACK));
		secondsPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, Color.BLACK));
		
		Insets horizontal = new Insets(0,0,0,40);
		Insets none = new Insets(0,0,0,0);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;
		add(new JLabel(), gbc);
		
		gbc.weighty = 3;
		gbc.gridy++;
		gbc.insets = horizontal;
		add(hoursPanel,gbc);
		gbc.gridx++;
		add(separator1, gbc);
		gbc.gridx++;
		add(minutesPanel, gbc);
		gbc.gridx++;
		add(separator2, gbc);
		gbc.gridx++;
		gbc.insets = none;
		add(secondsPanel, gbc);
		
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy++;
		add(new JLabel(), gbc);
	}
	private void setFrameSizeSettings(){
		this.setSize(600, 400);
		this.setResizable(false);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)screen.getWidth()/2 - (int)this.getWidth()/2, (int)screen.getHeight()/2 - (int)this.getHeight()/2);
	}
	private void setFrameStyle(){
		this.getContentPane().setBackground(Color.DARK_GRAY);
		GridBagLayout gridLayout = new GridBagLayout();
		this.setLayout(gridLayout);
	}
	
}
