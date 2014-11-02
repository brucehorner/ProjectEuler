package euler;

import java.math.BigInteger;

public class P15
{
	public static void main(String[] args)
	{
		BigInteger top = factorial(new BigInteger("40"));
		BigInteger bottom1 = factorial(new BigInteger("20"));		
		
		System.out.println ("top="+top+", divided="+(top.divide(bottom1.multiply(bottom1))));
	}
	
	private static BigInteger factorial(BigInteger n)
	{
		if (n.abs().equals(BigInteger.ONE))
			return BigInteger.ONE;
		
		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}
