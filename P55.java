package euler;

import java.math.BigInteger;

public class P55
{
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		int totalLychrelNumbers=0, limit=10000;
		for (long i=1; i<limit; i++)
		{
			int cycle= 1;
			long sum = i;
			while(true)
			{
				long num = sum;
				long rev = Utils.reverse(num);
				sum = num+rev;
				
				if (Utils.isPalindrome(sum))
					break;
				
				cycle++;
				if (cycle>50)
				{					
					totalLychrelNumbers++;
					break;
				}
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.format ("In %,dms, found %d numbers %n",	(end-start), totalLychrelNumbers);
	}
}
