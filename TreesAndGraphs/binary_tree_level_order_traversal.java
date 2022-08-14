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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        
        // Basic check
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            // get the no of nodes in the current level
            int size = queue.size();
            List<Integer> curr_level = new ArrayList();
            
            // process the current node and add their children to the queue to process in the next iteration
            for(int i=0; i<size; i++){
                TreeNode curr_node = queue.poll();
                curr_level.add(curr_node.val);
                
                if(curr_node.left != null){
                    queue.offer(curr_node.left);
                }
                if(curr_node.right != null){
                    queue.offer(curr_node.right);
                }
                
            }
            
            result.add(curr_level);
        }
        
        return result;
        
    }
}
/*
Time Complexity: o(n) where n is the number of node in the tree
Space Complexity: o(n) since we will be returning the list containing all the nodes in the tree
*/