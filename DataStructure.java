import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DataStructure {
	public static void main(String[] args) {

		// Array - fixed size with continuous memory location
		int[] integerArray = new int[2]; // new int[]{1, 2};
		// byte, boolean, int, String, long

		// Matrix is a 2D array
		int[][] matrix = new int[][] {};

		// List - dynamic sized
		// Abstract - List
		// Implementation - ArrayList, LinkedList, Stack(extends Vector), Vector

		// Allow duplicates and access by index
		List list = new ArrayList<String>();

		// Access by head element with even node pointing to next
		// Other variation uses
		// LinkedList, DoubleLinkedList, CircularLinkedList,

		// LinkedList implementation - List, Deque, Queue
		list = new LinkedList<>();

		// LIFO(Last in First out) list
		// push, pop, peek, search
		list = new Stack();

		// FIFO(First in First out) Queue
		// add, offer, poll, peak
		Queue queue = new PriorityQueue();
		queue = new LinkedList<>();

		// Queue vs Deque
		// Queue inserts elements at the end and removed from begining
		// Deque allows access from both sides
		Deque dequeue = new LinkedList<>();

		// Tree
		Node node = new Node(0);

		// BinaryTree - Tree with two children
		// BST Tree with small value elements on right and big value elements to left
		// Easy searching of elements
		// Leaf node is the node with no children

		// Full Binary Tree - Tree with both children
		// Complete Binary Tree - Tree with all level filled from left except the last
		// Perfect Binary Tree - Tree with all levels filled
		// Balanced Binary Tree - Tree where left and right subtree differ by one max

		// Binary Tree Traversal - PreOrder, InOrder, PostOrder, LevelOrder

		// Traversing a tree - DFS, BFS
		// BFS - Breadth First Search we use level order traversal
		// DFS - Depth First Search we use with pre, in or post order traversal

		// Heaps - Special tree based data structure
		// Min Heap - Root has the smallest values of the tree
		// Max Heap - Root is the biggest of the tree

		// Graph is Node with many neighbors
		// Types - undirected, directed, weighted
		// DFS/BFS to traverse the graph

		// Tries(try, tri, digital tree, radix tree, prefix tree)
		// refer - avadhaniamogh/trie_tree_search
	}

	public void preOrderTraversal(Node root) { // root, left, right
		if (root == null)
			return;
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public void inOrderTraversal(Node root) { // left, root, right
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	}

	public void postOrderTraversal(Node root) { // left, right, root
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.data);
	}

	public HashMap<Integer, List<Node>> levelOrderTraversal(Node root, int level, HashMap<Integer, List<Node>> levels) {
		if (root == null)
			return levels;

		List<Node> temp = levels.getOrDefault(level, new ArrayList<>());
		temp.add(root);
		levels.put(level, temp);
		levelOrderTraversal(root.left, level + 1, levels);
		levelOrderTraversal(root.right, level + 1, levels);

		return levels;
	}

}

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
	}
}

class TrieNode {
	HashMap<Character, TrieNode> children = new HashMap<>();
	char c;
	boolean isLeaf;

	public TrieNode() {
	}

	public TrieNode(char c) {
		this.c = c;
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}

class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.getChildren();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node;
			if (children.containsKey(c)) {
				node = children.get(c);
			} else {
				node = new TrieNode(c);
				children.put(c, node);
			}
			children = node.getChildren();

			if (i == word.length() - 1) {
				node.setLeaf(true);
			}
		}
	}

	public boolean search(String word) {
		HashMap<Character, TrieNode> children = root.getChildren();

		TrieNode node = null;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (children.containsKey(c)) {
				node = children.get(c);
				children = node.getChildren();
			} else {
				node = null;
				break;
			}
		}

		if (node != null && node.isLeaf()) {
			return true;
		} else {
			return false;
		}
	}

}
