package euler;

public class P40
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long start=System.nanoTime();
		StringBuffer s = new StringBuffer();
		for (int i=1; i<=1000000; i++)
			s.append(i);
		

		int sum=1;
		for (int p=1; p<7; p++)
		{
			int loc=(int)Math.pow(10, p);
			int val=s.charAt(loc-1)-'0';
			sum *= val;
		}
		
		long end=System.nanoTime();
		System.out.format("In %,dns, sum = %d%n", (end-start), sum);

	}

}
