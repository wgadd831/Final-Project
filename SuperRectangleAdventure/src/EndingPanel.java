import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class EndingPanel extends JPanel implements ActionListener {
	
	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
	Main w;
	private BufferedImage img;
	
	public EndingPanel(Main w) {
		this.w = w;
		
	


		JButton restartButton = new JButton();
		restartButton.setIcon(new ImageIcon("startbutton.png"));
		restartButton.addActionListener(this);
		restartButton.setBorderPainted(false);
		restartButton.setContentAreaFilled(false); 
		restartButton.setFocusPainted(false); 
		restartButton.setOpaque(false);
		setLayout(null);
		restartButton.setBounds(DRAWING_WIDTH- DRAWING_WIDTH/3, DRAWING_HEIGHT - DRAWING_HEIGHT/8 * 3, DRAWING_WIDTH/3, DRAWING_HEIGHT/8);
		add(restartButton);

		
		JButton exitButton = new JButton();
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
		exitButton.setBounds(DRAWING_WIDTH- DRAWING_WIDTH/3, DRAWING_HEIGHT - DRAWING_HEIGHT/8 * 2, DRAWING_WIDTH/3, DRAWING_HEIGHT/8);
		add(exitButton);
		
		validate();
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
			img = ImageIO.read(new File("endingPage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);


	  }
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
	}
	
}