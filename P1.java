package euler;

public class P1 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long start=System.nanoTime();
		int limit=1000;
		
		/* brute force takes 30 micro seconds*/		
		long total = 0;
		for (int i=1; i<limit; i++)
			if (i%3==0 || i%5==0)
				total += i;
		long end=System.nanoTime();
		System.out.format ("In %,dus, brute force total is %d%n", (end-start)/1000,total);
		
		
		/* sum of consecutive numbers to n is n*(n+1)/2 */
		/* need to subtract the sum of 3*5 */
		/* this is an order of magnitude faster for 1000 numbers */
		start = System.nanoTime();
		int t3 = sum(limit-1,3);
		int t5 = sum(limit-1,5);
		int t15= sum(limit-1,15);
		total = t3 + t5 - t15;
		end=System.nanoTime();
		System.out.format ("In %,dus, using equation total is %d%n", (end-start)/1000,total);
		
	}
	
	private static int sum(int limit, int interval)
	{
		int term=limit/interval;
		return interval * term*(term+1)/2;
	}
	
}
