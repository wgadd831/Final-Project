import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

/**
 *The level that the player must navigate through
*/
public class Level {
	
	private ArrayList<Shape> obstacles;
	
	
	/**
	 *  Creates an instance of the Level object 
	 *  @param x determines the level that gets generated
	*/
	public Level(int x)
	{
		//height: 600
		//width: 800
		
		obstacles = new ArrayList<Shape>();
		
		//safeSquare borders
		obstacles.add(new Rectangle(0,0,100,250));
		obstacles.add(new Rectangle(0,350,100,250));
		obstacles.add(new Rectangle(0,250,10,100));
		
		obstacles.add(new Rectangle(700,0,100,250));
		obstacles.add(new Rectangle(700,350,100,250));
		obstacles.add(new Rectangle(790,250,10,100));
		
		//screen borders(top and bottom)
		obstacles.add(new Rectangle(100,0,600,10));
		obstacles.add(new Rectangle(100,590,600,10));
		
		if(x == 0)
		{
			obstacles.add(new Rectangle(150,350,500,10));
		}
		
		if(x == 1)
		{
			obstacles.add(new Rectangle(150,100,500,10));
		}
		
		if(x == 2)
		{
			obstacles.add(new Rectangle(150,500,500,10));
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
