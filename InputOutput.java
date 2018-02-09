/**
 * Written for Homework3 for CMSC412
 * The Input/Output class
 * This displays numbers 0 to 1000
 * 
 * @author - Alice Stanford
 * @since 2017-06-07
 */
 
public class InputOutput extends ThreadAbstract{
	@Override
	/**
	 * Overloaded run method for IO threads
	 */
    public void run() {
        startTime = System.nanoTime();
        for(int i=0;i<1000;i++) {
        	System.out.println ( " InputOutput : " + i );
        }
         time = System.nanoTime()-startTime;
    }
    
	@Override
	
	/**
	 * Returns time taken for thread to process
	 *
	 * @return  the amount of time taken by the thread
	 */
    public long getTime() {
        return time;
    }
	
	/**
	 * Returns the start time for thread
	 *
	 * @return  time the thread started
	 */    
    public long getStartTime() {
        return startTime;
    }
}

