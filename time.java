import java.util.ArrayList;
import java.util.Collections;

public class time {
	public static void main(String args[]) {
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(5);num.add(6);num.add(0);num.add(6);
		int h1,h2,m1,m2;
		Collections.sort(num);
		if (num.contains(0) || num.contains(1) || num.contains(2)) {
			if (num.contains(2)){
				h1 = 2;
				int ih1 = num.indexOf(2);
				num.remove(ih1);
				if (num.contains(0) || num.contains(1) || num.contains(2) || num.contains(3)) {
					if (num.contains(3)) {
						h2 = 3;
						int ih2 = num.indexOf(3);
						num.remove(ih2);
						int num2 = Collections.max(num);
						int im12 = num.indexOf(num2);
						int num1 = num.get(0);
						num.remove(im12);
						if ( num1 < 6 ) {
							if ( num2 < 6 ) {
								m1 = num2; m2 = num1;
								System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
							} else {
								m2 = num2; m1 = num1;
								System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
							}
						} else {
							System.out.println("Time not possible");
						}
					} else if (num.contains(2)) {
						h2 = 2;
						int ih2 = num.indexOf(2);
						num.remove(ih2);
						int num2 = Collections.max(num);
						int im12 = num.indexOf(num2);
						int num1 = num.get(0);
						num.remove(im12);
						if ( num1 < 6 ) {
							if ( num2 < 6 ) {
								m1 = num2; m2 = num1;
								System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
							} else {
								m2 = num2; m1 = num1;
								System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
							}
						} else {
							System.out.println("Time not possible");
						}
					} else if (num.contains(1)) {
						h2 = 1;
						int ih2 = num.indexOf(1);
						num.remove(ih2);
						int num2 = Collections.max(num);
						int im12 = num.indexOf(num2);
						int num1 = num.get(0);
						num.remove(im12);
						if ( num1 < 6 ) {
							if ( num2 < 6 ) {
								m1 = num2; m2 = num1;
								System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
							} else {
								m2 = num2; m1 = num1;
								System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
							}
						}
					} else if (num.contains(0)) {
						h2 = 0;
						int ih2 = num.indexOf(0);
						num.remove(ih2);
						int num2 = Collections.max(num);
						int im12 = num.indexOf(num2);
						int num1 = num.get(0);
						num.remove(im12);
						if ( num1 < 6 ) {
							if ( num2 < 6 ) {
								m1 = num2; m2 = num1;
								System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
							} else {
								m2 = num2; m1 = num1;
								System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
							}
						}
					} else {
						System.out.println("Time not possible");
					}
				} else {
					 System.out.println("Time not possible");
				}
			} else if (num.contains(1)) {
				h1 = 1;
				int ih1 = num.indexOf(1);
				num.remove(ih1);
				h2 = Collections.max(num);
				int ih2 = num.indexOf(h2);
				num.remove(ih2);
				int num2 = Collections.max(num);
				int im12 = num.indexOf(num2);
				int num1 = num.get(0);
				num.remove(im12);
				if ( num1 < 6 ) {
					if ( num2 < 6 ) {
						m1 = num2; m2 = num1;
						System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
					} else {
						m2 = num2; m1 = num1;
						System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
					}
				} else {
					System.out.println("Time not possible");
				} 
			} else if (num.contains(0)) {
				h1 = 0;
				int ih1 = num.indexOf(0);
				num.remove(ih1);
				h2 = Collections.max(num);
				int ih2 = num.indexOf(h2);
				num.remove(ih2);
				int num2 = Collections.max(num);
				int im12 = num.indexOf(num2);
				int num1 = num.get(0);
				num.remove(im12);
				if ( num1 < 6 ) {
					if ( num2 < 6 ) {
						m1 = num2; m2 = num1;
						System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
					} else {
						m2 = num2; m1 = num1;
						System.out.println(h1 + "" + h2 + ":" + m1 + "" +m2);
					}
				} else {
					System.out.println("Time not possible");
				}
			}
		} else {
			System.out.println("Time not possible");
		}
	}
}
