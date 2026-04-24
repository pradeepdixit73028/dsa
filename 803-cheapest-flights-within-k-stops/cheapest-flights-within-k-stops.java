class Solution {
    public class pair{
        int u,cost;
        public pair(int u,int cost){
            this.u=u;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] fly:flights){
            int u=fly[0];
            int v=fly[1];
            int c=fly[2];
            adj.get(u).add(new pair(v,c));

        }
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(src,0));
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE); 
        ans[src]=0;
        int stop=0;
        while(!q.isEmpty() && stop<=k){
            int size=q.size();
            while(size-->0){
                pair curr=q.poll();
                int s=curr.u;
                int d=curr.cost;
                for(pair neigh:adj.get(s)){
                    int v=neigh.u,costu_v=neigh.cost;
                    if(ans[v]>d+costu_v){
                        ans[v]=d+costu_v;
                        q.offer(new pair(v,ans[v]));
                    }
                }
            }
            stop++;

        }
        return ans[dst]==Integer.MAX_VALUE ? -1:ans[dst];
    }
}