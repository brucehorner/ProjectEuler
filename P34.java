package euler;

import java.util.Hashtable;

public class P34
{
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		// first build a lookup table 
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		for (int i=0; i<10; i++)
		{
			int factorial = 1;
			for (int f=i; f>=1; f--)
				factorial *= f;
			table.put(i,factorial);
		}
		
		long overallSum =0;
		for (int i=3; i<362880; i++)	// upper limit is 9!
		{
			long sum=0;
			int num=i;
			for (int d=0; d<=(int)Math.log10(i); d++, num /= 10)
			{
				int rem = num%10;
				sum += table.get(rem);
			}

			if (sum==i)
				overallSum += sum;
		}
		
		long end = System.currentTimeMillis();
		System.out.format ("In %dms, found overall sum is %d%n", (end-start), overallSum);
	}
}
