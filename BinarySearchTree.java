package ds;

public class BinarySearchTree {
	public TreeNode root;
	
	public BinarySearchTree () {
		root = null;
	}
	
	public void postorder_tree_walk (TreeNode x) {
		if (x == null)
			return;
		System.out.println(x.key + " ");
		inorder_tree_walk(x.left);
		inorder_tree_walk(x.right);
	}
	
	public void preorder_tree_walk (TreeNode x) {
		if (x == null)
			return;
		System.out.println(x.key + " ");
		inorder_tree_walk(x.left);
		inorder_tree_walk(x.right);
	}
	
	public void inorder_tree_walk (TreeNode x) {
		if(x  == null) 
			return;
		inorder_tree_walk(x.left);
		System.out.println(x.key + " ");
		inorder_tree_walk(x.right);
	}

	public TreeNode search (TreeNode x, int k) {
		if (x == null || x.key == k)
		return x;
		if (k < x.key) 
			return search (x.left, k);
			return search (x.right,k);	
	}  
	
	public TreeNode iterative_search (int k) {
		if (root == null)
			return null;
		TreeNode temp = root;
		while(temp != null) {
			if (k < temp.key) 
				temp = temp.left;
			else if (k > temp.key) 
				temp = temp.right;
			else
				return temp;
		}
		return temp;
	}
	
	public TreeNode minimum () {
		TreeNode temp = root;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}
	
	public TreeNode maximum () {
		TreeNode temp = root;
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}
	
	public TreeNode successor (TreeNode x) {
		if (x.right != null) {
			TreeNode temp = x.right;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
		}
		TreeNode sucs = null;
		TreeNode temp = root;
		while (temp != null) {
			if (x.key < temp.key) {
				sucs = root;
				temp = temp.left;
			}
			else if (x.key > temp.key)
				temp = temp.right;
			else
				break;
		}
		return sucs;
	}
		
	public TreeNode insert (int k) {
		if(root == null) {
			root = new TreeNode(k);
		return root;
		}
		TreeNode temp = root;
		TreeNode prev = null;
		while(temp != null) {
			prev = temp;
			if (k < temp.key) {
				temp = temp.left;
			}
			else {
				temp = temp.right;
			}
		}
		if (k < prev.key) {
			prev.left = new TreeNode(k);
		}
		else {
			prev.right = new TreeNode(k);
			}
		return prev;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9};
		BinarySearchTree bst;
		TreeNode n;
		
		bst = new BinarySearchTree();
		for (int i = 0; i < array.length; i++)
			bst.insert(array[i]);
		
		System.out.println("Inorder_tree_walk starts ------------------");
		bst.inorder_tree_walk(bst.root);
		System.out.println("Inorder_tree_walk ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Search starts ------------------");
		n = bst.search(bst.root, 13);
		System.out.println("found: " + n.key);
		System.out.println("Search ends ------------------");
		System.out.print("\n\n");

		System.out.println("Iterative search starts ------------------");
		n = bst.iterative_search(4);
		System.out.println("found: " + n.key);
		System.out.println("Iterative search ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Minimum starts ------------------");
		n = bst.minimum();
		System.out.println("Minimum key is " + n.key);
		System.out.println("Minimum ends ------------------");
		System.out.print("\n\n");
		
		System.out.println("Maximum starts ------------------");
		n = bst.maximum();
		System.out.println("Maximum key is " + n.key);
		System.out.println("Maximum ends ------------------");
		System.out.print("\n\n");

		System.out.println("Successor starts ------------------");
		n = bst.successor(bst.root.left.right.right);
		System.out.println("Successor key is " + n.key);
		System.out.println("Successor ends ------------------");
		System.out.print("\n\n");
	}

}

