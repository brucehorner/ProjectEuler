package euler;

import java.math.BigInteger;

public class P16 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int power = 1000;
		BigInteger two = new BigInteger("2");
		BigInteger result = two.pow(power);
		System.out.println(result);
		
		String str = result.toString();
		long total = 0;
		for (int i=0; i<str.length(); i++)
			total += new Integer(str.charAt(i)-'0');

		System.out.println("Sum="+total);
	}
}
