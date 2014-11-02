package euler;

import java.math.BigInteger;
import java.util.Arrays;

public class P22
{
	public static void main(String[] args)
	{
		String data  = Utils.readFileAsString("H:/names.txt");
		System.out.println("Read file size " + data.length());
		
		String[] names = data.replaceAll("\"","").replaceAll("\n","").replaceAll("\r","").split(",");
		Arrays.sort(names);
		System.out.println("Number of names is " + names.length);
		
		BigInteger total = new BigInteger("0");
		for (int i=1; i<=names.length; i++)
		{
			int value=0; String str = new String();
			char[] arr = names[i-1].toCharArray();
			for (int c=0; c<arr.length; c++)
			{
				int token = arr[c]-'A'+1;
				value += token;
				str = str + "(" + token + ")";
			}
			long x = i * value;
			total = total.add(BigInteger.valueOf(x));
			System.out.format("%d: %s, %s %dx%d=%d, total=%d%n",
					i, names[i-1], str, i, value, x, total);		
		}
		
		System.out.println("Total = " + total);		
	}
	


}
