package euler;

public class P30
{
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		int limit = 10*(int)Math.pow(9, 5);
		System.out.println(limit);
		int total=0;
		for (int i=2; i<limit; i++)
		{
			//System.out.print(i+": ");
			int num=i;
			int sum=0;
			for (int d=0; d<=(int)Math.log10(i); d++, num /= 10)
			{
				int rem = num%10;
				//System.out.print (rem+", ");
				sum += Math.pow(rem, 5);
			}
			//System.out.print(" sum = "+sum);
			if (sum==i)
			{
				//System.out.println(" ** MATCH **");
				total += i;
			}
			//else
				//System.out.println("");
		}
		
		long end = System.currentTimeMillis();
		System.out.format("Completed in %dms to find total=%d%n",(end-start),total);
	}
}
