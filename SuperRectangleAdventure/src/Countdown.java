
public class Countdown {
	

	    public int time;
	    long startTime;
	    
	    int levelTime;
	    int lastReturnedTime = 0;
	    
	    public Countdown() {
	    	

	    }
	    
	    
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
	    
	    public int getTime() {
	    	
	    
	    	
	    	int currentElapseTime = (int)((System.currentTimeMillis() - startTime)/1000);
	    	if (lastReturnedTime < currentElapseTime) {
	    		lastReturnedTime = currentElapseTime;
	    		return levelTime - currentElapseTime;
	    	} else {
	    		return levelTime - lastReturnedTime;
	    	}
	    }
	    
	    
	    public void increaseTime(int add) {
	    	
	    	levelTime += add;
	    }


}
