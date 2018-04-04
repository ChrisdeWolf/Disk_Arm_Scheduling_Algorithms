/*====================================================================
 * SSF.java
 * Author: Christopher deWolf
 * 
 * Date: 11/28/17
 * The following program implements the SSF (Shortest Seek Time First)
 * algorithm to the given set of data from the main program.
 * ===================================================================
 */

public class SSF 
{
   int run(int[] Accesses, int size, int start, boolean chat)
   {    
	   System.out.print("SET 2 SSF");
		
	    int count = 0;
	    int[] distances = new int[size];
	    int[] ssfrequests = new int[size];		  //create a new array for accesses data to modify later
	    for( int i = 0; i < ssfrequests.length; i++)  //fill new array with accesses data
	    	ssfrequests[i] = Accesses[i];
	    int movement;				  //keeps track of total distance moved
	    int previous = start;
	    int shortest;
	    System.out.print("\nCylinders: " + start + " ");
   	    
	    for( int i = 0; i < ssfrequests.length; i++)	  //finding the smallest distance and sort
	    {   
	    	shortest = i;					  //current request being looked at
	    	movement = Math.abs(previous - ssfrequests[i]);   //distance we are comparing
	    	
	    	for( int k = i+1; k < ssfrequests.length; k++)		//looks at all the next requests
	    	{
	    		if( Math.abs( previous - ssfrequests[k]) < movement)	//if this next piece has a shorter distance
	    		{							//then it is the new shortest
	    			movement = ( Math.abs( previous - ssfrequests[k]));
	    			shortest = k;
	    		}
	    	}
	    						//swapping the distances
	    	int tmp = ssfrequests[i];
	    	ssfrequests[i] = ssfrequests[shortest];
	    	ssfrequests[shortest] = tmp;
	    	previous = ssfrequests[i];
	    }
    
	    previous = start;
    
	    for( int i = 0; i < ssfrequests.length; i++)	//calculating and storing movements
	    {
	    	movement = Math.abs( ssfrequests[i] - previous);
	    	System.out.print( "\t " + ssfrequests[i]);
			
		distances[i] = movement;		//fills array of distance moved for printing later
		count += movement;
		previous = ssfrequests[i];
	    }
	   
	    System.out.print( "\nDistances:   ");		//prints distances
	    for( int i = 0; i < ssfrequests.length; i++)
	    { 
            	System.out.print( "\t " + distances[i]);	
	    }	    
	    if( chat) 
	    	System.out.println("SSF Total distance is " + count);
	    if( !chat)
	    	System.out.print("\n");
	    
	   	return count;
	}
}
