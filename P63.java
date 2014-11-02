package euler;

import java.math.BigInteger;

public class P63
{
	public static void main(String[] args)
	{
		int counter=0;
		for (int i=134217726; i<134217730; i++)
		{
			int size = 1+(int)Math.log10(i);
			double root = Math.pow(i, 1.0/size);
			double diff = root - (int)root;
			boolean match =  Math.abs(diff)<=.00001;
			if (match) counter++;
			System.out.format("%d is %d digits, root=%f, %s match, with diff is %f%n", i, size, root, match, diff);
			System.out.println (" >>> "+ BigInteger.valueOf((int)root).pow(size));
		}

		System.out.println("Counter = "+counter);
	}

}
