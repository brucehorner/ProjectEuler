package euler;

import java.util.List;

public class P46
{
	public static void main(String[] args)
	{

		List<Integer> primes = Utils.primeSieve(100000);
		long start = System.currentTimeMillis();
		for (int i=7;i<500000; i+=2)
		{
			if (primes.contains(i))
				continue;
			
			boolean match=false;
			for (int prime:primes)
			{
				int diff = i-prime;
				if (diff<=0)
					break;
				int rem =diff%2;
				if (rem==0)
				{
					int factor=diff/2;
					double root = Math.sqrt(factor);
					if (root==(int)root)
					{
						//System.out.format("%d = %d + 2x%d**2%n", i, prime, (int)root);
						match=true;
						break;
					}
				}
			}
			
			if (!match)
			{
				long end = System.currentTimeMillis();
				System.out.println("In "+(end-start)+"ms cannot match rule for i="+i);
				break;
			}
			
		}
		

	}

}
