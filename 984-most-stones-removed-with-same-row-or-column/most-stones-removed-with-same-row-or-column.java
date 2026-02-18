class Solution {
    static int component;
    public int removeStones(int[][] stones) {
        int n = stones.length;
        component=n;
        int par[] = new int[n];
        int rank []= new int[n];
        for(int i =0;i<n;i++){
            par[i] =i;
            rank[i] =0;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    Rankunion(i,j,par,rank);
                }
            }
        }
        return n - component;
        
        
    }
    public boolean  Rankunion(int x, int y, int par[],int rank[]){
        int px = find(x,par);
        int py = find(y,par);
        if(px == py){
            return false;
        }
        if(rank[px] > rank[py]){
            par[py] = px;
        }
        else if(rank[px] < rank[py]){
            par[py] = px;
        }
        else {
            par[px] = py;
            rank[py]++;
        }
        component--;
        return true;
        
    }
    public int find(int x, int par[]){
        if(x==par[x]){
            return x;
        }
        par[x] = find(par[x],par);
        return par[x];
    }
        
    
}