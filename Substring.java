import java.util.*;

public class Substring {
	public static void main(String args[]) throws Exception {
		String s = "asljlj";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {

		if (s.length() == 0)
			return 0;
		int longLength = 1;
		for (int fromIndex = 0; fromIndex < s.length() - 1; fromIndex++) {
			int endIndex = s.indexOf(s.charAt(fromIndex), fromIndex + 1);
			endIndex = endIndex == -1 ? s.length() : endIndex;
			if (longLength < s.substring(fromIndex, endIndex).length()) {
				int newLength = recursiveLen(s.substring(fromIndex + 1, endIndex), 1) + 1;
				longLength = newLength > longLength ? newLength : longLength;
			}
		}
		return longLength;
	}

	public static int recursiveLen(String s, int l) {
		if (s.length() == 1)
			return 1;
		else {
			if (s.indexOf(s.charAt(0), 1) == -1) {
				return recursiveLen(s.substring(1), l) + 1;
			} else {
				return recursiveLen(s.substring(0, s.indexOf(s.charAt(0), 1)), l);
			}
		}

	}
}
