package euler;

public class P4
{
	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		int maxMatch=0;
		for (int x=999; x>99; x--)
			for (int y=999; y>99; y--)
			{
				int product=x*y;
				boolean matched = isPalindrome(product);
				if (matched)
				{
					if (product>maxMatch)
						maxMatch=product;					
					break;
				}
				
			}
		long end = System.currentTimeMillis();
		System.out.println("elapsed time = " + (end-start)+", max="+maxMatch);
	}
	
	public static boolean isPalindrome (int num)
	{
		String str = String.format("%d", num);
		boolean match = str.equals(new StringBuffer(str).reverse().toString());
		return match;
	}
}
