package euler;

import java.util.List;

public class P49
{
	public static void main(String[] args)
	{
		List<Integer> primes = P3_Prime.primes(10000);
		for (int p:primes)
		{
			if (p<1000)
				continue;
			int p2=p+3330, p3=p+6660;
			if (primes.contains(p2) && primes.contains(p3) )
			{
				if (P52.sameDigits(p,p2) && P52.sameDigits(p,p3))					
					System.out.println(p+""+p2+""+p3);
			}
		}
	}
}
