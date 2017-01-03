import java.util.ArrayList;
public class InterestingDigits {
	public int[] digits(int base) {
		ArrayList<Integer> inteDi = new ArrayList<Integer>();
		boolean isInteresting = false;
		for(int i = 2; i< base; i++) {
			int j = 1;
			int multipler  = 0;
			while(multipler < 999) {
				String converted = Integer.toString(multipler * i,base); 
				String[] digits = converted.split("");
				
				int sum = 0;
				for(String d : digits) {
					sum += Integer.valueOf(d,base);
				}

				if( (sum % i) == 0 )  {
					isInteresting = true;
				} else {
					isInteresting = false;
					break;
				}
				multipler++;
			}
			if(isInteresting) inteDi.add(i);
		}
		int[] digitsArray = new int[inteDi.size()];
		for(int i=0; i <inteDi.size();  i++) {
			digitsArray[i] = inteDi.get(i).intValue();
		} 
		return digitsArray;
	}
	public static void main(String[] args) {
		InterestingDigits id = new InterestingDigits();
		int[] digits = id.digits(10);
		for(int i : digits)
		System.out.print(i + " ");
		int[] digits3 = id.digits(3);
		for(int i : digits3)
		System.out.print(i + " ");
		int[] digits9 = id.digits(9);
		for(int i : digits9)
		System.out.print(i + " ");
	}
}

/**
Problem Statement

The digits 3 and 9 share an interesting property. If you take any multiple of 3 and sum its digits, you get another multiple of 3. For example, 118*3 = 354 and 3+5+4 = 12, which is a multiple of 3. Similarly, if you take any multiple of 9 and sum its digits, you get another multiple of 9. For example, 75*9 = 675 and 6+7+5 = 18, which is a multiple of 9. Call any digit for which this property holds interesting, except for 0 and 1, for which the property holds trivially.

A digit that is interesting in one base is not necessarily interesting in another base. For example, 3 is interesting in base 10 but uninteresting in base 5. Given an base, your task is to return all the interesting digits for that base in increasing order. To determine whether a particular digit is interesting or not, you need not consider all multiples of the digit. You can be certain that, if the property holds for all multiples of the digit with fewer than four digits, then it also holds for multiples with more digits. For example, in base 10, you would not need to consider any multiples greater than 999.
Definition
Class:
InterestingDigits
Method:
digits
Parameters:
int
Returns:
int[]
Method signature:
int[] digits(int base)
(be sure your method is public)
Limits
Time limit (s):
840.000
Memory limit (MB):
64
Notes
- When base is greater than 10, digits may have a numeric value greater than 9. Because integers are displayed in base 10 by default, do not be alarmed when such digits appear on your screen as more than one decimal digit. For example, one of the interesting digits in base 16 is 15.
Constraints
- base is between 3 and 30, inclusive.
Examples
0)
10
Returns: { 3, 9 }
All other candidate digits fail for base=10. For example, 2 and 5 both fail on 100, for which 1+0+0=1. Similarly, 4 and 8 both fail on 216, for which 2+1+6=9, and 6 and 7 both fail for 126, for which 1+2+6=9.
1)
3
Returns: { 2 }
2)
9
Returns: { 2, 4, 8 }
3)
26
Returns: { 5, 25 }
4)
30
Returns: { 29 }
This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved. 
**/