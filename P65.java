package euler;
import java.math.BigInteger;
import java.util.ArrayList;

public class P65
{
	public static void main(String[] args)
	{
		int limit=100;
		ArrayList<BigInteger> numerators  = new ArrayList<BigInteger>(limit);
		ArrayList<BigInteger> denominators= new ArrayList<BigInteger>(limit);
		numerators.add(0,BigInteger.valueOf(2));	numerators.add(1,BigInteger.valueOf(3));
		denominators.add(0,BigInteger.ONE);			denominators.add(1,BigInteger.ONE);
		
		for (int term=2; term<limit; term++)
		{
			int factor = ((term+1)%3==0 ? (2*(term+1))/3 : 1);
			numerators.add(term,  numerators.get(term-1).multiply(BigInteger.valueOf(factor)).add(numerators.get(term-2)));
			denominators.add(term, denominators.get(term-1).multiply(BigInteger.valueOf(factor)).add(denominators.get(term-2)));
			System.out.format ("Term %d: factor=%d, new value=%d/%d%n",
					term,factor,numerators.get(term),denominators.get(term));
		}
		
		BigInteger val=numerators.get(limit-1);
		int sum=0;
		while (!val.equals(BigInteger.ZERO))
		{
			int digit = val.mod(BigInteger.valueOf(10)).intValue();
			sum += digit;
			val = val.divide(BigInteger.valueOf(10));
		}
		
		System.out.println ("Value is "+numerators.get(limit-1)+", sum = "+sum);
	}
}
