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
        if(root==null || !is_contain(root,p) || !is_contain(root,q)){
            return null;
        }
        
        if(root == p || root == q){
            return root;
        }
        
        boolean p_is_left = is_contain(root.left, p);
        boolean q_is_left = is_contain(root.left, q);
        
        // if p and q are in different sub-tree 
        if(p_is_left != q_is_left){
            return root;
        }
        
        TreeNode subtree = (p_is_left == true) ? root.left : root.right;
        
        // Traversal condition
        return lowestCommonAncestor(subtree, p, q);
        
    }
    
    // Helper function to check if the tree/subtree contains node
    public boolean is_contain(TreeNode root, TreeNode node){
        // base case
        if(root == null){
            return false;
        }
        // actual condition check
        if(root == node){
            return true;
        }
        return is_contain(root.left, node) || is_contain(root.right, node);
        
    }
}

/*
Time Complexity: o(n), where n is the total no. of nodes = In worst case you have to scan the entire tree
Space Complexity: o(h), where h is the height of the tree
*/