class Solution {
    static class Pair{
        int node;
        int cost;
        public Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:times){
            int u=edge[0]-1;
            int v=edge[1]-1;
            int w=edge[2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[k-1]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        q.offer(new Pair(k-1,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int u=curr.node;
            int d=curr.cost;
            if(d>ans[u]) continue;  //mil decrease key via lazy deletion
            for(Pair p:adj.get(u)){
                int v=p.node;
                int costu_v=p.cost;
                if(ans[v]>d+costu_v){
                    ans[v]=d+costu_v;
                    q.offer(new Pair(v,ans[v]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,ans[i]);
        }
        return max;
    }
}