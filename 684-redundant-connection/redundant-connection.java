class Solution {
    static int[] parent;
    static int[] rnk;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rnk=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rnk[i]=1;
        }
        int[] ans=new int[2];
        for(int[] edge:edges){
            int i=edge[0];
            int j=edge[1];
            if(!union(i,j)){
                ans[0]=i;
                ans[1]=j;
            }
        }
        return ans;
        
    }
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public boolean union(int x,int y){
        int par_x=find(x);
        int par_y=find(y);
        if(par_x==par_y){
            return false;
        }
        if(rnk[par_x]>rnk[par_y]){
            parent[par_y]=par_x;
        }else if(rnk[par_x]<rnk[par_y]){
            parent[par_x]=par_y;
        }else{
            parent[par_y]=par_x;
            rnk[par_x]++;
        }
        return true;
    }
    
}