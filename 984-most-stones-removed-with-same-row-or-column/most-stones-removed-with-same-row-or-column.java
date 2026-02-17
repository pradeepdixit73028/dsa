class Solution {
    public int removeStones(int[][] stones) {
         int n = stones.length;
        int par[] = new int[20005];
        int rank []= new int[20005];
        int offset = 10001;
        for(int i =0;i<20005;i++){
            par[i] =i;
            rank[i] =0;
        }
        for(int s[]:stones){
            Rankunion(s[0],s[1]+offset,par,rank);
        }
        Set<Integer> st = new HashSet<>();
        for(int stone[]:stones){
            st.add(find(stone[0],par));
        }
        return n - st.size();
        
        
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