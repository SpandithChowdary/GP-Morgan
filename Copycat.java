package GP_morgan;

import java.util.*;

public class Copycat {
	
	private static void maxDifference(String word) {
		char[] ch = word.toCharArray();
		Arrays.sort(ch);
		
		char[] new_ch = ch.clone();
		int len = new_ch.length;
		
		int mid = (len + 1) / 2;
        int firstHalf = 0, secondHalf = mid, index = 0;

        while (firstHalf < mid || secondHalf < len) {
            if (secondHalf < len) {
                new_ch[index++] = ch[secondHalf++];
            }
            if (firstHalf < mid) {
               new_ch[index++] = ch[firstHalf++];
            }
        }
        
		for(int i=0; i<len-1 ; i++) {
			if(new_ch[i]==word.charAt(i)) {
				char temp = new_ch[i];
				new_ch[i] = new_ch[i+1];
				new_ch[i+1] = temp;
			}
		}
		
		int diff = 0;
		for(int i=0; i< len ; i++) {
			if(new_ch[i]!=word.charAt(i)) {
				diff++;
			}
		}
		System.out.println(diff);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String str[] = new String[num];
		for(int i=0;i<num;i++) {
			str[i] = sc.next();
		}
		sc.close();
		for(int i=0;i<num;i++) {
			maxDifference(str[i]);
		}
	}
}

/*
 * Problem Statement:

Ashish was copying from Rahit in the exam. So, Rahit told him to change the answers a little
bit so that the examiner cannot find the fraud. But silly Ashish in the way started to change
all the answers that were needed. He shuffled the letters in each word in a way where the
maximum number of letters were misplaced.
For a given word, find the maximum difference that Ashish can generate between his answer
and Rahit’s answer.
Suppose Rahit wrote “car” for an answer, Ashish can write “acr” with difference 2, or “arc”
with differnece 3.
Note That: The letters are all in lowercase.
Input Format:
First line containing an integer n, number of words.
Then, n numbers of lines as the query words.
Output:
N number of lines with an integer each denoting possible maximum difference.
Sample Input:
4
abababa
bbj
kj
kk
Sample Output:
6
2
2
0
 */