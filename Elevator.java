/*====================================================================
 * Elevator.java
 * Author: Christopher deWolf
 * 
 * Date: 11/28/17
 * The following program implements the Elevator Up and Down
 * algorithms to the given set of data from the main program.
 * ===================================================================
 */
	
import java.util.*;

public class Elevator 
{
	public int run( int[] Accesses, int size, int start, int updown, boolean chat)
	{
		int count = 0;
		int pivot = 0;
		int movement;
		int lastPlace = start;
		int direction = -1;
		int[] distances = new int[size];
		if( updown > 0)
			direction = 1;
		
	    // create new request array from Accesses array to modify it for both ascending and descending
	    int[] requests = new int[size];
	    for( int i=0; i < requests.length; i++)
	    	requests[i] = Accesses[i];
	    
	    Arrays.sort( requests);		//sorts the array in ascending order
	    
	    if( chat)
	    {
	    	for( int i=0; i < requests.length; i++)		//print out sorted list for debugging if chat=TRUE
	    		System.out.println( requests[i] + " ");
	    }
	    
	    for( int i = 0; i < requests.length; i++)
	    {
	    	if( start > requests[i])	//finding the pivot point from where elevator ascends and descends
	    		pivot = i;
	    }
		
	    if( direction > 0)              // ascending elevator (direction up)
	    {
	    	System.out.print("SET 3 ELEVATOR UP");
	    	System.out.print("\nCylinders: " + start + " ");
	         for( int i = pivot + 1; i < requests.length; i++)			//start with the requests larger than 500
	         {
	        	 movement = Math.abs( requests[i] - lastPlace);
				 System.out.print( "\t " + requests[i]);
				 
				 distances[i] = movement;		//fills array of distance moved for printing later
				 count += movement;
				 lastPlace = requests[i];
	         }
	      
	         for( int i = pivot; i >= 0; i--)			//jump down to pivot value and requests below 500 (start)
	         {
	        	 movement = Math.abs( requests[i] - lastPlace);
				 System.out.print("\t " + requests[i]);
				 
				 distances[i] = movement;		//fills array of distance moved for printing later
				 count += movement;
				 lastPlace = requests[i];
	         }
	         
	        System.out.print( "\nDistances:   ");
	 	    for( int i = pivot + 1; i < requests.length; i++)
	 	    {
	 	    	System.out.print( "\t " + distances[i]);
	 	    }
	 	    for( int i = pivot; i >= 0; i--)
	 	    {
	 	    	System.out.print( "\t " + distances[i]);
	 	    }
	    }      
	    else			//if not ascending then it is descending elevator algorithm
	    {
	    	System.out.print("SET 4 ELEVATOR DOWN");
	    	System.out.print("\nCylinders: " + start + " ");
	    	for( int i = pivot; i >= 0; i--)			//start with the requests smaller than 500 (start)
	         {
	        	 movement = Math.abs( requests[i] - lastPlace);
				 System.out.print( "\t " + requests[i]);		//prints out each cylinder
				 
				 distances[i] = movement;				//fills array of distance moved for printing later
				 count += movement;
				 lastPlace = requests[i];
	         }
	      
	         for( int i = pivot + 1; i < requests.length; i++)	//fills requests above start (500) and their movements
	         {
	        	 movement = Math.abs( requests[i] - lastPlace);
				 System.out.print("\t " + requests[i]);
				 
				 distances[i] = movement;
				 count += movement;
				 lastPlace = requests[i];
	         }	  
	         System.out.print( "\nDistances:   ");
	         for( int i = pivot; i >= 0; i--)
		 	 {
	        	 System.out.print( "\t " + distances[i]);
		 	 }
		 	 for( int i = pivot + 1; i < requests.length; i++)
		 	 {
		 		 System.out.print( "\t " + distances[i]);
		 	 }	
	    }	    
	    System.out.println();
		return count;
	}
}
