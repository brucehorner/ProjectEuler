package euler;

public class P6
{
	public static void main(String[] args)
	{
		int sumSquare=0, squareSum=0;

		for (int i=1; i<=100; i++)
		{
			sumSquare += i*i;
			squareSum += i;
		}
		squareSum *= squareSum;
		int diff = squareSum-sumSquare;
		System.out.format ("Sum of squares is %d, and square of the sums is %d, so difference is %d%n",
				sumSquare,squareSum,diff);
	}
}
