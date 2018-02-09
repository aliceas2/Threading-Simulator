/**
 * Written for Homework3 for CMSC412
 * This class is used to manage times for both IO and computation
 * 
 * @author - Alice Stanford
 * @since 2017-06-07
 */
public class ThreadsTimes {
    long threadCompTime[]; //array2
    long threadIOTime[]; //array1

    /**
	 * Constructor
	 *
	 * @param threadIOTime[]
	 * @param threadCompTime[]
	 */  
    public ThreadsTimes(long threadIOTime[], long threadCompTime[])
    {
    	this.threadCompTime = threadCompTime;
    	this.threadIOTime = threadIOTime;
    }

    /**
	 * Returns the input/output time array
	 *
	 * @return
	 */      
    public long[] getIOTime(){
    	return threadIOTime;
    }
    
    /**
	 * Returns the computation time array
	 *
	 * @return
	 */  
    long[] getCompTime(){
    	return threadCompTime;
    }
}
