package euler;
import java.util.List;

public class P42_Triangle
{
	public static void main(String[] args)
	{
		
		String data  = Utils.readFileAsString("H:/words.txt");
		System.out.println("Read file size " + data.length());
		
		String[] words = data.replaceAll("\"","").replaceAll("\n","").replaceAll("\r","").split(",");
		System.out.println("Number of names is " + words.length);

		long start = System.currentTimeMillis();
		List<Integer> triangleNumbers = Utils.triangleNumbers(20);
		System.out.println(triangleNumbers);

		int count=0;
		for (int i=0; i<words.length; i++)
		{
			int value=0;
			char[] arr = words[i].toCharArray();
			for (int c=0; c<arr.length; c++)
				value += arr[c]-'A'+1;
			
			if (triangleNumbers.contains(value))
				count++;
		}
		
		long end = System.currentTimeMillis();
		System.out.format("In %dms, found total = %d%n", (end-start), count);		
	}

}
