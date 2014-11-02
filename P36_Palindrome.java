package euler;

public class P36_Palindrome
{
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		int sum=0;
		for (int i=1; i<1000000; i++)
			if (i%2!=0 && Utils.isPalindrome(i))
			{
				String binaryVal = Integer.toBinaryString(i);
				if (Utils.isPalindrome(binaryVal))
					sum+=i;
			}

		long end = System.currentTimeMillis();
		System.out.println("In "+(end-start)+"ms, total is "+sum);
	}
}
