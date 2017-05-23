/**
 * Score that use in game and for player
 */
public class ScoreCounter {
	
	
	public int score = 0;
	
	/** Creates an instance of the ScoreCounter object 
	 * 
	 * @param i
	 */
	public ScoreCounter() {
		
	}
	
	/** Return score
	 * 
	 * @return score of current player
	 */
	public int getScore(){
		
		
		return score;
		
	}
	
	/** Increase score by amount
	 * 
	 * @param i is amount of score
	 */
	public void increaseScore(int i) {
		
		score += i;
		
	}

	/** Set score
	 * 
	 * @param i is the score that will be set
	 */
	public void setScore(int i) {
		score = i;
	}
}
