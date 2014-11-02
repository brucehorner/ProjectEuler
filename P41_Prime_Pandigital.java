package euler;


import java.util.List;

public class P41_Prime_Pandigital
{
	public static void main(String[] args)
	{
		// Sum of digits for 9 length is 45, therefore cannot be prime
		// Sum of digits for 8 length is 36, therefore cannot be prime
		// max number will be 7 digits
		long start=System.nanoTime();
		List<Integer> primes = Utils.primeSieve(7654321);
		System.out.println("Got "+primes.size()+" primes...");
		
		for (int i:primes)
		{
			if (Utils.isPandigital(i))
				System.out.println(i);
		}
		
		
		long end=System.nanoTime();
		System.out.format("In %,dus, done%n", (end-start)/1000);
	}
	

}
