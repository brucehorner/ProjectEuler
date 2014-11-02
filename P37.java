package euler;

import java.util.Collections;
import java.util.List;

public class P37
{
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		List<Integer> primes = P3_Prime.primes(800000);
		int sum=0;
		
		for (int p: primes)
		{
			if (p<11)
				continue;
			
			//System.out.print(p+": truncating =>");
			boolean skip=false;
			int x=p;
			while (!skip && x>0)
			{
				if (Collections.binarySearch(primes,x)<0)
					skip=true;
				x /= 10;
			}
			
			x=p;
			while (!skip && x>0)
			{
				if (Collections.binarySearch(primes,x)<0)
					skip=true;
				int order = (int)Math.pow(10,(int)Math.log10(x));
				x %= order;
			}
			if (!skip)
			{
				System.out.println(" *** Truncatable=" + p);
				sum += p;
			}
		}
		
		long end=System.currentTimeMillis();
		System.out.format("In %,dms, found sum=%,d%n",(end-start),sum);
	}
}
