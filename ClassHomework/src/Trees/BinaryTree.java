package Trees;

public class BinaryTree {
	
	private TreeNode root;
	
	public BinaryTree(Trees.TreeNode n) {
		root = n;
	}
	

	public void add(char word) {
		TreeNode n = new TreeNode(word);
		
		if(root == null) {
			root = n;
		} else {
			addToTree(root, n);
		}
	}
	
	public void addToTree(TreeNode node, TreeNode n) {
		
	}
	
}
