package euler;

import java.math.BigInteger;
import java.util.HashSet;

public class P29
{

	public static void main(String[] args)
	{
		HashSet<BigInteger> set = new HashSet<BigInteger>();
		for (int a=2; a<=100; a++)
			for (int b=2; b<=100; b++)
				set.add(BigInteger.valueOf(a).pow(b));

		System.out.println("Size="+set.size());
	}

}
