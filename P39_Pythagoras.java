package euler;

public class P39_Pythagoras
{

	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		int maxNumSolutions=0; int maxP=0;
		
		for (int p=1; p<=1000; p++)
		{
			int numSolutions = 0;
			for (int a=1; a<p/4; a++)
				for (int b=a+1; b<(p-a)/2; b++)
				{
					double c = Math.sqrt(a*a + b*b);					
					if (c+a+b==p)
						numSolutions++;					
				}
			
			if (numSolutions>maxNumSolutions)
			{
				maxNumSolutions = numSolutions;
				maxP = p;
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("In "+(end-start)+"ms max P="+maxP+" has num solutions = "+maxNumSolutions);
		
	}

}
