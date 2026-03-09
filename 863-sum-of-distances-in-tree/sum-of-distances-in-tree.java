class Solution {
    List<Integer>[] tree;
    static int[] dist;
    static int[] ans;
    static int[] subtree;
    static int N;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N=n;
        ans=new int[n];
        dist=new int[n];
        subtree=new int[n];
        Arrays.fill(subtree,1);
        tree=new ArrayList[n];
        for(int i=0;i<n;i++) tree[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(0,-1);
        ans[0]=dist[0];
        reroot(0,-1);
        return ans;
    }
    public void dfs(int node,int parent){
        for(int child:tree[node]){
            if(child==parent) continue;
            dfs(child,node);
            subtree[node]+=subtree[child];
            dist[node]+=subtree[child]+dist[child];
        }
    }
    public void reroot(int node,int parent){
        for(int child:tree[node]){
            if(child==parent) continue;
            ans[child]=ans[node]+N-2*subtree[child];
            reroot(child,node);
        }
    }
}