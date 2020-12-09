import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// LC 545 boundaryOfBinaryTree
public class BoundaryofBinaryTree {
	class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	       if (root == null) {
	           return new ArrayList<>();
	       }
	        List<Integer> leftList = new ArrayList<>();
	        if (root.left == null && root.right == null) {
	            leftList.add(root.val);
	            return leftList;
	        }
	      
	    
	      findLeft(root.left, leftList);
	        
	      findBot(root, leftList);
	      // findBot(root.right, leftList);
	        
	      findRight(root.right, leftList);
	        
	      
	        leftList.add(0, root.val);
	      return leftList;
	     }
	    
	     private void findLeft(TreeNode root, List<Integer> leftList) {
	      if (root == null || root.left == null && root.right == null) {
	       return;
	      }
	      leftList.add(root.val);
	      if (root.left == null) {
	       findLeft(root.right, leftList);
	      } else {
	       findLeft(root.left, leftList);
	      }
	     }
	    
	     private void findBot(TreeNode root, List<Integer> botList) {
	      if (root == null) {
	       return;
	      }
	      if (root.left == null && root.right == null) {
	       botList.add(root.val);
	          return;
	      }
	      findBot(root.left, botList);
	      findBot(root.right, botList);
	     }
	    
	     private void findRight(TreeNode root, List<Integer> rightList) {
	      if (root == null || root.left == null && root.right == null) {
	       return;
	      }
	      
	      if (root.right == null) {
	       findRight(root.left, rightList);
	      } else{
	       findRight(root.right, rightList);
	      }
	         rightList.add(root.val);
	     }
}
