package testing;

import java.util.ArrayList;
import java.util.List;

public class Visa {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("abcd");// Even - AC and Odd - BD
        a.add("aabb");// Even - AB and Odd - AB
        List<String> b = new ArrayList<String>();
        b.add("cbad");// Even - AC and Odd - BD
        b.add("abab");// Even - AA and Odd - BB
        evenCyclicElements(a, b).forEach(ans -> System.out.println(ans));
    }

    // VISA question 4 TWIN Strings
    // Even cyclic elements are elements whose odd places elements and even place elements
    // are same with the comparing elements odd and even place elements
    public static List<String> evenCyclicElements(List<String> a, List<String> b) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; (i < a.size() && i < b.size()); i++) {
            if (compare(a.get(i), b.get(i))) {
                ans.add("YES");
            } else {
                ans.add("NO");
            }
        }
        return ans;
    }

    public static boolean compare(String a, String b) {
        List<Character> aEven = new ArrayList<Character>();
        List<Character> bEven = new ArrayList<Character>();
        List<Character> aOdd = new ArrayList<Character>();
        List<Character> bOdd = new ArrayList<Character>();
        for (int i = 0; i < a.length(); i++) {
            if (i % 2 == 0) {
                aEven.add(a.charAt(i));
            } else {
                aOdd.add(a.charAt(i));
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (i % 2 == 0) {
                if (aEven.contains(b.charAt(i))) {
                    aEven.remove((Character) b.charAt(i));
                } else
                    return false;
            } else {
                if (aOdd.contains(b.charAt(i))) {
                    aOdd.remove((Character) b.charAt(i));
                } else
                    return false;
            }
        }
        return aEven.isEmpty() && aOdd.isEmpty();
    }
}
