package Trees;

public class TreeNode {

		Object val;
		TreeNode left, right;
		
		TreeNode(Object value) {
			val = value;
			left = null;
			right = null;
		}
		
		TreeNode(Object v, TreeNode l, TreeNode r) {
			val = v;
			left = l;
			right = r;
		}
		
		
		Object getValue() {return val;}
		TreeNode getLeft() {return left;}
		TreeNode getRight() {return right;}
		
		void setValue(Object v) {val = v;}
		void setLeft(TreeNode l) {left = l;}
		void setRight(TreeNode r) {right = r;}
		

}
