package euler;

import java.math.BigInteger;

public class P53
{
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		BigInteger limit = BigInteger.valueOf(1000000);
		int total=0;
		for (int n=1; n<=100; n++)
			for (int r=1; r<n; r++)		// nCn==1
			{				
				BigInteger factN = factorial(n);
				BigInteger factR = factorial(r);
				BigInteger factDiff = factorial(n-r);
				BigInteger combination = factN.divide((factR.multiply(factDiff)));
				if (combination.compareTo(limit)>0)
				{
					//System.out.format ("%dC%d = %d (%d/(%d * %d)%n", n, r, combination, factN,factR,factDiff);
					total++;
				}
			}

		long end=System.currentTimeMillis();
		System.out.format ("In %,dms, found total of %d%n", (end-start), total);
	}

	
	public static BigInteger factorial(int n)
	{
		if (n<=1)
			return BigInteger.ONE;
		return factorial(n-1).multiply(BigInteger.valueOf(n));
	}
	
}
