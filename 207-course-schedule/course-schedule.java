class Solution {
    public boolean canFinish(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int[] indegree=new int[V];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            indegree[v]++;
            adj.get(u).add(v);
            
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            ans.add(curr);
            for(int i:adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        return ans.size()==V;
    }
}