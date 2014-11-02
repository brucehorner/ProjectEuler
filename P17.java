package euler;

public class P17
{
	private static final String[] first19 = new String[]
    {
		"", 		"one ",		"two ",		"three ",		"four ",		"five ",
		"six ",		"seven ",		"eight ",		"nine ",		"ten",
		"eleven",		"twelve",		"thirteen",		"fourteen",		"fifteen",
		"sixteen",		"seventeen",		"eighteen",		"nineteen"
    };
	
	private static final String[] decades = new String[]
    {
		"",		"ten",		"twenty ",		"thirty ",		"forty ",		"fifty ",
		"sixty ",		"seventy ",		"eighty ",		"ninety ",		"hundred ",		"thousand "
    };
	
	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer();
		for (int i=1; i<=1000; i++)
		{
			sb.append(first19[(i>=1000)?i/1000:i/100]);		// hundreds or thousands			
			if (i>=1000)
				sb.append(decades[11]);
			else if (i>=100)
				sb.append(decades[10]);
			
			if (i>100 && i%100!=0)
				sb.append("and ");
						
			if (i%100>19)
				sb.append(decades[(i%100)/10]);				// Tens

			sb.append(first19[(i%100<20)?i%20:i%10]);		// Singles
			
			sb.append("\n");
		}
		
		String compressed = sb.toString().replaceAll(" ", "").replaceAll("\n","");
		System.out.println ("Original size = "+sb.length()+", new size = "+compressed.length());
		//System.out.println(sb);
	}
}
