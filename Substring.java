import java.util.*;

public class Substring {
	public static void main(String args[]) throws Exception {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {

		int longLength = 1;
		for (int fromIndex = 0; fromIndex < s.length() - 1; fromIndex++) {
			int endIndex = s.indexOf(s.charAt(fromIndex), fromIndex + 1);
			endIndex = endIndex == -1 ? s.length(): endIndex;
			if(longLength < s.substring(fromIndex, endIndex).length())
				longLength = recLen(s.substring(fromIndex+1, endIndex), 1) + 1;
		}
		return longLength;
	}

	public static int recLen(String s, int l) {
		if (s.length() == 1)
			return 1;
		else {
			if (s.indexOf(s.charAt(0) , 1) == -1) {
				return recLen(s.substring(1), l) + 1;
			} else {
				return recLen(s.substring(0,s.indexOf(s.charAt(0) , 1)), l);
			}
		}

	}
}