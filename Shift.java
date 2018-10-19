public class Shift {
	public static void main(String[] args) {
		System.out.println(getShiftedString("ab", 1, 2));
	}

	public static String getShiftedString(String s, int leftShifts, int rightShifts) {
		// Write your code here
		int shift = (leftShifts % s.length()) - (rightShifts % s.length());
		if (shift == 0) {
			return s;
		} else {
			if (shift < 0) {
				return rightShiftString(s, -(shift));
			} else {
				return leftShiftString(s, shift);
			}
		}
	}

	public static String rightShiftString(String s, int shiftLength) {
		return s.substring(s.length() - shiftLength, s.length()).concat(s.substring(0, s.length() - shiftLength));
	}

	public static String leftShiftString(String s, int shiftLength) {
		return s.substring(shiftLength, s.length()).concat(s.substring(0, shiftLength));
	}
}