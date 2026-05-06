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
    class Pair{
        TreeNode node;
        int idx;
        public Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int firstindex = q.peekFirst().idx;
            int lastindex = q.peekLast().idx;
            maxWidth = Math.max(maxWidth,lastindex-firstindex+1);
            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                int idx1 = curr.idx;
                if(node.left!=null){
                    q.offer(new Pair(node.left,2*idx1+1));
                }
                if(node.right!= null){
                    q.offer(new Pair(node.right, 2*idx1+2));
                }
            }
        }
        return maxWidth;
    }
}