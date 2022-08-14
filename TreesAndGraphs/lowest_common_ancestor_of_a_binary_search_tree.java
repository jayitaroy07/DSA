/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Basic check
        if(root == null || root == p || root == q){
            return root;
        }
        
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
        
    }
}

/*
Time Complexity - o(n) where n is the total number of nodes, in the worst case we have to traverse the entire tree
Space Complexity - o(h) where h is the height of the tree, to hold the recursive call stack
*/