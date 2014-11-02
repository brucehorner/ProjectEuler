package euler;

import java.util.Vector;

public class P14
{
	public static void main(String[] args)
	{
		int maxLength=0, maxOwner=0;
		for (int starting=1; starting<1000000; starting++)
		{
			long n = starting;
			Vector<Long> list = new Vector<Long>();
			while(true)
			{
				list.add(n);
				if(n==1)
					break;
				n = nextN(n);
			}
			
			if (list.size()>maxLength)
			{
				maxLength = list.size();
				maxOwner = starting;
			}
		}
		
		System.out.format ("Max Length=%d, for number %d%n", maxLength, maxOwner);
		
	}
	
	private static long nextN (long n)
	{
		if (n%2==0)
			return n/2;
		else
			return 3*n+1;
	}
}
