import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Regex {
	public static void main(String[] args) {
		System.out.println(regexTester(Arrays.asList("255.007.07.7", "7.07.007.23")));
	}

	public static List<String> regexTester(List<String> inputs) {
		List<String> ans = new ArrayList<String>();
		for (String input : inputs) {
			ans.add(ipv4(input) ? "IPv4" : ipv6(input) ? "IPv6" : "Wrong");
		}
		return ans;
	}

	public static boolean ipv4(String input) {
		if (Pattern.matches("(([2][5][0-5]" + "|([2][0-4]|[1][0-9])[0-9]|" + "[0]?[0-9]?[0-9])\\.){3}"
				+ "([2][5][0-5]|([2][0-4]|[1][0-9])[0-9]|[0]?[0-9]?[0-9])", input)) {
			return true;
		}
		return false;
	}

	public static boolean ipv6(String input) {
		return false;
	}

}
