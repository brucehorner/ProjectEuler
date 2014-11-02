package euler;

public class P38_Pandigital
{
	public static void main(String[] args)
	{
		int maxNum=0;
		for (int num=1; num<=20000; num++)
		{
			String concat=new String();
			for (int i=1; i<=200; i++)
			{
				int sum = num*i;
				concat += String.valueOf(sum);
				if (concat.length()>9)
					break;
				if (Utils.isPandigital(concat,9))
				{
					System.out.println("*** Pandigital "+concat+" for num="+num+" and max i="+i);
					int numValue =Integer.decode(concat); 
					if (numValue>maxNum)
						maxNum = numValue;
				}
			}
		}
		
		System.out.println("Max Number = "+maxNum);
	}
}
