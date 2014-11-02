package euler;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Date;

public class P104_Fibonacci_Pandigital
{
	public static void main(String[] args)
	{
		BigInteger  t1=new BigInteger("1"), 
					t2=new BigInteger("0"), 
					next=new BigInteger("0"),
					last9=new BigInteger("0"),
					billion = new BigInteger("1000000000");		
		int term=0;
		System.out.println("Start at "+now());
		long start = System.currentTimeMillis();
		
		while(true)
		{
			++term;
			next=t1.add(t2);
			//if (term%5000==0) System.out.println(term+": "+now());

			t1 = t2;
			t2 = next;
			
			last9 = next.mod(billion);		
			if (Utils.isPandigital(last9.toString(),9))
			{
				//System.out.println("***last: "+term+": "+last9);	
				String first9 = next.toString().substring(0,9);
				if (Utils.isPandigital(first9,9))
				{
					//System.out.println("** First 9 full match: term="+term);
					break;
				}
			}
		}
		long end=System.currentTimeMillis();
		System.out.println("In "+(end-start)+"ms. found term "+term);
		
	}
	
	private static String now()
	{
		Date todaysDate = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		return formatter.format(todaysDate);
	}

	
}
