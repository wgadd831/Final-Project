import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

public class Level {
	
	private ArrayList<Shape> obstacles;
	
	
	/**
	 *  Creates an instance of the Level object 
	 *  @param x determines the level that gets generated
	*/
	public Level(int x)
	{
		obstacles = new ArrayList<Shape>();
		
		if(x == 1)
		{
			obstacles.add(new Rectangle(0,550,800,50));
			obstacles.add(new Rectangle(0,0,50,800));
			obstacles.add(new Rectangle(750,0,50,800));
		}
		
		if(x == 2)
		{
			
		}
		
		if(x == 3)
		{
			
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

	
	
}
