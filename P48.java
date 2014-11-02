package euler;

import java.math.BigInteger;

public class P48
{
	public static void main(String[] args)
	{
		BigInteger sum = BigInteger.ZERO;
		for (int i=1; i<=1000; i++)
		{
			BigInteger val = BigInteger.valueOf(i);
			sum = sum.add(val.pow(i));
		}
		
		System.out.println(sum);
		
		int digitCount=10;
		BigInteger scale = BigInteger.valueOf((long)Math.pow(10, digitCount));
		BigInteger val = sum.mod(scale);
		System.out.println("Last "+digitCount+" digits are "+val);
	}
}
