package euler;

import java.math.BigInteger;

public class P45
{
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		for (int i=144; i<200000;i++)		// given that the number is after iteration 143
		{
			BigInteger counter = BigInteger.valueOf(i);
			BigInteger h = counter.multiply(counter.multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE));
			if (Utils.isPentagonal(h))
			{
				System.out.println("** Match ** "+h+", iteration "+i);
				break;
			}
		}
		long end=System.currentTimeMillis();
		System.out.println("Completed in "+(end-start)+"ms.");
	}

}
