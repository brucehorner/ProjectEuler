package euler;

import java.util.HashSet;

public class P32_Pandigital
{
	public static void main(String[] args)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		for (int num=1; num<=40000; num++)
		{
			for (int i=1; i<=2000; i++)
			{
				int sum = num*i;
				String str=String.valueOf(num).concat(String.valueOf(i).concat(String.valueOf(sum)));
				if (str.length()>9)
					break;

				if (Utils.isPandigital(str,9))
					set.add(sum);
			}
		}
		
		long sum=0;
		for (Integer i:set)
			sum += i;
		
		System.out.println("Sum = "+sum);
	}
}
