import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

/**
 *The level that the player must navigate through
*/
public class Level {
	
	private ArrayList<Shape> obstacles;
	private ArrayList<Shape> spikes;
	private int levelNumber;
	
	/**
	 *  Creates an instance of the Level object 
	 *  @param x determines the level that gets generated
	*/
	public Level(int x)
	{
		//height: 600
		//width: 800
		
		levelNumber = x;
		
		obstacles = new ArrayList<Shape>();
		spikes = new ArrayList<Shape>();
		
		//safeSquare borders
		obstacles.add(new Rectangle(0,0,100,250));
		obstacles.add(new Rectangle(0,350,100,250));
		obstacles.add(new Rectangle(0,250,1,100));
		
		obstacles.add(new Rectangle(700,0,100,250));
		obstacles.add(new Rectangle(700,350,100,250));
		obstacles.add(new Rectangle(800,250,1,100));
		
		//screen borders(top and bottom)
		obstacles.add(new Rectangle(100,0,600,10));
		obstacles.add(new Rectangle(100,590,600,10));
		
		
		
		//level zero always plays first
		//ensures that player knows how to crouch and wall jump
		if(x == 0)
		{
			obstacles.add(new Rectangle(100,0,150,250));
			obstacles.add(new Rectangle(250,0,300,500));
			obstacles.add(new Rectangle(550,0,150,250));
			obstacles.add(new Rectangle(450,500,100,65));
			
			spikes.add(new Spike(350,575));
		}
		
		if(x == 1)
		{
			obstacles.add(new Rectangle(100,0,600,250));
			obstacles.add(new Rectangle(100,350,600,250));
			
			spikes.add(new Spike(200,335));
			spikes.add(new Spike(300,335));
			spikes.add(new Spike(400,335));
			spikes.add(new Spike(500,335));
			spikes.add(new Spike(600,335));
			
			
		}
		
		if(x == 2)
		{
			obstacles.add(new Rectangle(100,0,100,250));
			obstacles.add(new Rectangle(200,0,50,550));
			obstacles.add(new Rectangle(350,100,100,500));
			obstacles.add(new Rectangle(550,0,50,550));
			obstacles.add(new Rectangle(600,0,100,250));
			
			spikes.add(new Spike(250,265));
			spikes.add(new Spike(335,150));
			spikes.add(new Spike(335,400));
			spikes.add(new Spike(535,265));
			spikes.add(new Spike(450,150));
			spikes.add(new Spike(450,400));
		}
		
		if(x == 3)
		{
			obstacles.add(new Rectangle(150,350,100,15));
			obstacles.add(new Rectangle(300,100,15,200));
			obstacles.add(new Rectangle(500,150,100,15));
			obstacles.add(new Rectangle(575,300,50,15));
			obstacles.add(new Rectangle(625,325,50,15));
			
			//spike floor
			for(int x1 = 103; x1 <= 690; x1 += 20)
			{
				spikes.add(new Spike(x1,575));
			}
			
			
		}
		
		if(x == 4)
		{
			
			obstacles.add(new Rectangle(200,150,10,300));
			obstacles.add(new Rectangle(350,100,10,150));
			obstacles.add(new Rectangle(450,250,10,150));
			obstacles.add(new Rectangle(550,50,10,100));
			obstacles.add(new Rectangle(550,350,10,150));
			
			//spike floor
			for(int x1 = 103; x1 <= 690; x1 += 20)
			{
				spikes.add(new Spike(x1,575));
			}
			
		}
		
		if(x == 5)
		{
			
			obstacles.add(new Rectangle(100,0,600,50));
			obstacles.add(new Rectangle(200,100,450,50));
			obstacles.add(new Rectangle(200,150,50,250));
			obstacles.add(new Rectangle(300,200,400,50));
			obstacles.add(new Rectangle(550,250,50,250));
			obstacles.add(new Rectangle(250,300,250,100));
			obstacles.add(new Rectangle(100,350,100,50));
			obstacles.add(new Rectangle(150,450,400,50));
			obstacles.add(new Rectangle(100,550,600,50));
			
			spikes.add(new Spike(300,90));
			spikes.add(new Spike(500,90));
			spikes.add(new Spike(500,165));
			spikes.add(new Spike(300,265));
			spikes.add(new Spike(405,290));
			spikes.add(new Spike(535,350));
			spikes.add(new Spike(400,445));
			spikes.add(new Spike(300,445));
			spikes.add(new Spike(265,513));
			spikes.add(new Spike(365,545));
			spikes.add(new Spike(465,513));
			spikes.add(new Spike(530,545));
			
			
		
		}
		
		/*
		 * 
		 * MAKE MORE LEVELS
		 * 
		 */
		
	}
	
	public ArrayList<Shape> getLevels()
	{
		return obstacles;
	}
	
	public ArrayList<Shape> getSpikes()
	{
		return spikes;
	}
	
	public int getLevelNumber()
	{
		return levelNumber;
	}

	
	
}
