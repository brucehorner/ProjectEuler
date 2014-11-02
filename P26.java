package euler;

import java.util.HashMap;

public class P26
{
	public static void main(String[] args)
	{	
		long start = System.nanoTime();
		int maxLength=0, maxValue=0;
		for (int i=997; i>5; i--)
		{
			int len = repeatingCycleByLongDivision(1, i);
			//System.out.println(i+": "+len);
			if (len>maxLength)
			{
				maxLength=len;
				maxValue=i;
			}
			
			if (maxLength>i)
				break;
		}		
		
		long end = System.nanoTime();
		System.out.format("In %,dus, Max Len is %d for value of %d%n", (end-start)/1000, maxLength, maxValue);
	}

	private static int repeatingCycleByLongDivision(int originalTop, int bottom)
	{
		int top=originalTop, loops=0, rem=0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();	// Key = remainder, Value = position
		//StringBuffer s = new StringBuffer();
		//boolean periodAdded=false;
		
		while(true)
		{
			int div=0;
			while ((div=top/bottom)==0)
			{
				/*
				s.append(div);
				if (!periodAdded)
				{
					periodAdded=true;
					s.append(".");
				}
				*
				*/
				
				top *= 10;
				loops++;
			}
			
			rem = top%bottom;
			if (rem==0)
			{
				//s.append(div);
				//System.out.println("  >> Terminated, loop = "+loops+", div="+div+", rem="+rem);
				//System.out.format (" >> %d/%d = %s%n",originalTop,bottom,s.toString());
				return 0;
			}
			

			Integer oldPosition = map.put(rem,loops);
			if ( oldPosition!=null )
			{
				int repeatCycleLength=loops-oldPosition;
				/*
				// tack on the last divisor if not already there
				if (s.indexOf(String.valueOf(div))==-1)
					s.append(div); 
				// if we tacked on a repeat earlier loop in error, remove it
				if (s.charAt(s.length()-1)=='0')
					s.deleteCharAt(s.length()-1);
				
				// bracket the repeating cycle
				s.insert(s.length()-repeatCycleLength, '(');
				s.append(')');
				//System.out.format (" >> %d/%d = %s%n", originalTop, bottom, s.toString());
				 * 
				 */
				return repeatCycleLength;
			}
			
			//s.append(div);
			top = rem*10;
			loops++;
		}		
	}
}
