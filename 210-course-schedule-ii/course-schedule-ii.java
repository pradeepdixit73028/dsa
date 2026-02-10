class Solution {
    public int[] findOrder(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] ans=new int[V];
        int[] indegree=new int[V];
        for(int[] edge:edges){
            int v=edge[0];
            int u=edge[1];
            indegree[v]++;
            adj.get(u).add(v);
            
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int a=-1;
        while(!q.isEmpty()){
            int curr=q.poll();
            ans[++a]=curr;
            for(int i:adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        if(a==V-1) return ans;
        else return new int[0];
    }
}