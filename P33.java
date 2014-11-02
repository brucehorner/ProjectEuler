package euler;

public class P33
{
	public static void main(String[] args)
	{
		int totalTop=1, totalBottom=1;
		for (int top=10; top<100; top++)
			for (int bottom=top+1; bottom<100; bottom++)	// cannot exceed 1.0
			{
				if (top%10==0 && bottom%10==0)
					continue;
				
				int gcd=Factors.gcd(top, bottom);
				if (gcd!=1)
				{
					int t=top/gcd, b=bottom/gcd;
					double divInitial=(double)top/(double)bottom;
					
					if ( top%10==bottom/10)
					{  
						int t1=(top/10), b1=bottom%10;
						double divReduced=(double)t1/(double)b1;
						if (divInitial==divReduced)
						{
							System.out.format("%d/%d=%f, with gcd=%d leading to %d/%d",	top, bottom, divInitial, gcd, t, b);
							System.out.format(" *** match ***%n");
							totalTop *= t1;
							totalBottom *= b1;
						}
					}
					
				}
			}
		int totalGCD = Factors.gcd(totalTop, totalBottom);
		System.out.format("All done, with product of the results = %d/%d%n", totalTop/totalGCD, totalBottom/totalGCD);
	}
}
