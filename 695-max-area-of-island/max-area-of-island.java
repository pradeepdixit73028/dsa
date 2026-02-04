class Solution {
    static int n, m;
    public int maxAreaOfIsland(int[][] grid){
        n=grid.length;
        m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    ans= Math.max(ans,dfs(grid,visited,i,j));
                }
            }
        }
        return ans;
    }
    public int dfs(int[][] grid,boolean[][] visited,int i,int j){
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0||visited[i][j]) return 0;
        visited[i][j]=true;
        return 1+dfs(grid,visited,i+1,j)+dfs(grid,visited,i-1,j)+dfs(grid,visited,i,j+1)+dfs(grid,visited,i,j-1);
    }
}