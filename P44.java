package euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P44
{
	public static void main(String[] args)
	{
		//bruteForce();
		//slowest();
		
		long start=System.currentTimeMillis();
		List<Integer> list = Utils.pentagonalNumbers(3000);
		out:
		for (int j: list)
			for (int k: list)
			{
				int sum = j+k;
				int diff= Math.abs(k-j);
				if (Collections.binarySearch(list,sum)>=0 && Collections.binarySearch(list,diff)>=0 )
				{
					long end=System.currentTimeMillis();
					System.out.format("In %,dms, found %d,%d sum %d and diff %d is pentagonal%n", 
							(end-start), j, k, sum, diff);
					break out;
				}
			}		
		
	}

	/**
	 * 
	 */
	private static void slowest()
	{
		long start=System.currentTimeMillis();
		int max=7100000;
		out:
	    for (int j=1; j<max; j++)
	    {
	    	if (!Utils.isPentagonal(j))
	    		continue;
	    	for (int k=j+1; k<max; k++)
	    	{
		    	if (!Utils.isPentagonal(k))
		    		continue;
		    	//System.out.println("double match: j="+j+", k="+k);
		    	int sum=k+j, diff=Math.abs(k-j);
		    	
		    	if (Utils.isPentagonal(sum) && Utils.isPentagonal(diff))
		    	{
					long end=System.currentTimeMillis();
					System.out.format("In %,dms, found %d,%d sum %d and diff %d is pentagonal%n", 
							(end-start), j, k, sum, diff);
		    		break out;
		    	}
	    	}
	    }
	}


	
	/**
	 * 
	 */
	private static void bruteForce()
	{
		long start=System.currentTimeMillis();
		List<Integer> list = Utils.pentagonalNumbers(3000);
		out:
		for (int j: list)
			for (int k: list)
			{
				int sum = j+k;
				int diff= Math.abs(k-j);
				if (list.contains(sum) && list.contains(diff))
				{
					long end=System.currentTimeMillis();
					System.out.format("In %,dms, found %d,%d sum %d and diff %d is pentagonal%n", 
							(end-start), j, k, sum, diff);
					break out;
				}
			}
	}

	
}
