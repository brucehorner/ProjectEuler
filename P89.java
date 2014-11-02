package euler;

public class P89
{
	public static void main(String[] args)
	{
		String[] source = { "IIII", "VIIII", "XXXX", "LXXXX", "CCCC", "DCCCC" };
		String[] target = { "IV",   "IX",    "XL",   "XC",    "CD",   "CM" };
		
		String data  = Utils.readFileAsString("H:/roman.txt");
		String cutDown = data;
		for (int i=source.length-1; i>=0; i--)
			cutDown = cutDown.replaceAll(source[i],target[i]);
		
		System.out.println ("Diff = " + (data.length()-cutDown.length()));
	}
}