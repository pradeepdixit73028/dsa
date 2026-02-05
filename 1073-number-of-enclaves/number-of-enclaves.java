class Solution {
    static int n,m;
    public int numEnclaves(int[][] grid){
        n=grid.length;
        m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||i==n-1||j==m-1){
                    if(grid[i][j]==1 && !visited[i][j]){
                        dfs(i,j,grid,visited);
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
    public void dfs(int i,int j,int[][] grid,boolean[][] visited){
        if(i<0||j<0||i>=n||j>=m||visited[i][j]||grid[i][j]!=1) return;
        visited[i][j]=true;
        grid[i][j]=0;
        dfs(i+1,j,grid,visited);
        dfs(i,j+1,grid,visited);
        dfs(i-1,j,grid,visited);
        dfs(i,j-1,grid,visited);
    }
}