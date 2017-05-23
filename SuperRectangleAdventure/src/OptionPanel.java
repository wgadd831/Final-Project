import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import processing.awt.PSurfaceAWT;

import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *Start Screen of game
 */
public class OptionPanel extends JPanel implements ActionListener {
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	Main w;
	private BufferedImage img;
	private JButton startButton;
	private JButton exitButton;

/** Creates an instance of the Option Panel object 
 * 
 * @param w is a Main
 */
	public OptionPanel(Main w) {
		this.w = w;
		startButton = new JButton();
		exitButton = new JButton();
		
	}
	

	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);
	    

		Graphics2D g2 = (Graphics2D)g;

	    int width = getWidth();
	    int height = getHeight();
	    
	    double ratioX = (double)width/DRAWING_WIDTH;
	    double ratioY = (double)height/DRAWING_HEIGHT;
	    
	    AffineTransform at = g2.getTransform();
	    g2.scale(ratioX, ratioY);

	    g2.setTransform(at);
	    try {
			img = ImageIO.read(new File("startPage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	    
	    
	    

		startButton.setIcon(new ImageIcon("startbutton.png"));
		startButton.addActionListener(this);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false); 
		startButton.setFocusPainted(false); 
		startButton.setOpaque(false);
		setLayout(null);
		startButton.setBounds(getWidth()- getWidth()/3, getHeight() - getHeight()/8 * 3, getWidth()/3, getHeight()/8);
		add(startButton);




		exitButton.setIcon(new ImageIcon("exitbutton.png"));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false); 
		exitButton.setFocusPainted(false); 
		exitButton.setOpaque(false);
		exitButton.setBounds(getWidth()- getWidth()/3, getHeight() - getHeight()/8 * 2, getWidth()/3, getHeight()/8);
		add(exitButton);
		
		validate();

	  }
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel("2");

	}



	
}