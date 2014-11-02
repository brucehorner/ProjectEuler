package euler;

public class P12
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int sum=1;	// we'll skip over number "1" since it's uninteresting
		long start = System.currentTimeMillis();
		out:
		for (int i=2; true; i++)
		{
			sum+=i;	// this is the 'triangle' number
			
			int numFactors=2; // pre-count the number itself and "1" to allow for /2
			//System.out.print(sum+": ");
			for (int f=2;f<=sum/2; f++)
			{
				if (sum%f==0)
				{
					//System.out.print(f+", ");
					if (++numFactors>500)
					{
						//System.out.println(numFactors);
						System.out.println("\nNumber "+sum+" has factors="+numFactors);
						break out;
					}
				}
			}
			//System.out.println(numFactors);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Total time in ms was "+(end-start));

	}
}