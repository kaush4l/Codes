import java.util.ArrayList;
import java.util.Collections;

public class repeat {
	public static void main(String args[]) {
		System.out.println(dupli("abcca"));
	}
	
	public static String dupli(String input) {
		
		char[] result = input.toCharArray();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for ( int i = 0; i < result.length; i++ ) {
			for ( int j = i + 1; j < result.length; j++ ) {
				if (result[i] == result[j]) {
					ans.add(j);
				}
			}
		}
		Collections.sort(ans);
		char a = result[ans.get(0)];
		return Character.toString(a);
	}
}
