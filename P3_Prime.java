package euler;

import java.util.Vector;

public class P3_Prime
{
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		int primeCount=47000;
		Vector<Integer> v = primes(primeCount);
		long end = System.currentTimeMillis();
		System.out.println ("Prime number generation for "+primeCount+" took " + (end-start) + "ms.");
		
		start = System.currentTimeMillis();
		long number=600851475143L, current=number;
		Vector<Integer> factors = new Vector<Integer>();
		for (Integer i:v)
		{
			while (current%i==0)
			{
				factors.add(i);
				current /= i;
			}
			
			if (current==1)
				break;
		}
		end = System.currentTimeMillis();
		System.out.println("Factors of " + number + " are " + factors +". Found in " + (end-start) + "ms.");
		
	}
	
	public static Vector<Integer> primes(int max)
	{
		/*
		 * false = a prime
		 * true = not a prime
		 */
		boolean[] sieve = new boolean[max];
		for (int i=2; i<max; i++)
		{
			if (sieve[i]==false)
			{
				if (i>=Math.sqrt((double)Integer.MAX_VALUE))
				{
					//System.out.println("Too big value: i="+i);
					break;
				}
				
				for (int y=i*i;y<max;y=y+i)
					sieve[y]=true;						
			}
		}
			
		Vector<Integer> v = new Vector<Integer>();
		for (int i=2; i<max; i++)
			if (!sieve[i])
				v.add(i);
		
		return v;
	}
}
