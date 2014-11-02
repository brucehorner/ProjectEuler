package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Utils
{
	/**
	 * Return a simple List of primes less than the specified limit
	 * @param maxValues
	 * @return
	 */
	public static List<Integer> primeSieve(int maxValues)
	{
		boolean[] array = buildArrayForSieve(maxValues);		
		List<Integer> list = new ArrayList<Integer>();
		for (int i=2;i<array.length;i++)
			if(!array[i])
				list.add(i);
		
		return list;
	}

	public static class SieveData
	{
		public Set<Integer> set;
		public int maxValue;
		
	}
	
	/**
	 * Put primes into a Set but have to package with another class to carry the value of the largest prime
	 * in the set
	 * @param maxValues
	 * @return
	 */
	public static SieveData primeSieveSet(int maxValues)
	{
		boolean[] array = buildArrayForSieve(maxValues);
		
		Set<Integer> set = new HashSet<Integer>();
		int maxValue=0;
		for (int i=2;i<array.length;i++)
			if(!array[i])
			{
				set.add(i);
				if (i>maxValue)
					maxValue=i;
			}
		
		SieveData data = new SieveData();
		data.set=set;
		data.maxValue=maxValue;
		
		return data;
	}

	private static boolean[] buildArrayForSieve(int maxValues)
	{
		/*
		 * false= prime;
		 * true = not prime;
		 */		
		boolean[] array = new boolean[maxValues+1];
		for (int i=2;i<Math.sqrt(array.length);i++)
			for (int mult=i*i; mult<array.length; mult+=i)
				array[mult]=true;
		return array;
	}
	
	public static boolean isPandigital(String val, int size)
	{
		if (val.length()!=size)
			return false;
		
		BitSet list = new BitSet(size);
		for (int i=0; i<val.length(); i++)
		{
			int ival=val.charAt(i)-'0';
			if (!(ival!=0 && size>9) && ival<=size) 
				list.set(ival);
		}
		return list.cardinality()==size;		
	}
	
	/**
	 * this will check all digits are used, but will not consider "0" as part of the check
	 * @param val
	 * @return
	 */
	public static boolean isPandigital(int val, boolean useZero)
	{
		int bits=0;	int extra=(useZero?1:2);
		int completeValue = (1 << extra+(int)Math.log10(val)) - extra;	// subtract additional "1" since not checking zero

		while (val>0)
		{
			int lastDigit=val%10;
			int oldBits=bits;
			bits |= 1 << lastDigit;
			System.out.println("val="+val+", lastDigit="+lastDigit+", bits="+bits+", ("+
					Integer.toBinaryString(bits)+"), complete="+completeValue+"("+Integer.toBinaryString(completeValue));
			if (bits==oldBits)		// check for duplicate digit not changing the bitlist
				break;

			val /= 10;
		}
		return completeValue==bits;
	}
	
	public static boolean isPandigital(int val)
	{
		return isPandigital(val,false);
	}
	
	
	public static List<Integer> triangleNumbers(int count)
	{
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=count; i++)
			list.add(i*(i+1)/2);
		return list;
	}
	

	public static List<Integer> pentagonalNumbers(int count)
	{
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=count; i++)
			list.add(i*(3*i-1)/2);
		return list;
	}
	
	public static boolean isPentagonal(int x)
	{
		double n = (Math.sqrt(24*x+1) + 1) / 6.0;
		return ((double)((int)n)==n);
	}
	
	public static boolean isPentagonal(BigInteger x)
	{
		return ((Math.sqrt(24*x.doubleValue()+1) + 1) % 6.0==0);
	}
	
	public static List<Integer> hexagonalNumbers(int count)
	{
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=count; i++)
			list.add(i*(2*i-1));
		return list;
	}	
	
	
	public static long reverse(long n)
	{
		long newValue = 0;
		while (n > 0)
		{
			newValue = 10*newValue + n%10;
			n /= 10;
		}
		return newValue;
	}
	
	public static boolean isPalindrome(long n)
	{
		return n==reverse(n);
	}
	
	public static boolean isPalindrome(String val)
	{
		if (val.length()==0 || val.length()==1)
			return true;
		
		return new StringBuffer(val).reverse().toString().equals(val);
	}
	
    public static String readFileAsString(String file)
    {
    	try
    	{
    		 BufferedReader reader = new BufferedReader( new FileReader (file));
    		 String line  = null;
    		 StringBuilder stringBuilder = new StringBuilder();
    		 String ls = System.getProperty("line.separator");
    		 while( ( line = reader.readLine() ) != null )
    		 {
    			 stringBuilder.append( line );
    		     stringBuilder.append( ls );
    		 }
    		 return stringBuilder.toString();
    	}
    	catch (IOException e)
    	{
    		System.err.println(e);
    		return "";
    	}
    }
    
	public static void main(String[] p)
	{
		/*
		List<Integer> list = primeSieve(100000);
		System.out.println(list);
		*/
		
		for (int val=1234567890; val<1234567891; val++)
		{
			boolean result= isPandigital(val,true);
			System.out.format("The value '%d' is pandigital size %s%n", val, result);
		}
		
		/*
		long i=123456789;
		System.out.println("Reverse of "+i+" is "+reverse(i));
		 */
		/*
		List<Integer> list = triangleNumbers(100);
		System.out.println(list);

		list = pentagonalNumbers(100);
		System.out.println(list);

		list = hexagonalNumbers(100);
		System.out.println(list);
		 */
	}
}
