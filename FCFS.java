/*===========================================================
 * FCFS.java
 * Author: Christopher deWolf
 * 	
 * Date: 11/28/17
 * This program implements the First Come First Serve Algorithm
 * in java for the given set of data in main.
 * ==========================================================
 */

public class FCFS 
{
	int run(int[] Accesses, int size, int start, boolean chat)
	{
		System.out.print("SET 1 FCFS");
		int count = 0;
		int movement;
		int lastPlace = start;
		int[] distances = new int[size];		//array to store distance values

		if(!chat) System.out.print("\nCylinders:       " + start);
		for(int i=0;i<size; i++)
		{
			movement = Math.abs(Accesses[i] - lastPlace);
			if(chat) System.out.println("from "+lastPlace+" to "+Accesses[i]+" is "+movement);
			if(!chat) System.out.print("\t "+Accesses[i]);	
			count += movement;
			lastPlace = Accesses[i];
			distances[i] = movement;		//fills array of distance moved for printing later
		}
		if(chat) System.out.println("FCFS Total distance is " + count);
		if(!chat) System.out.print("\n");
		System.out.print( "Distances:   \t");
 	    for( int i = 0; i < size; i++)
 	    {
 	    	System.out.print( "\t " + distances[i]);
 	    }
 	    System.out.println();
		return count;
	}
}


