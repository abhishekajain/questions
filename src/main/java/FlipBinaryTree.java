import java.util.ArrayList;
import java.util.List;

public class FlipBinaryTree {
	
	public TreeNode flip90(TreeNode root) {
		return null;
	}
	
	private TreeNode flip(TreeNode node) {
		TreeNode temp = node.left;
		node.left.left = node.right;
		node.left.right = node;
		node.left = null;
		node.right = null;
		return temp;
	}
	
	public void traverseLRR(TreeNode root) {
		if(root == null) {
			return;
		}
		List<Integer> list = new ArrayList<Integer>();
		traverse(root, list);
		System.out.println(list);
	}
	private void traverse(TreeNode node, List<Integer> list) {
		if(node.left != null) {
			traverse(node.left, list);
		}
		list.add(node.val);
		if(node.right != null) {
			traverse(node.right, list);
		}
	}
	
	static class TreeNode{
		int val;
		TreeNode right;
		TreeNode left;
		
		public TreeNode(){
			
		}
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		FlipBinaryTree fbt = new FlipBinaryTree();
		fbt.traverseLRR(root);
	}

}
