/**
 * Written for Homework3 for CMSC412
 * Abstract class for threads
 * Extends Thread
 * Utilized in InputOutput and Computation
 * 
 * @author - Alice Stanford
 * @since 2017-06-07
 */

public abstract class ThreadAbstract extends Thread{
	//time taken by a thread
	 protected long time;
	 //start time of a thread
	 protected long startTime;
	 //returns time taken by a thread
	 public abstract long getTime();
	 //returns start time of a thread
	 public abstract long getStartTime();
}

