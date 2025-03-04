package GP_morgan;

import java.util.*;

public class new_number_system {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String abc = "abcdefghijklmnopqrstuvwxyz";
		char[] ch = abc.toCharArray();
		int num =1;
		
		String str = sc.next();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : ch) {
			map.put(c,num);
			num++;
		}
		
		if(str.length()<1) {
			int n = map.get(str.charAt(0));
			System.out.println(n);
		}else {
			for(int i=0;i<str.length();i++) {
		    	int n = map.get(str.charAt(i));
			    if((i+1) == str.length()) {
					System.out.print(n);
					break;
			    }else {
					System.out.print(n+1);
			    }
			}
		}
		
		sc.close();
	}
}


/*
Problem Statement:
Here is about to introduce a new kind of number system. Where instead of 10 digits there is
20, from a to t, all in small. Now a means 1, b means 2 and t means 20, thenn aa means 21.
Now for a new number you have to print the decimal form it.
Note that the letters in the input string will be lower case and from a to t.
Input Format:
Single line containing the string of new number system’s number
Output Format:
Single line denoting the integer with the same decimal value as the input string
Sample input 1: e
Sample Output: 5
Sample Input 2: ac
Sample Output: 23
*/