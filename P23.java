package euler;

import java.util.List;
import java.util.Vector;

public class P23
{
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		int limit=28123;
		Vector<Integer> abundant = new Vector<Integer>();
		for (int i=1; i<=limit; i++)
		{
			List<Integer> list = Factors.factors(i);
			int sum=0;
			for (int x:list)
				sum += x;
			
			if (sum>i)
				abundant.add(i);
		}

		boolean[] arr = new boolean[limit+1];
		for (int i=0; i<abundant.size(); i++)
			for (int j=i; j<abundant.size(); j++)
			{
				int sum = abundant.get(i)+abundant.get(j);
				if (sum>limit)
					break;
				arr[sum] = true;				
			}
		
		int total=0;
		for (int i=0; i<limit; i++)
			if (!arr[i])
				total += i;
		
		
		long end = System.currentTimeMillis();
		System.out.format("In %d ms, there are %d abundant numbers, with total of %d for those that are not a sum of them%n", 
				(end-start), abundant.size(), total);
	}
}
