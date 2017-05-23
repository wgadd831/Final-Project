/**
 * The timer that runs in the game
 */
public class Countdown {
	

	    public int time;
	    long startTime;
	    
	    public int levelTime;
	    public int lastReturnedTime = 0;
	    
	    
	    /**
	     * Creates an instance of the Countdown object 
	     */
	    public Countdown() {
	    	

	    }
	    
	    /**Start Timer
	     * 
	     * @param time is number of seconds
	     */
	    public void startTimer(int time) {
	    	
	    	levelTime = time;
	    	startTime = System.currentTimeMillis();
	    	
	    	
	    	int currentElapseTime = (int)((System.currentTimeMillis() - startTime)/1000);
	    	if (lastReturnedTime < currentElapseTime) {
	    		lastReturnedTime = currentElapseTime;
	    		//return currentElapseTime;
	    	} else {
	    		//return lastReturnedTime;
	    	}
	    
	    }
	    
	    
	    /** Return current time
	     * 
	     * @return current time
	     */
	    public int getTime() {
	    	
	    
	    	
	    	int currentElapseTime = (int)((System.currentTimeMillis() - startTime)/1000);
	    	if (lastReturnedTime < currentElapseTime) {
	    		lastReturnedTime = currentElapseTime;
	    		return levelTime - currentElapseTime;
	    	} else {
	    		return levelTime - lastReturnedTime;
	    	}
	    }
	    
	    /** increase time
	     * 
	     * @param add is amount of increase on time
	     */
	    public void increaseTime(int add) {
	    	
	    	levelTime += add;
	    }
	    


}
