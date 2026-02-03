class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        for(int i=1;i<=n;i++){
            int ans=adjList.get(i).size();
            if(ans==n-1)
                return i;
        }

        return -1;
    }
}
