package euler;

public class P28_P58Prime
{
	public static void main(String[] args)
	{

		// p28();
		
		p58();
	}


	private static void p58()
	{
		long start=System.currentTimeMillis();
		Utils.SieveData primes = Utils.primeSieveSet(700000000);

		int maxPrime = primes.maxValue;
		long end1=System.currentTimeMillis();
		System.out.format("In %,dms have %,d primes, max value is %,d%n", (end1-start), primes.set.size(), maxPrime);
		
		int totalCount=1, primeCount=0;
		for (int width=3; width<=30000; width+=2)
		{
			int arr[] = new int[4];
			arr[0] = width*width;
			arr[1] = arr[0]-width+1;
			arr[2] = arr[1]-width+1;
			arr[3] = arr[2]-width+1;
			totalCount += 4;
			
			if (arr[0]>maxPrime)
			{
				System.err.println("*** Prime list isn't large enough: width="+width);
				break;
			}
			
			for (int j=1; j<arr.length; j++)
				if (primes.set.contains(arr[j]))
					primeCount++;
			
			double ratio = (double)primeCount / (double)totalCount;
			if (width%99==0)
				System.out.format ("For i=%d (maxnum=%,d), primeCount=%d, totalCount=%d, ratio=%f%n", width, arr[0], primeCount, totalCount, ratio);

			
			if (ratio<0.1)
			{
				System.out.println ("End of the line with side = " + width);
				break;
			}
			
		}
		
		long end2=System.currentTimeMillis();
		System.out.println("Completed stage 2 in "+(end2-end1)+"ms.");
	}

	
	/** 
	 * (1) first cut of code in the loop, long hand version:
	 *     start with i=3 and jump up in twos to ensure i is always odd 
	int sq = i*i, t1=sq-i+1, t2=t1-i+1, t3=t2-i+1;
	sum += sq;
	sum += t1;
	sum += t2;
	sum += t3;
	*
	* (2) collapsed the above into one line per iteration
	* 
	* sum += 4*i*i-6*(i-1);
	* 
	* (3) this can be further simplified into one statement with no loop
	* but this requires some math knowledge (the Knowing bit)
	* 
	* Knowing: The sum of the first k odd squares is k(4k*k-1)/3
	* Knowing: The sum of the first k odd numbers is k*k.
	* Knowing: that 1001 is the 501st odd number
	* we get sum = 4*k*(4*k*k-1)/3-6*k*(k-1);
	* but we need to account for the first degenerate piece, so subtract 4 and add 1
	**/
	private static void p28()
	{
		int sum=1;
		for (int i=3; i<=1001; i+=2)
			sum += 4*i*i-6*(i-1);
		
		int k=501;
		int sum2 = 4*k*(4*k*k-1)/3-6*k*(k-1) - 3;
		System.out.println ("Sum = " + sum +", sum2 = "+sum2);
	}
}
