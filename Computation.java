/**
 * Written for Homework3 for CMSC412
 * a thread class that runs a computationally intensive operation. 
 * You can perform some math computation a number of times.
 * 
 * @author - Alice Stanford
 * @since 2017-06-07
 */
public class Computation extends ThreadAbstract{
    //Start factorial number
    double fact = 1;
    //number of times factorial loop will run
    final int number = 170;
    
    @Override
    
	/**
	 * Overloaded run method for computation threads
	 */
    public void run() {
        
        startTime = System.nanoTime();
    
        for(int i = 1; i < number; i++) {
            //no I/O operation!!!
        	fact = fact * i;
        }
         //time taken
         time = System.nanoTime()-startTime;
    }
    
    @Override

	/**
	 * Returns time taken for thread to process
	 *
	 * @param  time - the amount of time taken by the thread
	 */
    public long getTime() {
        return time;
    }

	/**
	 * Returns the start time for thread
	 *
	 * @param  startTime - time the thread started
	 */    
     public long getStartTime() {
        return startTime;
    }
}