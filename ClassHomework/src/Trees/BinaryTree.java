package Trees;

public class BinaryTree {
	
	private TreeNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void add(String word) {
		TreeNode n = new TreeNode(word);
		
		if(root == null) {
			root = n;
		} else {
			addToTree(root, n);
		}
	}
	
	public void addToTree(TreeNode node, TreeNode n) {
		
	}
	
	
	public class TreeNode {
		String val;
		TreeNode left, right;
		
		TreeNode(Object value) {
			val =(String) value;
			left = null;
			right = null;
		}
		
		TreeNode(String v, TreeNode l, TreeNode r) {
			val = v;
			left = l;
			right = r;
		}
		
		String getValue() {return val;}
		TreeNode getLeft() {return left;}
		TreeNode getRight() {return right;}
		
		void setValue(String v) {val = v;}
		void setLeft(TreeNode l) {left = l;}
		void setRight(TreeNode r) {right = r;}
		
	}
}
