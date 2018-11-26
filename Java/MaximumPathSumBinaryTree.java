/*
find maximum path sum for all paths from leaf to root in a Binary Tree 
 */

import java.util.*;

public class MaximumPathSumBinaryTree {
	
	public class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int k) {
			key = k;
		}
	}
	
	// key point: carry a direct up or direct down path prefix while traversing the tree
	// Time: O(n), Space: O(height)
	public void findMaxPath(TreeNode root, List<Integer> pathPrefix, int[] globalMax) {
		// base case 1: leaf node's next level (root == null)
		if (root == null) {
			return;
		}
		// base case2: leaf node
		if (root.left == null && root.left == null) {
			globalMax[0] = Math.max(globalMax[0], sumPath(pathPrefix));
			return;
		}
		
		// recursive rules
		pathPrefix.add(root.key);  // choose
		findMaxPath(root.left, pathPrefix, globalMax); // explore
		findMaxPath(root.right, pathPrefix, globalMax);
		pathPrefix.remove(pathPrefix.size() - 1); // unchoose  !!!!
	}
	
	private int sumPath(List<Integer> pathPrefix) {
		int sum = 0;
		for (Integer i : pathPrefix) {
			sum += i;
		}
		return sum;
	}
	
	// optimized

}
