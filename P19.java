package euler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class P19
{
	public static void main(String[] args)
	{
		Calendar cal = Calendar.getInstance();
		cal.set (Calendar.DAY_OF_MONTH,1);
		cal.set (Calendar.MONTH,Calendar.JANUARY);
		cal.set (Calendar.YEAR,1901);
		
		Calendar endCal = Calendar.getInstance();
		endCal.set (Calendar.DAY_OF_MONTH,31);
		endCal.set (Calendar.MONTH,Calendar.DECEMBER);
		endCal.set (Calendar.YEAR,2000);
		
		boolean done=false;
		int total=0;
		while(!done)
		{
			if (cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY
					&& cal.get(Calendar.DAY_OF_MONTH)==1 )
			{
				total++;
				printDate(cal);
			}
				
			cal.add(Calendar.DAY_OF_MONTH, 1);
			if (cal.after(endCal))
				done=true;
		}

		System.out.println ("Total = "+total);
		
	}
	
	private static void printDate(Calendar cal)
	{
		 SimpleDateFormat sdf = new SimpleDateFormat("EE d MMM yyyy hh:mm aaa");
         String date = sdf.format(cal.getTime());
         System.out.println(date);
	}
	
}
