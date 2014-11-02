package euler;

import java.math.BigInteger;

public class Fraction
{
	public BigInteger numerator;
	public BigInteger denominator;
	
	public Fraction() { this("0","0"); }
	
	public Fraction(String top, String bottom)
	{
		numerator=new BigInteger(top); denominator=new BigInteger(bottom);
	}

}
