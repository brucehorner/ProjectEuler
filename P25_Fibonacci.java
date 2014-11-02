package euler;

import java.math.BigInteger;

public class P25_Fibonacci
{
	/**
	 * What is the first term in the Fibonacci sequence to contain 1000 digits?
	 */
	public static void main(String[] args)
	{
		BigInteger t1=new BigInteger("1"), t2=new BigInteger("0"); BigInteger value; int pos=0;
		while(true)
		{
			++pos;
			BigInteger next=t1.add(t2);
			System.out.println(next);

			t1 = t2;
			t2 = next;
			String str = String.format("%d",next);
			if (str.length()==1000)
			{
				value = next;
				break;
			}
		}		
		
		System.out.println("Number is " + value+", term is "+pos);
		
	}
}