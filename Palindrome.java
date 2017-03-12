import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class Palindrome {
	public static void main(String[] args) {
		System.out.println(palindrome("hellolle"));
		System.out.println(palindrome("wowpurerocks"));
	}
	static int palindrome(String S) {
		int ans = S.length();
		for(int i = 0; i < S.length(); i++) {
			for (int j = i + 2; j < S.length()+1; j++) {
				int p = pal(S.substring(i,j));
				ans += p;
			}
		}
		return ans;
	}
	static int pal(String s) {
		int answer = 0;
		if(s.length() == 2 ) {
			if(s.charAt(0) == s.charAt(1)) answer = 1;
		} else {
			for(int i = 0; i < s.length()/2; i++) {
				char f = s.charAt(i);
				if( f == s.charAt(s.length() - i - 1) ) answer++;
			}
		}
		if (answer == s.length()/2 ) {
			answer = 1;
		} else answer = 0;
		return answer;
	}
}
