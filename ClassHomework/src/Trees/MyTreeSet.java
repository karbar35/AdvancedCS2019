package Trees;

// Implements a BST with TreeNode nodes

import java.util.Stack;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
// Normally, TreeNode and MyTreeSet would be "generic" (type-specific)
// classes and hold Comparable objects, but this is beyond the scope of
// the Java Methods book. Without @SuppressWarnings, this class would give
// three "Unchecked cast" warnings.

public class MyTreeSet implements Iterable<Object> {

	private TreeNode root; // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyTreeSet() {
		root = null;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(Object value) {
		return contains(root, value);
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(Object value) {
		if (contains(value))
			return false;
		root = add(root, value);
		return true;
	}

	// Removes value from this BST. Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(Object value) {
		if (!contains(value))
			return false;
		root = remove(root, value);
		return true;
	}

	// Returns a string representation of this BST.
	public String toString() {
		String str = toString(root);
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		return "[" + str + "]";
	}

	// Returns an iterator for this BST.
	public Iterator<Object> iterator() {
		return new MyTreeSetIterator(root);
	}

	// *************** Private helper methods: *********************

	// Returns true if the BST rooted at node contains value;
	// otherwise returns false (recursive version).

	private boolean contains(TreeNode node, Object value) {
		if (node == null)
			return false;
		else {
			int diff = ((Comparable<Object>) value).compareTo(node.getValue());
			if (diff == 0) {
				return true;
			} else if (diff < 0) {
				return contains(node.getLeft(), value);
			} else {// if (diff > 0)
				return contains(node.getRight(), value);
			}
		}
	}

	/*
	 * // Iterative version: private boolean contains(TreeNode node, Object value) {
	 * while (node != null) { int diff =
	 * ((Comparable<Object>)value).compareTo(node.getValue()); if (diff == 0) return
	 * true; else if (diff < 0) node = node.getLeft(); else // if (diff > 0) node =
	 * node.getRight(); } return false; }
	 */

	// Adds value to the BST rooted at node. Returns the
	// root of the new tree.
	// Precondition: the tree rooted at node does not contain value.
	private TreeNode add(TreeNode node, Object value) {
		if (node == null)
			node = new TreeNode(value);
		else {
			int diff = (Integer.toString((int) value)).compareTo(Integer.toString((int) node.getValue()));
			if (diff < 0)
				node.setLeft(add(node.getLeft(), value));
			else // if (diff > 0)
				node.setRight(add(node.getRight(), value));
		}
		return node;
	}

	// Removes value from the BST rooted at node.
	// Returns the root of the new tree.
	// Precondition: the tree rooted at node contains value.
	private TreeNode remove(TreeNode node, Object value) {
		int diff = ((Comparable<Object>) value).compareTo(node.getValue());
		if (diff == 0) // base case
			node = removeRoot(node);
		else if (diff < 0)
			node.setLeft(remove(node.getLeft(), value));
		else // if (diff > 0)
			node.setRight(remove(node.getRight(), value));
		return node;
	}

	// Removes the root of the BST rooted at root
	// replacing it with the smallest node from the right subtree.
	// Returns the root of the new tree.
	private TreeNode removeRoot(TreeNode root) {
		TreeNode smallest = null;
		TreeNode aboveSmallest = root;

		if (root.right != null && root.right.left == null) {
			smallest = root.right;
			smallest.left = root.left;

		} else {
			if (root.right != null) {
				smallest = root.right;
				aboveSmallest = root;
				while (smallest.left != null) {
					aboveSmallest = smallest;
					smallest = smallest.left;
				}
				aboveSmallest.left = smallest.right;
				smallest.left = root.left;
				smallest.right = root.right;
			} else {
				smallest = root.left;
			}
		}
		return smallest;
	}

	// Returns a string representation of the tree rooted at node.
	private String toString(TreeNode node) {
		
		if (node == null) {
			return "";
		}
		else {
			return toString(node.getLeft()) + node.getValue() + ", " + toString(node.getRight());
		}
	}

	// Implements an Iterator for this tree.
	private class MyTreeSetIterator implements Iterator<Object> {
		Stack<TreeNode> stack;

		public MyTreeSetIterator(TreeNode root) {
			stack = new Stack<TreeNode>();
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public Object next() {
			TreeNode node = stack.pop();
			int res = (int) node.val;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
			return res;
		}
		
	}

	// ************************** main: **************************

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 20; i++) {
			numbers.add((int) (Math.random() * 100));
		}
		MyTreeSet bst = new MyTreeSet();

		for (int num : numbers) {
			System.out.println("Added: " + num + " " + bst.add(num));
			System.out.println("Contains: " + num + " " + bst.contains(num));
			if (bst.add(num))
				System.out.println("*** Added a duplicate value ***");
			System.out.println(bst + "test");
		}

		// problem:
		System.out.println("Traversal with an iterator:");
		for (Object obj : bst)
			System.out.print(obj + " ");
		System.out.println();

		for (int num : numbers) {
			System.out.println("Removed: " + num + " " + bst.remove(num));
			if (bst.remove(num))
				System.out.println("*** Removed a non-existent value ***");
			System.out.println(bst + "");
		}
	}
}
