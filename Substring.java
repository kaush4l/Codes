import java.util.*;

public class Substring {
	public static void main(String args[]) throws Exception {
		String s = "asljlj";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {

		if (s.length() == 0)
			return 0; // Remove empty String
		int longLength = 1; // Else Default Value would be atleast 1
		for (int fromIndex = 0; fromIndex < s.length() - 1; fromIndex++) {
			int endIndex = s.indexOf(s.charAt(fromIndex), fromIndex + 1);
			int skip = endIndex == -1 ? fromIndex : endIndex; // Skip these values as they will be calculated below
			endIndex = endIndex == -1 ? s.length() : endIndex;
			if (longLength < s.substring(fromIndex, endIndex).length()) { // If substring is less the calculating is
																			// useless as it would obviously be less.
				int newLength = recursiveLen(s.substring(fromIndex + 1, endIndex), 1) + 1; // First element is unique so
																							// it is trimmed and 1 is
																							// added to the answer
				longLength = newLength > longLength ? newLength : longLength;
			}
			fromIndex = skip; // Skipping the counted ones.
		}
		return longLength;
	}

	public static int recursiveLen(String s, int l) {
		if (s.length() == 1)
			return 1; // Repeated value starts from single unique character
		else {
			if (s.indexOf(s.charAt(0), 1) == -1) { // No occurance means the first ch is unique
				return recursiveLen(s.substring(1), l) + 1; // So sending sbbstring(1)
			} else { // Else send only the unique characters
				return recursiveLen(s.substring(0, s.indexOf(s.charAt(0), 1)), l);
			}
		}

	}
}
