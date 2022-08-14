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
// Follow Up Question : Does the tree contain any negative integer ?

class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

    	maxPathSumRec(root);

    	return maxSum;
    }

    public int maxPathSumRec(TreeNode node){
    	// base case
    	if(node == null){
    		return 0;
    	}

    	// The Math.max comparison is applicable only if the tree contains -ve integer
    	int left_sum = Math.max(0, maxPathSumRec(node.left));
    	int right_sum = Math.max(0, maxPathSumRec(node.right));

    	maxSum = Math.max(maxSum, left_sum + right_sum + node.val);

    	return Math.max(left_sum, right_sum) + node.val;
    }
}

/** Example:
Input: root = [-10,9,20,null,null,15,7]
Output: 42

     -10
      /\
     9  20
         /\
   	    /  \
      15   7

	1. maxPathSumRec(-10) -> maxSum = 20+15+7, return -10+20+15
	2. maxPathSumRec(9) -> maxSum = 9, return = 9
	3. maxPathSumRec(null) -> returns 0;
	4. maxPathSumRec(null) -> return 0;
	5. maxPathSumRec(20) -> maxSum = 20+15+7, return = 20+15
	6. maxPathSumRec(15) -> maxSum = 15, return 15
	7. maxPathSumRec(null) -> return 0
	8. maxPathSumRec(null) -> return 0
	9. maxPathSumRec(7) -> maxSum = 15, return 7
	10. maxPathSumRec(null) -> return 0
	11. maxPathSumRec(null) -> 0

*/
        