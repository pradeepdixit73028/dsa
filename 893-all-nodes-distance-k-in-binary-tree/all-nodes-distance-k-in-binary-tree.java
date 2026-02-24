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
    Map<TreeNode,TreeNode> pmap=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        buildpmap(root,null);
        Set<TreeNode> visited=new HashSet<>();
        int dis=0;
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            if(dis==k) break;
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
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;

    }
    public void buildpmap(TreeNode node, TreeNode parent){
        if(node==null) return;
        pmap.put(node,parent);
        buildpmap(node.left,node);
        buildpmap(node.right,node);
    }
}