package euler;

public class P9 {

	/**
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a*a + b*b = c*c

For example, 3*3 + 4*4 = 9 + 16 = 25 = 5*5.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

	 */
	public static void main(String[] args)
	{
		int limit=1000;
		out:
		for (int a=1;a<=limit;a++)
			for (int b=a+1;b<=limit;b++)
				for (int c=b+1;c<=limit;c++)
				{
					if ( (a+b+c)==limit && (a*a+b*b==c*c) )
					{
						System.out.format("Interesting: a,b,c=%d,%d,%d%n",a,b,c);
						System.out.format("Product=%d%n",a*b*c);
						break out;
					}
				}
	}
}
