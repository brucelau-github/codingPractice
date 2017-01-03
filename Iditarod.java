/**

Problem Statement
The Iditarod is a dogsled race from Anchorage to Nome that takes many days. We want to take a list of the times when the competitors crossed the finish line and convert that into the average number of minutes to complete the race.

The race starts on day 1 at 8:00 AM. We are given a list of finish times as a , where each finish time is formatted as

    hh:mm xM, DAY n 

where hh is exactly 2 digits giving the hour, mm is exactly 2 digits giving the minute, x is either 'A' or 'P', and n is a positive integer less than 100 with no leading zeros. So each string has exactly 15 or 16 characters (depending on whether n is less than 10).

Create a class Iditarod containing method avgMinutes that is given a , times, and that returns the average number of minutes taken by the competitors to complete the race. Round the returned value to the nearest minute, with .5 rounding up.
Definition
Class:
Iditarod
Method:
avgMinutes
Parameters:
String[]
Returns:
int
Method signature:
int avgMinutes(String[] times)
(be sure your method is public)
Limits
Time limit (s):
840.000
Memory limit (MB):
64
Notes
- "12:00 AM, DAY d" refers to midnight between DAY d-1 and DAY d
- "12:00 PM, DAY d" refers to noon on DAY d
Constraints
- times contains between 1 and 50 elements inclusive
- each element of times is formatted as specified above, with hh between 01 and 12 inclusive, mm between 00 and 59 inclusive, and d between 1 and 99 inclusive
- each element of times represents a time later than the start of the race
Examples
0)
{"12:00 PM, DAY 1","12:01 PM, DAY 1"}
Returns: 241
From 8:00 AM to noon is 4 hours, so we have 4 hours for one competitor, and 4 hours, 1 minute for the other. These two values average to 240.5 minutes which is rounded up.
1)
{"12:00 AM, DAY 2"}
Returns: 960
The one competitor finished in 16 hours, just at the start of DAY 2.
2)
{"02:00 PM, DAY 19","02:00 PM, DAY 20", "01:58 PM, DAY 20"}
Returns: 27239
26280 minutes, 27720 minutes, 27718 minutes average to 27239.333 which rounds down.
**/
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Iditarod {
	public int avgMinutes(String[] times) {
		int sum = 0; 
		for(String time:times) {
			Calendar startTime = Calendar.getInstance();
			startTime.clear();
			startTime.set(2001,0,1,8,00);
			
			Calendar endTime = Calendar.getInstance();
			endTime.clear();

			String[] tmp = time.split(",");
			String[] days = tmp[1].split("\\s+");
			int day = Integer.parseInt(days[2]) - 1;

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd h:mm a");
			try {
				Date dt = df.parse("2001-01-01 " +tmp[0]);
				endTime.setTime(dt);
			} catch (Exception e) {
				
			}
			endTime.roll(Calendar.DAY_OF_MONTH,day);

			long min = Math.round((endTime.getTimeInMillis()-startTime.getTimeInMillis())/(1000*60));
			sum += min;
		}
		return Math.round((float)sum/(times.length));
	}
	public static void main(String[] args) {
		Iditarod id = new Iditarod();
		System.out.println(id.avgMinutes(new String[]{"12:00 AM, DAY 2"}));
		System.out.println(id.avgMinutes(new String[]{"10:00 AM, DAY 2"}));
		System.out.println(id.avgMinutes(new String[]{"12:00 PM, DAY 1","12:01 PM, DAY 1"}));
		System.out.println(id.avgMinutes(new String[]{"02:00 PM, DAY 19","02:00 PM, DAY 20", "01:58 PM, DAY 20"}));
	}
}