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
    Map<TreeNode,TreeNode> pmap=new HashMap<>();
    TreeNode target;
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q=new LinkedList<>();
        buildpmap(root,null,start);
        Set<TreeNode> visited=new HashSet<>();
        int dis=0;
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                TreeNode par=pmap.get(curr);

                if(par!=null && !visited.contains(par)){
                    visited.add(par);
                    q.offer(par);
                }
            }
            dis++;
        }
        
        return dis-1;

    }
    public void buildpmap(TreeNode node, TreeNode parent,int start){
        if(node==null) return;
        pmap.put(node,parent);
        if(node.val==start) target=node;
        buildpmap(node.left,node,start);
        buildpmap(node.right,node,start);
    }
    
}