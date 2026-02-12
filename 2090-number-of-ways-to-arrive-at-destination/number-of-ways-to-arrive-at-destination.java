class Solution {
    static final int mod=1000000007;
    static class Pair{
        int node;
        long cost;
        public Pair(int node,long cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int countPaths(int n, int[][] roads){
        int m=roads.length;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            long w=road[2];
	        adj.get(u).add(new Pair(v,w));
		    adj.get(v).add(new Pair(u,w));

        }
        int[] ways=new int[n];
        long[] ans=new long[n];
        Arrays.fill(ans,Long.MAX_VALUE);
        ans[0]=0;
        ways[0]=1;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        q.offer(new Pair(0,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int u=curr.node;
            long d=curr.cost;
            if(d>ans[u]) continue;  //mil decrease key via lazy deletion
            for(Pair p:adj.get(u)){
                int v=p.node;
                long costu_v=p.cost;
                if(ans[v]>ans[u]+costu_v){
                    ans[v]=ans[u]+costu_v;
		            ways[v]=ways[u];
                    q.offer(new Pair(v,ans[v]));
                }else if(ans[v]==(ans[u]+costu_v)){
                    ways[v]=(ways[u]+ways[v])%mod;
                }
            }
        }
        return ways[n-1];
    }
}