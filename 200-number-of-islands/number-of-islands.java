class Solution {
    int[] diff={0,1,0,-1,0};
    public int numIslands(char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid,int i,int j,int n,int m){
        grid[i][j]='0';
        for(int d=0;d<4;d++){
            int newi=i+diff[d],newj=j+diff[d+1];
            if(newi>=0 && newi<n && newj>=0 && newj<m && grid[newi][newj]=='1')
                dfs(grid,newi,newj,n,m);
        }
    }
}