package euler;

import java.util.ArrayList;

public class P24
{
	public static void main(String[] args)
	{
		int level = 999999;//1000000;
		int size  = 10;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] factorials = new int[size];
		factorials[0]=1; list.add(0);
		for (int i=1;i<factorials.length; i++)
		{
			factorials[i] = factorials[i-1]*i;
			list.add(i);
		}
		
		StringBuffer value = new StringBuffer();
		for (int i=factorials.length-1; i>=0; i--)
		{
			System.out.println ("i="+i);
			System.out.println(" > List="+list+", factorial is "+factorials[i]);
			int cycle=0;
			while (level-factorials[i]>=0)
			{
				cycle+=1;
				level -= factorials[i];
			}
			value.append(list.get(cycle));
			list.remove(cycle);
			System.out.println (" > Cycle="+cycle);
			System.out.println (" > Level="+level);
			System.out.println (" > Value="+value);
		}
		System.out.println ("Value="+value);			
	}
}