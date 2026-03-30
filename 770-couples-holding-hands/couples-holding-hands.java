class Solution {
    public int minSwapsCouples(int[] row){
        int m=row.length;
        int n=m/2;
        int[] par=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        for(int i=0;i<m;i+=2){
            int a=row[i]/2;
            int b=row[i+1]/2;
            Rankunion(a,b,par,rank);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(par[i]==i) ans++;
        }
        return n-ans;
    }
    public boolean Rankunion(int x,int y,int[] par,int[] rank){
        int px=find(x,par);
        int py=find(y,par);
        if(px==py) return false;
        if(rank[px]>rank[py]){
            par[py]=px;
        }else if(rank[px]<rank[py]){
            par[px]=py;
        }else{
            par[py]=px;
            rank[px]++;
        }
        return true;
    }

    public int find(int x, int[] par){
        if(x!=par[x]){
            par[x]=find(par[x],par); 
        }
        return par[x];
    }
}