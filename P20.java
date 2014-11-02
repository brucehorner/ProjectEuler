package euler;

import java.math.BigInteger;

public class P20
{
	public static void main(String[] args)
	{
		int num = 100;
		BigInteger value = new BigInteger(Integer.toString(num));
		for (int x=num-1; x>0; x--)
			value = value.multiply(new BigInteger(Integer.toString(x)));
		
		System.out.println(num+" factorial is "+value);
		String str = value.toString();
		long total = 0;
		for (int i=0; i<str.length(); i++)
			total += new Integer(str.charAt(i)-'0');

		System.out.println("Sum="+total);
	}
}
