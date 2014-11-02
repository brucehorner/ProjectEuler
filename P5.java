package euler;

public class P5
{
	public static void main(String[] args) 
	{
		int limit = 20;
		
		for (long x=limit+1; x<800000000; x++)
		{
			if (checkFactors(limit,x))			
				System.out.println (" *** match for "+x);
		}
		

	}

	private static boolean checkFactors(int limit, long x)
	{		
		for (int y=1; y<=limit; y++)
			if (x%y!=0)
				return false;
		return true;
	}
}
