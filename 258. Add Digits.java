// Version One: Loop
public class Solution{
	public int addDigits(int num){
		int oneth;
		int tenth;
		int sum = num;

		while(sum / 10 != 0){
			oneth = sum % 10;
			tenth = sum / 10;
			sum = oneth + tenth;
		}

		return sum;
	}
}


// Version Two: Find pattern by observing 
// 123456789 10 11 12 13 14 15
// 123456789 1 2 3 4 5 6
public class Solution{
	public int addDigits(int num){
		return 1 + (num - 1) & 9;
	}
}