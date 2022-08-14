/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int left_subtree_depth = maxDepth(root.left);
        int right_subtree_depth = maxDepth(root.right);
        
        return Math.max(left_subtree_depth, right_subtree_depth)+1;
        
    }
    
}

/*
Time Complexity - o(n) where n is the no of nodes in the tree
Space Complexity - o(h) where h is the height of the tree, to hold the recursive call stack
*/