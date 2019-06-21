public class FooBar1 {
	public static void main(String[] args) {
		for (int i : solution(3, new int[] { 7, 3, 5, 1, 100 })) {
			System.out.println(i);
		}
	}

	public static int[] solution(int h, int[] q) {
		for (int i = 0; i < q.length; i++) {
			q[i] = parent(h, q[i]);
		}
		return q;
	}

	public static int parent(int h, int node) {

		int parent = (int) Math.pow(2, h) - 1;
		if (node >= parent)
			return -1;

		int offset = 0;
		boolean find = true;
		int subtreeSize = parent;

		while (find) {
			subtreeSize /= 2;
			int leftNode = offset + subtreeSize;
			int rightNode = leftNode + subtreeSize;
			parent = rightNode + 1;
			if ((node == leftNode) || (node == rightNode)) {
				find = false;
				return parent;
			}
			if (node > leftNode) {
				offset = leftNode;
			}
		}
		return -1;
	}
}
