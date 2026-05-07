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
    boolean ans=true;
    public boolean isBalanced(TreeNode root) {
        int height=checkHeight(root);
        return ans;
    }

    private int checkHeight(TreeNode node) {
        if(node==null){
            return 0;
        }
        int left=checkHeight(node.left);
        int right=checkHeight(node.right);
        if(Math.abs(left-right)>1) ans=false;

        return Math.max(left,right)+1;
    }
}