/**
Problem Statement

You are looking for a place to park your car on a suburban street. You can park at any position that meets the following requirements:

1.	It is not directly in front of a private driveway.
2.	It is not directly in front of a bus stop.
3.	It is not 5 meters before a bus stop.
4.	It is not 5 meters after a bus stop.
5.	It is not directly in front of a side-street.
6.	It is not 5 meters before a side-street.
7.	It is not 5 meters after a side-street.

The street will be represented as a , where each character describes a section of the street 5 meters in length. So the first character describes the first 5 meters of the street, the second character describes the next 5 meters and so on. street will use 'D' for driveway, 'B' for bus stop, 'S' for side-street and '-' for all other sections of the street. A position is directly in front of an object if it has the same index as the object in street. A position is before an object if its index is lower than the index of the object in street. Finally, a position is after an object if its index is higher than the index of the object in street.

Given the street return the total number of possible parking spaces on that street.
Definition
Class:
StreetParking
Method:
freeParks
Parameters:
String
Returns:
int
Method signature:
int freeParks(String street)
(be sure your method is public)
Limits
Time limit (s):
840.000
Memory limit (MB):
64
Constraints
- street will have between 1 and 50 characters inclusive.
- street will only contain characters 'D', 'B', 'S' and '-'.
Examples
0)
"---B--S-D--S--"
Returns: 4
The street looks like this:

---B--S-D--S--
^   ^    ^   ^
|   |    |   |

The arrows indicate where you are allowed to park on this street. Thus the method should return 4.
1)
"DDBDDBDDBDD"
Returns: 0
This street is full of private driveways and bus stops. You cannot park anywhere on this street. The method should return 0.
2)
"--S--S--S--S--"
Returns: 2
You can only park at the first and last positions on this street. The method should return 2.
3)
"SSD-B---BD-DDSB-----S-S---------S-B----BSB-S--B-S-D"
Returns: 14

**/
public class StreetParking {
	public int freeParks(String street) {
		//find current position check all principle.
		String amendedStreet = "-" + street + "-";
		int counter = 0 ;
		char[] streetChar = amendedStreet.toCharArray();
		for(int i =1; i< streetChar.length-1;i++) {
				if(match(streetChar[i-1],streetChar[i],streetChar[i+1])) 
				counter++;
		}
		return counter;
	}
	private boolean match(char a,char b,char c) {
		if(a == '-' && b == '-' && c == '-') return true;
		if(a == 'D' && b == '-' && c == 'D') return true;
		if(a == '-' && b == '-' && c == 'D') return true;
		if(a == 'D' && b == '-' && c == '-') return true;
		return false;
	}

	public static void main(String[] args) {
		StreetParking id = new StreetParking();
		System.out.println(id.freeParks("---B--S-D--S--"));
		System.out.println(id.freeParks("DDBDDBDDBDD"));
		System.out.println(id.freeParks("--S--S--S--S--"));
		System.out.println(id.freeParks("SSD-B---BD-DDSB-----S-S---------S-B----BSB-S--B-S-D"));
	}
}