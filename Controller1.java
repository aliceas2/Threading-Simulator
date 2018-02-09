/**
 * Written for Homework3 for CMSC412
 * This program creates and starts 10 threads (5 IO and 5 Computational)
 * It then displays the time taken to execute each thread and the overall time
 * Interspersed IO bound and computationally intensive operations
 * 
 * @author - Alice Stanford
 * @since 2017-06-07
 */

public class Controller1 {

    /**
     * @param args the command line arguments
     */
	
    public static void main(String[] args) throws InterruptedException {
        //total number of each type of thread to create
        final int NUM_THREADS = 5;
        
        //arrays of threads
        ThreadAbstract[] ioThreadTime = create(NUM_THREADS, true);
        ThreadAbstract[] computationThreadTime = create(NUM_THREADS, false);
        
        //runs threads and stores in ThreadsTimes object
        ThreadsTimes times = threadTime(ioThreadTime,computationThreadTime);
        
        //retrieve total times for each type
        long timeInputProcess = getIOTimeTotal(times);
        long timeCompProcess = getCompTimeTotal(times);
        
        //Display Results
        System.out.println("**** Homework section 3a ******");
        System.out.println("Input/Output Thread Time :");
        display(times.getIOTime());
        System.out.println("Computation Thread Time :");
        display(times.getCompTime()); 
        System.out.println("Total Process Time : ");
        System.out.println("Input/Output : " + timeInputProcess);
        System.out.println("Computation : " + timeCompProcess);
        System.out.println("Overall : " + (timeInputProcess + timeCompProcess));
    }

	/**
     * method to get total time by computation process
     *
     * @param times
     * @return
     */
	private static long getCompTimeTotal(ThreadsTimes times) {
		long time[] = times.getCompTime();
		long timeTotal = 0;
		
		for (int i = 0; i < time.length; i++) {
	           timeTotal += time[i];
		}
		return timeTotal;
	}

	/**
     * method to get total time by IO process
     *
     * @param times
     * @return
     */
	private static long getIOTimeTotal(ThreadsTimes times) {
		long time[] = times.getIOTime();
		long timeTotal = 0;
		
		for (int i = 0; i < time.length; i++) {
	           timeTotal += time[i];
		}
		return timeTotal;
	}

	/**
     * method to calculate time taken by each thread
     *
     * @param threadIO
     * @return
     * @throws InterruptedException
     */
    public static ThreadsTimes threadTime(ThreadAbstract threadIO[], ThreadAbstract threadComp[]) throws InterruptedException {
        long compTime[] = new long[threadIO.length];
        long IOTime[] = new long[threadComp.length];
        
        for (int i = 0; i < threadIO.length; i++) {
            threadIO[i].start(); 
            threadIO[i].join();
            threadComp[i].start();
            threadComp[i].join();
        }
        
        for (int i = 0; i < (threadIO.length); i++) {
            IOTime[i] = threadIO[i].getTime();
            compTime[i]= threadComp[i].getTime();
        }
        
        ThreadsTimes times = new ThreadsTimes(IOTime, compTime);
        
        return times;
    }
    
    /**
     * method to create the threads
     * @param length
     * @param isInputOutput
     * @return 
     */
    public static ThreadAbstract[] create(int length, boolean isInputOutput) {
        ThreadAbstract thread[];
        if (isInputOutput) {
            thread = new InputOutput[length];
            for (int i = 0; i < length; i++) {
                thread[i] = new InputOutput();
                thread[i].setName("IO" + (i + 1));
            }
        } else {
            thread = new Computation[length];
            for (int i = 0; i < length; i++) {
                thread[i] = new Computation();
                thread[i].setName("Comp" + (i + 1));
            }
        }
        return thread;
    }

    /**
     * method to display running times
     *
     * @param time
     */
    public static void display(long time[]) {
        for (int i = 0; i < time.length; i++) {
            System.out.println((i+1) + " : " + time[i] + " ns");
        }
    }
}
