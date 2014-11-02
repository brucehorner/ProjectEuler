package euler;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ? b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 *
 *1 21 Pythagoras -500
 *220=2^2*5*11  and   284=2^2*71
 *
 *2 X12 Paganini 1860
 *1184=2^5*37  and   1210=2*5*11^2
 *
 *3 22 Euler 1747
 *2620=2^2*5*131  and 2924=2^2*17*43
 *
 *4 22 Euler 1747
 *5020=2^2*5*251  and  5564=2^2*13*107
 *
 *5 X21 Euler 1750
 *6232=2^3*19*41  and  6368=2^5*199
 *
 */
public class P21
{
	public static void main(String[] args)
	{
		rule();

		long start = System.currentTimeMillis();
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		for (int i=2; i<10000; i++)
		{
			List<Integer> divisors = Factors.factors(i);
			int sum=0;
			for (int s:divisors)
				sum += s;
			if (sum!=1)	// don't bother with prime numbers
				table.put(i, sum);
		}
		long amicableSum = 0;
		Enumeration<Integer> keys = table.keys();
		for (int key=keys.nextElement(); keys.hasMoreElements(); key=keys.nextElement() )
		{
			//System.out.print("key="+key);
			if (table.containsValue(Integer.valueOf(key)))
			{
				Integer value = table.get(key);
				if (value.intValue()!=key)
				{
					Integer otherValue = table.get(value.intValue());
					if (otherValue!=null && otherValue.intValue()==key)
					{
						amicableSum +=key; 
						System.out.println ("Amicable pair, key="+key+", value="+ value);
					}
				}
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.format ("In %dms found sum = %d%n", (end-start), amicableSum);
	}

	/**
	 * Thabit ibn Kurrah Rule
	 * 
	 */

	private static void rule()
	{
		List<Integer> primes = P3_Prime.primes(1000000);		
		for (int n=2; n<10; n++)
		{
			int h = (int) ((3 * Math.pow(2,n)) - 1);
			int t = (int) ((3 * Math.pow(2,n-1)) - 1);
			int s = (int) ((9 * Math.pow(2,2*n-1)) - 1);
			
			if (primes.contains(h)&&primes.contains(t)&&primes.contains(s))
			{
				int pair1 = (int) (Math.pow(2, n) *h *t);
				int pair2 = (int) (Math.pow(2, n) * s);
				
				System.out.println("For n="+n+", pair is "+pair1+", "+pair2);
			}		
		}
	}
}
