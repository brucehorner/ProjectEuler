package euler;

import java.util.HashSet;
import java.util.List;

public class P47
{
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		int consecutiveCount=0,  priorVal=0;
		for (int i=10; i<1000000; i++)
		{
			List<Integer> factors = Factors.primeFactors(i);
			HashSet<Integer> set = new HashSet<Integer>();
			for (int f:factors)
				set.add(f);
			int size = set.size();
			
			if (size==priorVal)
				consecutiveCount++;
			else
				consecutiveCount=1;
			priorVal = size;

			//System.out.print ("i="+i+", num prime factors = "+size+", consecutive = "+consecutiveCount);
			//System.out.println (consecutiveCount>2?" *** MATCH *** ":"");
			
			int check=4;
			if (consecutiveCount==check && size==check)
			{
				long end=System.currentTimeMillis();
				System.out.println ("In "+(end-start)+"ms found "+check+" factors , "+check+" times in a row");
				System.out.print   ("  >>  ");
				for (int y=check-1; y>=0; y--)
					System.out.print(i-y+", ");
				System.out.println();
				break;
			}

		}
	}
}
