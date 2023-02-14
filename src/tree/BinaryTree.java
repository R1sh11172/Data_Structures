package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	TreeNode root; 
	
	public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {

        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.val) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

	
	public void preOrderTraversal(TreeNode node) { //depth-first search variant 1
		if (node != null) {
	        System.out.print(" " + node.val);
	        preOrderTraversal(node.left);
	        preOrderTraversal(node.right);
	    }
    }
	public void traverseInOrder(TreeNode node) { //depth-first search variant 1
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.val);
	        traverseInOrder(node.right);
	    }
	}
	public void postOrderTraversal(TreeNode node) { //depth-first search variant 1
	    if (node != null) {
	    	postOrderTraversal(node.left);
	    	postOrderTraversal(node.right);
	        System.out.print(" " + node.val);  
	    }
	}
	
	public void bfs() { //breadth-first search (level-order traversal)
		if (root != null) {
			Queue<TreeNode> nodes = new LinkedList<>();
			nodes.add(root); 
			
			while (!nodes.isEmpty()) {
				TreeNode node = nodes.remove();

		        System.out.print(" " + node.val);

		        if (node.left != null) {
		            nodes.add(node.left);
		        }

		        if (node.right != null) {
		            nodes.add(node.right);
		        }
			}
		}
	}
}
