public class Interview {

	public static void main(String[] args) {
		int[] a = { 1, 4, 3, 1, 3 };
		System.out.println(solution(a));
	}

  // ZigZag pattern : There is a garden with trees of different heights
  // Gardner can cut 1 tree and wanted to make the garden look in a zigzag pattern(one greater and one less but not equal heights)
  // input : Array with the tree sizes
  // output : -1 (if not possible) Eg : { 1, 2, 3, 4}
  //  0 {1,4,1,5,2,4,1,6}
  //  number of possible ways. Eg 3 { 3, 4, 5, 3, 7 }
  // => {4, 5, 3, 7}, {3, 5, 3, 7}, {3, 4, 3, 7}
	public static int solution(int[] A) {
		if (A.length == 1) {
			return 0;
		}
		if (A.length == 2) {
			return (A[0] != A[1]) ? 0 : 1;
		}
		boolean track = A[0] < A[1];
		int ano = A[0] == A[1] ? 1 : 0, index = 0;
		for (int i = 2; i < A.length; i++) {
			if ((A[i] != A[i - 1]) && ((A[i] < A[i - 1] && track) || (A[i] > A[i - 1] && !track))) {
				track = !track;
			} else {
				ano++;
				index = i - 1;
				if (ano > 1) {
					return -1;
				}
			}
		}
		if (ano == 0)
			return 0;
		if (index == 1 || index == A.length - 1) {
			if (A[1] != A[3] || A[A.length - 1] != A[A.length - 3]) {
				return 3;
			} else {
				return 2;
			}
		} else {
			return 2;
		}
	}
}
