

import java.awt.Rectangle;
import java.awt.Shape;

import java.awt.event.KeyEvent;
import java.util.ArrayList;



import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;

	private Rectangle screenRect;

	Main w;
	private Player player;
	private SafeSquare safe1;
	private SafeSquare safe2;
	private Level level;
	private ScoreCounter scores;
	private ArrayList<Shape> obstacles;
	private ArrayList<Shape> spikes;

	private ArrayList<Integer> keys;
	
	private ArrayList<PImage> assets;
	
	
	private Countdown time;
	
	private boolean ignore;
	




	public DrawingSurface(Main w) {
		super();
		
		this.w = w;
		assets = new ArrayList<PImage>();
		keys = new ArrayList<Integer>();
		screenRect = new Rectangle(0,0,DRAWING_WIDTH,DRAWING_HEIGHT);
		
		safe1 = new SafeSquare(true,true);
		safe2 = new SafeSquare(false,false);
		
		//once more levels are made, input random integer
		level = new Level(0);
		obstacles = level.getLevels();
		spikes = level.getSpikes();
		scores = new ScoreCounter();
		time = new Countdown();

		time.startTimer(50);
	}


	/**
	 * Spawns the player at whatever safe square is currently the start
	*/
	public void spawnNewPlayer() {
		if(safe1.getIsStart())
		{
			player = new Player(assets.get(0), safe1.getX()+25, safe1.getY());

		}
		
		if(safe2.getIsStart())
		{
			player = new Player(assets.get(0), safe2.getX()-25, safe2.getY());

		}
		
	}
	
	public void runMe() {
		
		runSketch();
	}

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
		assets.add(loadImage("uglyRectangle.png"));
		
		spawnNewPlayer();
	}



	public void draw() {

		// drawing stuff

		background(230,230,230);   

		pushMatrix();

		float ratioX = (float)width/DRAWING_WIDTH;
		float ratioY = (float)height/DRAWING_HEIGHT;

		scale(ratioX, ratioY);

		
		fill(0);
		for (Shape s : obstacles) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle)s;
				rect(r.x,r.y,r.width,r.height);
			}
		}

		
		fill(250,0,0);
		for (Shape s : spikes) {
			if (s instanceof Rectangle) {
				Rectangle r = (Rectangle)s;
				rect(r.x,r.y,r.width,r.height);
			}
		}
		
		fill(250,250,0);
		
		rect(safe1.getX(), safe1.getY(), SafeSquare.SAFESQUARE_WIDTH, SafeSquare.SAFESQUARE_HEIGHT);
		rect(safe2.getX(), safe2.getY(), SafeSquare.SAFESQUARE_WIDTH, SafeSquare.SAFESQUARE_HEIGHT);
		
		player.draw(this);

		popMatrix();


		// modifying stuff

		if (isPressed(KeyEvent.VK_LEFT))
			player.walk(-1);
		if (isPressed(KeyEvent.VK_RIGHT))
			player.walk(1);
		if (isPressed(KeyEvent.VK_SPACE))
		{
			player.jump();
			player.wallJump();
		}
		if (isPressed(KeyEvent.VK_DOWN))
		{
			player.crouch();
		}
		if (isPressed(KeyEvent.VK_UP))
		{
			player.uncrouch();
		}
		
		

		player.act(obstacles);

		if (!screenRect.intersects(player))
			spawnNewPlayer();
		
		//makes the spikes kill the player
		for(int i = 0; i < spikes.size();i++)
		{
			if (spikes.get(i).intersects(player))
				spawnNewPlayer();
		}
		
		
		
		//CODE TO RANDOMIZE LEVEL
		if((safe1.getSafe()).intersects(player))
		{
			if(!safe1.getIsStart())
			{
				int x;
				do
				{
					x = (int)(Math.random()*6);
				}while(x == level.getLevelNumber() || x == 0);
				
				level = new Level(x); 
				obstacles = level.getLevels();
				spikes = level.getSpikes();
				safe1.swap();
				safe2.swap();
				scores.increaseScore(1);
				time.increaseTime(10);
			}
			
		}
		
		if((safe2.getSafe()).intersects(player))
		{
			if(!safe2.getIsStart())
			{
				int x;
				do
				{
					x = (int)(Math.random()*6);

				}while(x == level.getLevelNumber() || x == 0);

				
				level = new Level(x); 
				obstacles = level.getLevels();
				spikes = level.getSpikes();
				safe1.swap();
				safe2.swap();
				scores.increaseScore(1);
				time.increaseTime(10);
			}
		}
		
		textSize(15);
		text("Score : "+ scores.getScore(), 10, 20);
		fill(0, 102, 153);
		
		
		textSize(15);
		text("Time : " + time.getTime(), 10, 35);
		fill(0, 102, 153);
		
		if (time.getTime() == 0 && !ignore) {
			ignore = true;
			w.setScore(scores.getScore());
			w.changePanel("4");
			scores.setScore(0);

		}
		
		
		
		
	}
	
	public int returnScore(){
		return scores.getScore();
	}


	public void keyPressed() {
		keys.add(keyCode);
		
	}

	public void keyReleased() {
		while(keys.contains(keyCode))
			keys.remove(new Integer(keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}


}

