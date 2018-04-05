/*============================================================
 * Project3main.java
 * Author: Christopher deWolf
 * 			
 * Date: 11/28/17
 * This is the main program for this project that creates a 
 * random data set of uniform distribution then calls each of
 * the algorithms: FCFS, SSF, Elevator-Up and Elevator-Down
 * ===========================================================
 */

import java.util.Random;

public class Project3main 
{

	public static void main(String[] args) 
	{

		Random randy = new Random();
		
		int seed = 4919;						//seed for the random number of uniform distribution
		randy.setSeed(seed);
		System.out.println("\nSeed is "+seed);
		System.out.println();
		FCFS fcfs = new FCFS();
		SSF  ssf  = new SSF();
		Elevator  ele  = new Elevator();
		
		boolean chat = false;			// toggle for the debugging comments throughout the program
		
		int numCylinders = 1000;		// cylinder numbers from 0-999
		
		// generate some disk accesses from 0 to 99
		int numAccesses = 12;
		int Accesses[] = new int[numAccesses];
		for(int i = 0; i<numAccesses; i++)		// Fill array with random values for each cylinder
		{
			Accesses[i] = randy.nextInt( numCylinders);
			if(chat) System.out.println( "at "+i+" Access = "+Accesses[i]);
		}
		
		int start = numCylinders/2; // this is where the disk starts
		
		int answer1 = fcfs.run(Accesses,  numAccesses,  start, chat);	//calling FCFS algorithm on data
		System.out.println("FCFS requires " + answer1 + " seek moves.");
		System.out.println();
		
		int answer2 = ssf.run( Accesses,  numAccesses,  start, chat);   //calling SSF algorithm on data
		System.out.println("SSF  requires " + answer2 + " seek moves.");
		System.out.println();
		
		int answer3 = ele.run( Accesses,  numAccesses,  start, 1, chat); //calling ElevatorUp algorithm on data
		System.out.println("Elevator up requires " + answer3 + " seek moves.");
		System.out.println();
		
		int answer4 = ele.run(Accesses,  numAccesses,  start, -1, chat); //calling ElevatorDwn algorithm on data
		System.out.println("Elevator down requires " + answer4 + " moves.");

	}
}



