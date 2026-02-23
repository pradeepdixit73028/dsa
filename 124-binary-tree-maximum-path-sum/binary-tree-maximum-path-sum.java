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
    int maxpath=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxpath;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        
        int leftsum=helper(root.left);
        int rightsum=helper(root.right);
        if(leftsum<0) leftsum=0;
        if(rightsum<0) rightsum=0;
        maxpath=Math.max(maxpath,root.val+leftsum+rightsum);
        return root.val+Math.max(leftsum,rightsum);
    }
}