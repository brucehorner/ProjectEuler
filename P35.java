package euler;

import java.util.List;
import java.util.Vector;

public class P35
{
	public static void main(String[] args)
	{
		long start=System.currentTimeMillis();
		List<Integer> primes = Utils.primeSieve(1000000);
		long end=System.currentTimeMillis();
		System.out.println("Generated sieve in "+(end-start));
		List<Integer> circular = new Vector<Integer>();
		//System.out.println(primes);

		for (int num:primes)
		{
			if (num<=11)
				circular.add(num);
			else
			{
				// if circular add all rotations to the list,
				// and remove the others from the main list (if we can!)
				int mult=(int) Math.log10(num);
				int current=num, matches=0;
				//System.out.format("%d mult=%d: ",current,mult);
				for (int rotate=0; rotate<=mult; rotate++)
				{	
					int rem=current%10;
					if (rem==2||rem==0||rem==5)
						break;
					int nxt=current/10;
					int add=rem*(int)Math.pow(10,mult);
					//System.out.format("%d",current);
					current = add+nxt;
					if (primes.contains(current))
					{
						//System.out.format("*");
						matches++;
					}
					else
						break;
					//System.out.format(", ");
				}
				if (matches==(mult+1))
				{
					//System.out.format(" CIRCULAR");
					circular.add(num);
				}
				//System.out.println("");
			}
			
		}
		long end2=System.currentTimeMillis();
		System.out.println((end2-end)+"ms to find num = "+circular.size()+"\n"+circular);
	}
}
