import javax.swing.*;

import processing.awt.PSurfaceAWT;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Main {

	private JFrame window;
	
	private JPanel cardPanel;
	
	private OptionPanel panel1; 
	private InstructionPanel panel2;
	private DrawingSurface panel3;
	private EndingPanel panel4;
	private DrawingSurface panel5;
    private int score;


	
	private PSurfaceAWT.SmoothCanvas processingCanvas;

	
	public Main() {
		panel3 = new DrawingSurface(this);
		panel3.runMe();

		
		PSurfaceAWT surf = (PSurfaceAWT) panel3.getSurface();
		processingCanvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		window = (JFrame)processingCanvas.getFrame();

		window.setBounds(0,0,800, 600);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    window.getContentPane().removeAll();
	    
		panel1 = new OptionPanel(this);    
		panel2 = new InstructionPanel(this);
	    panel4 = new EndingPanel(this);
	    
	    cardPanel.add(panel1,"1");
	    cardPanel.add(panel2, "2");
	    cardPanel.add(processingCanvas,"3");
	    cardPanel.add(panel4, "4");
	    
	    window.setLayout(new BorderLayout());
	    
	    window.add(cardPanel);
	    window.revalidate();
	    

	}
	


	public int getScore(){
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	

	public static void main(String[] args)
	{
		Main m = new Main();
	}
  

	public void changePanel(String name) {
		((CardLayout)cardPanel.getLayout()).show(cardPanel,name);
		processingCanvas.requestFocus();
	}
	

  
}