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
	private JButton restartButton;
	private JButton exitButton;

	
	public EndingPanel(Main w) {
		this.w = w;
		restartButton = new JButton();
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
			img = ImageIO.read(new File("endingPage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	    
	    JLabel s = new JLabel("" + w.getScore());
	    setLayout(null);
	    s.setFont(new Font("Serif", Font.BOLD, getHeight()/5));
	    s.setBounds(getWidth()/2, getHeight()/2, getWidth()/5, getHeight()/5);
	    s.setForeground(Color.WHITE);
	    add(s);
	    
	    
		restartButton.setIcon(new ImageIcon("restartbutton.png"));
		restartButton.addActionListener(this);
		restartButton.setBorderPainted(false);
		restartButton.setContentAreaFilled(false); 
		restartButton.setFocusPainted(false); 
		restartButton.setOpaque(false);
		setLayout(null);
		restartButton.setBounds(getWidth()/3, getHeight() - getHeight()/8 * 2, getWidth()/3, getHeight()/8 + getWidth()/6);
		add(restartButton);


		exitButton.setIcon(new ImageIcon("exitbuttonforending.png"));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false); 
		exitButton.setFocusPainted(false); 
		exitButton.setOpaque(false);
		exitButton.setBounds(getWidth()/3, getHeight() - getHeight()/8 * 3, getWidth()/3, getHeight()/8 + getWidth()/6);
		add(exitButton);
		
		validate();
	    


	  }
	
	public void actionPerformed(ActionEvent e) {
		w.callPanel();
	}
	
}