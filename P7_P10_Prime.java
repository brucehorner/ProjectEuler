package euler;

import java.util.Vector;

public class P7_P10_Prime
{
	public static void main(String[] args)
	{
		long start =System.nanoTime();
		Vector<Integer> list = P3_Prime.primes(38000000);
		long end = System.nanoTime();
		System.out.println("Vector size is "+ list.size());
		System.out.println ("#6 = " + list.get(5));
		System.out.println ("#10001 = " + list.get(10000));
		System.out.println("Time = "+(end-start)+"ns.");
		
		/*
		 * P10
		 */
		int limit=2000000; 
		long sum=0;
		for (int i=0; i<list.size(); i++)
		{
			int prime=list.get(i);
			if (prime>limit)
				break;
			sum += prime;
		}
			
		System.out.println("Sum of primes less than "+limit+" is "+sum);
	}
}
