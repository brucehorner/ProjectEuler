package euler;


public class P59_Encyyption
{

	public static void main(String[] args)
	{
		String data = Utils.readFileAsString("C:/users/Bruce/workspace/cipher1.txt");
		// split by comma and load into char array
		
		String[] chars = data.replaceAll("\n","").replaceAll("\r","").split(",");
		char[] ca = new char[chars.length];		
		for (int i=0; i<chars.length; i++)
			ca[i] = (char)Integer.valueOf(chars[i]).intValue();
		
		char[] key = new char[] { 'a', 'b', 'c' };
		char[] target = new char[ca.length];
		
		for (int i=0; i<ca.length; i++)
		{
			target[i] = (char) (ca[i] ^ key[i%3]);
			if (i<100)
			{
				System.out.format("i=%d, ca[i]=%d(%c) key=%c, target=%d(%c)%n",
						i, (int)ca[i], ca[i], key[i%3], (int)target[i], target[i]);
			}
		}
		
		
	}
}
