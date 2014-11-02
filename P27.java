package euler;

import java.util.List;

public class P27
{

	public static void main(String[] args)
	{
		List<Integer> primes = Utils.primeSieve(1000);
		int maxCount=0;
		int valAatMax=0, valBatMax=0;
		
		for (int a=-999; a<1000; a++)
			for (int b:primes)
				for (int n=0; n<100; n++)
				{
					int val = n*n + a*n + b;
					if (!primes.contains(val))
					{
						if (n>maxCount)
						{
							maxCount=n;
							valAatMax = a;
							valBatMax = b;
						}
						break;
					}
				}
		
		
		System.out.format ("Max=%d, a=%d, b=%d, product=%d%n", 
				maxCount, valAatMax, valBatMax, valAatMax*valBatMax);
		
	}
}
