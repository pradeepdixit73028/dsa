class Solution {
    ArrayList<ArrayList<Integer>> adj;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited=new boolean[n];
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
			adj.add(new ArrayList<Integer>());
		}
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
		    adj.get(v).add(u);
        }
		dfs(source,visited);
    	return visited[destination];
	}
    void dfs(int s,boolean[] visited){
        visited[s]=true;
        for(int x:adj.get(s)){
            if(!visited[x])
            dfs(x,visited);
        }
    }
}