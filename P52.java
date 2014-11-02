package euler;

import java.util.Arrays;

public class P52
{
	public static void main(String[] args)
	{
		for (int x=10; x<Integer.MAX_VALUE/6; x++)
		{
			int x2=2*x, x3=3*x, x4=4*x, x5=5*x, x6=6*x;
			if (sameDigits(x,x2) && sameDigits(x,x3) && sameDigits(x,x4) && sameDigits(x,x5) && sameDigits(x,x6) )
			{
				System.out.println(x+", "+x2+", "+x3+", "+x4+", "+x5+", "+x6);
				break;
			}
		}
	}
	
	public static boolean sameDigits(int n1, int n2)
	{
		return sortedInt(n1) == sortedInt(n2);
	}

	/**
	 * @param n1
	 * @return
	 * @throws NumberFormatException
	 */
	private static int sortedInt(int n1) throws NumberFormatException
	{
		String s1=String.valueOf(n1);
		char[] arr1 = s1.toCharArray();
		Arrays.sort(arr1);
		s1 = String.copyValueOf(arr1);
		int n1a=Integer.valueOf(s1);
		return n1a;
	}


}
