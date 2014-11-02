package euler;

import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class Factors
{
    public static void main(String[] args)
    {
    	/*
        int n = 644;
        List<Integer> listP = primeFactors(n);        
        List<Integer> list = factors((int)n);        
        System.out.println ("The prime factorization of " + n + " are: " + listP);
        System.out.println ("The proper divisors of " + n + " are: " + list);
        */

    	int p=6, q=19;
		System.out.format("(%d,%d) gcd=%d%n",p,q,gcd(p,q));

    	
    	/*
    	for (int p=1; p<100; p++)
    		for (int q=p+1; q<100; q++)
    			System.out.format("(%d,%d) gcd=%d%n",p,q,gcd(p,q));
    	*/
           	/*   	
    	for (int i=1;i<=25; i++)
    	{
    		List<Integer> list = factors(i);
            System.out.println ("The proper divisors of " + i + " are: " + list);
    	}
        	*/
    }

	public static List<Integer> primeFactors(int n)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

        // for each potential factor i
        for (int i=2; i<=n/i; i++)
            while (n%i==0)	// if i is a factor of N, repeatedly divide it out
            {
                list.add(i);
                n /= i;
            }

        // if biggest factor occurs only once, n > 1
        if (n > 1) 
        	list.add(n);
		return list;
	}
	
	public static List<Integer> factors(int n)
	{
		Vector<Integer> list = new Vector<Integer>();
		list.add(1);
        for (int i=2; i<=Math.sqrt(n); i++)
            if (n%i==0)	// if i is a factor of N add it and move on
            {
                list.add(i);
                if (i!=n/i)
                	list.add(n/i);
            }
		return list;		
	}

	public static int gcd(int first, int second)
	{
		//System.out.println("p="+first+", q="+second);
		if (second==0)
			return first;
		
		if (first<second)
			return gcd(second,first);
		
		return gcd(second, first%second);
	}
	
}